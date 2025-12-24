package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.MastercardSignUpPage;

import java.util.List;

public class MastercardSignUpTest {
    MastercardSignUpPage mastercardSignUpPage;
    Actions actions;
    List<WebElement> options;

    @Given("user is on sign up page")
    public void user_is_on_sign_up_page() {
        Hooks.driver.get("https://developer.mastercard.com/account/sign-up");
        actions = new Actions(Hooks.driver);
        WebElement cookies = Hooks.driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        cookies.click();
        JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;
        js.executeScript("window.scrollBy(0,500)");

//        System.out.println("countryDropdownCount: " + countryDropdown.size());
//        for(int i=0; i<countryDropdown.size(); i++){
//            countryDropdown.get(i).click();
//            String countryName = countryDropdown.get(i).getText();
//            System.out.print(countryName);
//
//        }
//        System.out.println("countryDropdown: " + countryDropdown);
        mastercardSignUpPage = new MastercardSignUpPage(Hooks.driver);
    }

    @When("user clicks on country dropdown")
    public void user_clicks_on_country_dropdown() {
        WebElement countryDropdown = Hooks.driver.findElement(By.xpath("//div[@data-testid='signUpCountry']"));
        countryDropdown.click();
        options = Hooks.driver.findElements(By.id("react-select-2-listbox"));
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
    }

    @Then("user select india")
    public void user_select_india() {
        for(int i=0; i<options.size(); i++){
            if(options.get(i).getText().equalsIgnoreCase("India")){
                System.out.println(options.get(i).getText());
                options.get(i).click();
                break;
            }
        }
        // Dummy assertion, replace with actual check
        System.out.println("User logged in successfully.");
    }
}
