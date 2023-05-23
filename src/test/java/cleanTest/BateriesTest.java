package cleanTest;

import org.junit.jupiter.api.Test;
import pages.ElementPage;
import singletonSession.Session;

import java.util.Arrays;

public class BateriesTest {
    public ElementPage elementPage = new ElementPage();
    String title;
    String price;
    String caracteristics;
    String description;
    String category;
    String url;

    @Test
    public void verifyItRuns2() throws InterruptedException{
                StringBuilder dataListas = new StringBuilder();
        elementPage.closeAd.click();
        Thread.sleep(1000);
        elementPage.closeCookies.click();

        for(int i = 1; i <= elementPage.otrosLiLabel.getAll().size();i++){
            dataListas.append(elementPage.getLabelControl(i).getText()).append("|");
        }
        caracteristics = dataListas.toString().replaceAll("\n", " ");

        url = Session.getInstance().getBrowser().getCurrentUrl();
        title = elementPage.titleLabel.getText();
        description = elementPage.descripcion.getText().replaceAll("\n"," ");
        price = elementPage.precio.getAttribute("content");

        String[] csvLine = {title,caracteristics,description,price,url};

        System.out.println(Arrays.toString(csvLine));

    }
}
