package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    private WebDriver driver;
    private By placeOrderBtn = By.xpath("//button[text()='Place Order']");
    private By cartItems = By.cssSelector("tr.success td:nth-child(2)");

    public CartPage(WebDriver driver){ this.driver=driver; }

    public void open(){ driver.get("https://www.demoblaze.com/cart.html"); }
    public void placeOrder(){ driver.findElement(placeOrderBtn).click(); }
    public List<WebElement> getItems(){ return driver.findElements(cartItems); }
}
