package singletonSession;

import factoryBrowser.FactoryBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Session {
    private static Session session = null;
    private WebDriver browser;

    private Session(){
        browser = FactoryBrowser.make("chrome").create();
    }
    public static Session getInstance(){
        if(session==null){
            session = new Session();
        }
        return session;
    }
    public void closeBrowser(){
        browser.quit();
        session=null;
    }

    public WebDriver getBrowser() {
        return browser;
    }
    public void changeIFrame(String iframeID){
        session.browser.switchTo().frame(iframeID);
    }
    public void leaveIFrame(){
        session.browser.switchTo().defaultContent();
    }
    public void waitURLToChange(String url){
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(url));
    }
}
