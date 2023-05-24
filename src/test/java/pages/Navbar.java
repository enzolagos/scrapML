package pages;

import control.Button;
import org.openqa.selenium.By;

public class Navbar {

    public Button masCategoriasButton = new Button(By.xpath("//li[@class='nav-list__item nav-list__item--more']/div"));
    public Button antirrobosButton = new Button(By.xpath("//li/ul/li[last()]"));





    public Button getCategoyButtonByOrder(int number){
        Button categoryButton = new Button(By.xpath("//ul[@id=\"nav-list\"]/li[" + number +"]"));
        return categoryButton;
    }
}
