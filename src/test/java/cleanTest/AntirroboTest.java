package cleanTest;

import org.junit.jupiter.api.Test;

import singletonSession.Session;

import javax.swing.*;

import static utils.ScreenShot.captureScreenshot;

public class AntirroboTest extends TestBaseScrapML{
    String title;
    String price;
    String caracteristics;
    String description;
    String category;
    String url;


    @Test
    public void testScrapAntirrobo() throws InterruptedException{
        StringBuilder dataTablas;
        try{
            Thread.sleep(1000);
            if(homePage.closeNewsBtn.isControlDisplayed())
                homePage.closeNewsBtn.click();

            navbar.masCategoriasButton.click();
            navbar.antirrobosButton.click();

            if (homePage.closeBestOffersNewsPopUp.isControlDisplayed()) {
                homePage.closeBestOffersNewsPopUp.click();
            }
            String urlCategoria = Session.getInstance().getBrowser().getCurrentUrl();
            category = urlCategoria.split("/")[urlCategoria.split("/").length - 1];

            elementPage.closeAd.click();
            Thread.sleep(500);
            elementPage.closeCookies.click();

            System.out.println(categoryPage.itemsInPage());
            for (int j = 1; j <= categoryPage.itemsInPage(); j++) {
                categoryPage.findItem(j).click();
                dataTablas = new StringBuilder();


                if (elementPage.tables.waitExplicitVisibility(2)){
                    dataTablas.append(elementPage.tables.getText().replaceAll("\n"," ")+ "|");

                }
                if (elementPage.verMasCaracteristicas.waitExplicitVisibility(2)){
                    elementPage.verMasCaracteristicas.click();
                    for(int k = 1; k <= elementPage.tables.getAll().size();k++){
                        dataTablas.append(elementPage.getTableControl(k).getText()).append("|");
                    }
                }
                else {
                    if(elementPage.listaOtrosUL.waitExplicitVisibility(2)){
                        for(int k = 1; k <= elementPage.otrosLiLabel.getAll().size();k++){
                            dataTablas.append(elementPage.getLabelControl(k).getText()).append("|");
                        }
                    }
                }
                title = elementPage.titleLabel.getText();
                caracteristics = dataTablas.toString().replaceAll("\n", " ");
                description = elementPage.descripcion.waitExplicitVisibility(2) ? elementPage.descripcion.getText().replaceAll("\n"," ") : "";
                price = elementPage.precio.getAttribute("content");
                url = Session.getInstance().getBrowser().getCurrentUrl();

                data.add(new String[] { title, caracteristics, description, price, url, category});
                Session.getInstance().getBrowser().navigate().back();
            }

        } catch (Exception e) {
            // Captura la excepción y toma la captura de pantalla
            System.out.println("ERROR");
            captureScreenshot(Session.getInstance().getBrowser(), "screenshot.png");
        }
    }
    }

