package web.steps;

import hooks.Hooks;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import web.pages.*;

public class WebSteps {
    HomePage home;
    ProductPage product;

    @Given("I open demoblaze")
    public void openHome(){
        home = new HomePage(Hooks.driver);
        home.open();
    }

    @When("I open first product detail")
    public void openFirstProduct(){
        home.firstProduct().click();
    }

    @When("I add product to cart")
    public void addToCart() throws InterruptedException {
        product = new ProductPage(Hooks.driver);
        product.addToCart();
        // accept alert
        Hooks.driver.switchTo().alert().accept();
        Thread.sleep(500); // small pause to allow cart update
    }

    @Then("the product should be added")
    public void verifyAdded(){
        home.openCart();
        boolean hasRow = Hooks.driver.getPageSource().contains("Delete");
        Assert.assertTrue(hasRow);
    }
}
