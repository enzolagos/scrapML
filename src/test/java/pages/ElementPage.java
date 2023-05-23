package pages;

import control.*;
import org.openqa.selenium.By;

public class ElementPage {
    public Label titleLabel = new Label(By.xpath("//h1"));

    public Button closeAd = new Button(By.xpath("//button[@id='wpn-close-btn']"));
    public Button closeCookies = new Button(By.xpath("//button[@class='nav-cookie-disclaimer__button']"));
    public Button verMasCaracteristicas = new Button(By.xpath("//span[@class='ui-pdp-collapsable__action']"));

    public Table tables = new Table(By.xpath("//table[@class='andes-table']"));
    public Table getTableControl(int i){
        return new Table(By.xpath("(//table[@class='andes-table'])["+i+"]"));
    }

    public Label descripcion = new Label(By.xpath("//p[@class='ui-pdp-description__content']"));

    public Control precio = new Control(By.xpath("//meta[@itemprop='price']"));
    //intento agustin
    public Control labelTablas = new Control(By.xpath("//section//table"));

    /* BATERIAS */
    public Label otrosLiLabel = new Label(By.xpath("//li[@class='ui-pdp-list__item']"));
    public Label getLabelControl(int i){
        return new Label(By.xpath("(//li[@class='ui-pdp-list__item'])["+i+"]"));
    }

}

