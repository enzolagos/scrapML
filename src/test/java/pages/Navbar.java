package pages;

import control.Button;
import org.openqa.selenium.By;

public class Navbar {






    public Button getCategoyButtonByOrder(int number){
        Button categoryButton = new Button(By.xpath("//ul[@id=\"nav-list\"]/li[" + number +"]"));
        return categoryButton;
    }
}
