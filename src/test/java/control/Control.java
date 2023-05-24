package control;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import singletonSession.Session;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Control {
    protected By locator;
    protected WebElement control;
    protected List<WebElement> controls = new ArrayList<>();

    public Control(By locator){
        this.locator = locator;
    }

    protected void findControl(){
        control= Session.getInstance().getBrowser().findElement(this.locator);
    }
    protected void findControls(){
        controls= Session.getInstance().getBrowser().findElements(this.locator);
    }
    public void click(){
        this.findControl();
        control.click();
    }

    public boolean isControlDisplayed(){
        try{
            this.findControl();
            return control.isDisplayed();
        }catch (Exception e){
            return false;}
    }
    public List<WebElement> getAll(){
        this.findControls();
        return controls;
    }

    public String getText(){
        this.findControl();
        return control.getText();
    }
    public String getAttribute(String value){
        this.findControl();
        return control.getAttribute(value);
    }
    public void waitClickable()
    {
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(this.locator));
    }
    public void waitTextToBe(String texto){
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(this.locator,texto));
    }

    public void waitUntilChangeState(String attribute,String value){
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(this.locator,attribute,value));
    }

    public boolean waitExplicitVisibility(int seconds){
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(seconds));
        try {
            wait.until(ExpectedConditions.visibilityOf(this.control));
            System.out.println("El control es visible.");
            return true;

        } catch (Exception e) {
            // El control no es visible o el tiempo de espera ha expirado
            System.out.println("El control no es visible.");
            return false;
        }

    }
}
