package control;

import org.openqa.selenium.By;

public class CheckBox extends Control{
    public CheckBox(By locator) {
        super(locator);
    }
    public void check(){
        this.findControl();
        if (!this.control.isSelected()){
            control.click();
        }
    }
    public void uncheck(){
        this.findControl();
        if (this.control.isSelected()){
            control.click();
        }
    }
}
