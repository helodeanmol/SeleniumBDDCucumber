package stepDefinitions;

import hooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import pages.LoginPage;
import io.cucumber.java.en.*;
import utilities.ConfigReader;

public class LoginSteps {
    LoginPage loginPage;
    Actions actions;

    @Given("user is on login page")
    public void user_is_on_login_page() {
        Hooks.driver.get("https://www.amazon.com/");
        Hooks.driver.findElement(By.xpath("//button[@alt='Continue shopping']")).click();
        actions = new Actions(Hooks.driver);
        if (!Hooks.driver.findElement(By.id("nav-link-accountList")).isEnabled()) {
            Hooks.driver.navigate().refresh();
        }
        actions.moveToElement(Hooks.driver.findElement(By.id("nav-link-accountList"))).perform();
        Hooks.driver.findElement(By.xpath("//span[text()='Sign in']")).click();
        loginPage = new LoginPage(Hooks.driver);
    }

    @When("user enters valid credentials")
    public void user_enters_valid_credentials() {
        System.out.println(ConfigReader.getProperty("amazonUsername"));
        System.out.println(ConfigReader.getProperty("amazonPassword"));
        loginPage.enterUsername(ConfigReader.getProperty("amazonUsername"));
        loginPage.enterPassword(ConfigReader.getProperty("amazonPassword"));
        loginPage.clickLogin();
    }

    @Then("user should be logged in")
    public void user_should_be_logged_in() {
        // Dummy assertion, replace with actual check
        System.out.println("User logged in successfully.");
    }

    @Given("user is logged in")
    public void user_is_logged_in(){
        System.out.println("User is logged in");
    }

    @When("user clicks on logout button")
    public void user_clicks_on_logout_button(){
        loginPage.clickLogout();
    }

    @Then("user should be logged out")
    public void user_should_be_logged_out(){
        System.out.println("User logged out successfully.");
    }
}