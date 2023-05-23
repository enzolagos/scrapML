package cleanTest;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pages.ElementPage;
import singletonSession.Session;

import java.util.Arrays;

import static utils.ScreenShot.captureScreenshot;


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

    @Test
    public void testScrapNeumaticos() throws InterruptedException {
        try{
            System.out.println("hola");
            Thread.sleep(1000);
            if(homePage.closeNewsBtn.isControlDisplayed())
                homePage.closeNewsBtn.click();
            /*if (homePage.closeBestOffersNewsPopUp.isControlDisplayed()) {
                homePage.closeBestOffersNewsPopUp.click();
            }*/
            navbar.getCategoyButtonByOrder(1).click();
            Thread.sleep(1000);
            if (homePage.closeBestOffersNewsPopUp.isControlDisplayed()) {
                homePage.closeBestOffersNewsPopUp.click();
            }
            StringBuilder dataTablas;
            String urlCategoria = Session.getInstance().getBrowser().getCurrentUrl();
            category = urlCategoria.split("/")[urlCategoria.split("/").length - 1];

            for (int i = 0; i < categoryPage.numberOfPages(); i++) {

                for (int j = 1; j <= categoryPage.itemsInPage(); j++) {
                    categoryPage.findItem(j).click();
                    dataTablas = new StringBuilder();
                    if (j == 1 && i==0) {
                        elementPage.closeAd.click();
                        Thread.sleep(500);
                        elementPage.closeCookies.click();
                    }
//                    Thread.sleep(1300);
                    elementPage.verMasCaracteristicas.waitClickable();
                    elementPage.verMasCaracteristicas.click();

                    title = elementPage.titleLabel.getText();
                    for(int k = 1; k <= elementPage.tables.getAll().size();k++){
                        dataTablas.append(elementPage.getTableControl(k).getText()).append("|");
                    }
                    caracteristics = dataTablas.toString().replaceAll("\n", " ");
                    description = elementPage.descripcion.getText().replaceAll("\n"," ");
                    price = elementPage.precio.getAttribute("content");
                    url = Session.getInstance().getBrowser().getCurrentUrl();

                    data.add(new String[] { title, caracteristics, description, price, url, category});
                    Session.getInstance().getBrowser().navigate().back();
                }
                categoryPage.nextPageBtn.click();
            }
        } catch (Exception e) {
            // Captura la excepción y toma la captura de pantalla
            captureScreenshot(Session.getInstance().getBrowser(), "screenshot.png");
        }
    }
    @Test
    public void testScrapNeumaticos2() throws InterruptedException {
        /*if (homePage.closeBestOffersNewsPopUp.isControlDisplayed()) {
            homePage.closeBestOffersNewsPopUp.click();
        }*/
        categoryPage.findItem(1).click();
    }

}
