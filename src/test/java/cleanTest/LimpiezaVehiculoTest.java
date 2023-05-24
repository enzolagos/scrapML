package cleanTest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import singletonSession.Session;

import java.util.List;

import static utils.ScreenShot.captureScreenshot;

public class LimpiezaVehiculoTest extends TestBaseScrapML{

    String title;
    String price;
    String caracteristics;
    String description;
    String category;
    String url;

    @Test
    public void testScrapLimpieza() throws InterruptedException {
//        try{
            long startTime, endTime, elapsedTime;
            Thread.sleep(1000);
            if(homePage.closeNewsBtn.isControlDisplayed())
                homePage.closeNewsBtn.click();
            navbar.getCategoyButtonByOrder(7).click();
            Thread.sleep(1000);
            if (homePage.closeBestOffersNewsPopUp.isControlDisplayed()) {
                homePage.closeBestOffersNewsPopUp.click();
            }
            StringBuilder dataTablas;
            String urlCategoria = Session.getInstance().getBrowser().getCurrentUrl();
            category = urlCategoria.split("/")[urlCategoria.split("/").length - 1];

            elementPage.closeAd.click();
            Thread.sleep(500);
            elementPage.closeCookies.click();

            System.out.println(categoryPage.itemsInPage());
            for (int j = 1; j <= categoryPage.itemsInPage(); j++) {
                categoryPage.findItem(j).click();
                dataTablas = new StringBuilder();
                startTime = System.nanoTime();
                if (elementPage.verMasCaracteristicas.waitExplicitVisibility(2)){
                    endTime = System.nanoTime();
                    elapsedTime = endTime - startTime;
                    System.out.println("Tiempo de ejecución para entrar en el if true " + elapsedTime/1000000000 + " segundos");
                    elementPage.verMasCaracteristicas.waitClickable();
                    elementPage.verMasCaracteristicas.click();
                    for(int k = 1; k <= elementPage.tables.getAll().size();k++){
                        dataTablas.append(elementPage.getTableControl(k).getText()).append("|");
                    }
                }
                else{
                    endTime = System.nanoTime();
                    elapsedTime = endTime - startTime;
                    System.out.println("Tiempo de ejecución en salir del if para entrar en el else: " + elapsedTime/1000000000 + " segundos");
                    startTime = System.nanoTime();
                    for(int k = 1; k <= elementPage.otrosLiLabel.getAll().size();k++){
                        dataTablas.append(elementPage.getLabelControl(k).getText()).append("|");
                    }
                    endTime = System.nanoTime();
                    elapsedTime = endTime - startTime;
                    System.out.println("Tiempo de ejecución for de las tablas: " + elapsedTime/1000000000 + " segundos");
                }

                title = elementPage.titleLabel.getText();
                caracteristics = dataTablas.toString().replaceAll("\n", " ");
                description = elementPage.descripcion.waitExplicitVisibility(2)? elementPage.descripcion.getText().replaceAll("\n"," ") : "";
//                description = elementPage.descripcion.getText().replaceAll("\n"," ");
                price = elementPage.precio.getAttribute("content");
                url = Session.getInstance().getBrowser().getCurrentUrl();

                data.add(new String[] { title, caracteristics, description, price, url, category});
                Session.getInstance().getBrowser().navigate().back();
            }

       /* } catch (Exception e) {
            // Captura la excepción y toma la captura de pantalla
            System.out.println("ERROR");
            captureScreenshot(Session.getInstance().getBrowser(), "screenshot.png");
        }*/
    }
}
