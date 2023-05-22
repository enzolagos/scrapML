package pages;

import control.Button;
import control.Control;
import control.Label;
import org.openqa.selenium.By;

public class CategoryPage {
    public Button nextPageBtn = new Button(By.xpath("//li[contains(@class,\"andes-pagination__button--next\")]/a"));
    public Integer itemsInPage = new Control(By.xpath("//ol[contains(@class,\"ui-search-layout\")]/li")).getAll().size();

    public Integer numberOfPages(){
        return Integer.valueOf(new Label(By.xpath("//li[@class='andes-pagination__page-count']")).getText().split(" ")[new Label(By.xpath("//li[@class='andes-pagination__page-count']")).getText().split(" ").length - 1]);
    }

    public Button findItem(int position){
        return new Button(By.xpath("(//ol[contains(@class,\"ui-search-layout\")]//div[contains(@class,\"ui-search-result__content-wrapper\")])[position]"));
    }
}
