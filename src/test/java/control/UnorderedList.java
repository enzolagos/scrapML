package control;

import org.openqa.selenium.By;

public class UnorderedList extends Control{
    public UnorderedList(By locator) {
        super(locator);
    }
    public boolean hayElementos(){
        return Integer.parseInt(this.getAttribute("childElementCount"))>0;
    }
}