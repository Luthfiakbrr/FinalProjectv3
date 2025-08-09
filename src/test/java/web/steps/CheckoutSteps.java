package web.steps;

import hooks.Hooks;
import io.cucumber.java.en.*;
import org.junit.Assert;
import web.pages.CartPage;
import web.pages.CheckoutPage;

public class CheckoutSteps {
    CartPage cart;
    CheckoutPage checkout;

    @Given("I have an item in cart")
    public void ensureItemInCart(){
        // assume previous steps added an item; else navigate
        cart = new CartPage(Hooks.driver);
        cart.open();
        // basic check
        Assert.assertTrue(Hooks.driver.getPageSource().contains("Delete"));
    }

    @When("I place an order with checkout info")
    public void placeOrder(){
        cart.placeOrder();
        checkout = new CheckoutPage(Hooks.driver);
        checkout.fill("Luthfi","Indonesia","Jakarta","4111222333","12","2027");
        checkout.submit();
    }

    @Then("I should see a purchase confirmation")
    public void verifyPurchase(){
        Assert.assertTrue(Hooks.driver.getPageSource().contains("Thank you for your purchase"));
    }
}
