package pages;

import control.*;
import org.openqa.selenium.By;

public class ElementPage {
    public Label titleLabel = new Label(By.xpath("//h1"));
    public Label descriptionTableItem = new Label(By.xpath("//p[@class='ui-pdp-family--REGULAR ui-vpp-highlighted-specs__key-value__labels__key-value']"));
    public Button closeAd = new Button(By.xpath("//button[@id='wpn-close-btn']"));
    public Button closeCookies = new Button(By.xpath("//button[@class='nav-cookie-disclaimer__button']"));
    public Button verMasCaracteristicas = new Button(By.xpath("//span[@class='ui-pdp-collapsable__action']"));
    public Table tables = new Table(By.xpath("//table[@class='andes-table']"));
    public Table infoTableBody = new Table(By.xpath("(//tbody[@class='andes-table__body'])[2]"));

    //intento agustin
    public Control labelTablas = new Control(By.xpath("//section//table"));

    //public int contarTablas(){
//        return labelTablas.getControlsQuantity();
    //}

}

