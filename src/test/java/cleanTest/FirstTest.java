package cleanTest;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pages.ElementPage;
import singletonSession.Session;

import static utils.CsvWriter.createCsvFile;
import static utils.CsvWriter.writeDataLineByLine;

public class FirstTest extends TestBaseScrapML{
    public ElementPage elementPage = new ElementPage();
    @Test
    public void verifyItRuns() throws InterruptedException{
        Thread.sleep(1000);
        elementPage.closeAd.click();
        Thread.sleep(1000);
        elementPage.closeCookies.click();
        Thread.sleep(1000);
        elementPage.verMasCaracteristicas.click();
        Thread.sleep(2000);
        System.out.println(elementPage.tables.getAll().get(1).getText());

    }

   /* @Test
    public void testScrapNeumaticos() throws InterruptedException {
        homePage.closeNewsBtn.click();
        homePage.closeNewsBtn2.click();
        navbar.getCategoyButtonByOrder(1).click();
        Thread.sleep(2000);
    }*/

}
