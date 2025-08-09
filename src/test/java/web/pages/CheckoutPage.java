package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private WebDriver driver;
    private By name = By.id("name");
    private By country = By.id("country");
    private By city = By.id("city");
    private By card = By.id("card");
    private By month = By.id("month");
    private By year = By.id("year");
    private By purchase = By.xpath("//button[text()='Purchase']");

    public CheckoutPage(WebDriver driver){ this.driver=driver; }

    public void fill(String n, String c, String ci, String cd, String m, String y){
        driver.findElement(name).sendKeys(n);
        driver.findElement(country).sendKeys(c);
        driver.findElement(city).sendKeys(ci);
        driver.findElement(card).sendKeys(cd);
        driver.findElement(month).sendKeys(m);
        driver.findElement(year).sendKeys(y);
    }

    public void submit(){ driver.findElement(purchase).click(); }
}
