package web.steps;

import hooks.Hooks;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginSteps {

    @Given("I open login modal")
    public void openLogin(){
        Hooks.driver.get("https://www.demoblaze.com/");
        Hooks.driver.findElement(By.id("login2")).click();
    }

    @When("I login with username {string} and password {string}")
    public void doLogin(String username, String password){
        Hooks.driver.findElement(By.id("loginusername")).clear();
        Hooks.driver.findElement(By.id("loginusername")).sendKeys(username);
        Hooks.driver.findElement(By.id("loginpassword")).clear();
        Hooks.driver.findElement(By.id("loginpassword")).sendKeys(password);
        Hooks.driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }

    @Then("I should see the logged in username")
    public void verifyLogin(){
        WebElement welcome = Hooks.driver.findElement(By.id("nameofuser"));
        Assert.assertTrue(welcome.isDisplayed());
    }

    @Then("I should see login error alert")
    public void verifyLoginError(){
        String text = Hooks.driver.switchTo().alert().getText();
        Assert.assertTrue(text.length()>0);
        Hooks.driver.switchTo().alert().accept();
    }
}
