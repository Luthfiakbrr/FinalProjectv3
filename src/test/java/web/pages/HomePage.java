package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    private By loginLink = By.id("login2");
    private By cartLink = By.id("cartur");
    private By products = By.cssSelector(".card-block .card-title a");

    public HomePage(WebDriver driver){ this.driver=driver; }

    public void open(){ driver.get("https://www.demoblaze.com/"); }
    public void openLogin(){ driver.findElement(loginLink).click(); }
    public void openCart(){ driver.findElement(cartLink).click(); }
    public WebElement firstProduct(){ return driver.findElement(products); }
}
