package cleanTest;

import org.junit.jupiter.api.Test;
import singletonSession.Session;

import static utils.ScreenShot.captureScreenshot;

public class EscobillasTest extends TestBaseScrapML{
    String title;
    String price;
    String caracteristics;
    String description;
    String category;
    String url;

    @Test
    public void testScrapService() throws InterruptedException{
        try{
            Thread.sleep(1000);
            if(homePage.closeNewsBtn.isControlDisplayed())
                homePage.closeNewsBtn.click();

            navbar.getCategoyButtonByOrder(5).click();
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

                    title = elementPage.titleLabel.getText();
                    //esto habria que sacarlo
                    if (elementPage.tables.waitExplicitVisibility(2)){
                        dataTablas.append(elementPage.tables.getText().replaceAll("\n"," ")+ "|");

                    }
                    if(elementPage.listaOtrosUL.waitExplicitVisibility(2)){
                        for(int k = 1; k <= elementPage.otrosLiLabel.getAll().size();k++){
                            dataTablas.append(elementPage.getLabelControl(k).getText()).append("|");
                        }
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
}}
