package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private WebDriver driver;
    private By addToCart = By.xpath("//a[text()='Add to cart']");
    private By title = By.cssSelector(".name");

    public ProductPage(WebDriver driver){ this.driver=driver; }

    public String getTitle(){ return driver.findElement(title).getText(); }
    public void addToCart(){ driver.findElement(addToCart).click(); }
}
