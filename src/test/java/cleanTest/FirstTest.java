package cleanTest;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pages.ElementPage;
import singletonSession.Session;

import java.util.Arrays;


public class FirstTest extends TestBaseScrapML{
    public ElementPage elementPage = new ElementPage();
    String title;
    String price;
    String caracteristics;
    String description;
    String category;
    String url;

    @Test
    public void verifyItRuns() throws InterruptedException{
        System.out.println("hola");
        url = Session.getInstance().getBrowser().getCurrentUrl();
        title = elementPage.titleLabel.getText();

        StringBuilder dataTablas = new StringBuilder();
        Thread.sleep(1000);
        elementPage.closeAd.click();
        Thread.sleep(1000);
        elementPage.closeCookies.click();
        Thread.sleep(1000);
        elementPage.verMasCaracteristicas.click();
        Thread.sleep(1000 * elementPage.tables.getAll().size());
        for(int i = 1; i <= elementPage.tables.getAll().size();i++){
            dataTablas.append(elementPage.getTableControl(i).getText()).append("|");
        }
        caracteristics = dataTablas.toString().replaceAll("\n", " ");
        Thread.sleep(2000);

        description = elementPage.descripcion.getText().replaceAll("\n"," ");
        price = elementPage.precio.getAttribute("content");

        String[] csvLine = {title,caracteristics,description,price,url};
        data.add(csvLine);
        //System.out.println(Arrays.toString(csvLine));

    }

    /*@Test
    @Disabled
    public void testScrapNeumaticos() throws InterruptedException {
        String urlCategoria = Session.getInstance().getBrowser().getCurrentUrl();
        homePage.closeNewsBtn.click();
        homePage.closeNewsBtn2.click();
        navbar.getCategoyButtonByOrder(1).click();
        Thread.sleep(1000);
        homePage.closeNewsBtn2.click();

        category = urlCategoria.split("/")[urlCategoria.split("/").length - 1];
        for (int i = 0; i < 5; i++) {


            for (int j = 1; j <= categoryPage.itemsInPage; i++) {
                categoryPage.findItem(i).click();

                elementPage.closeCookies.click();
                elementPage.verMasCaracteristicas.click();

                title = elementPage.titleLabel.getText();
                caracteristics = elementPage.tables.getAll().get(1).getText();


                data.add(new String[] { "Name", "Class", "Marks" });

            }
        }
    }*/

}
