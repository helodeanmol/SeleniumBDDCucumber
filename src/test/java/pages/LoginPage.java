package pages;

import hooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class
LoginPage {
    final private WebDriver driver;
    final private Map<String, By> elements = new HashMap<>();
    Actions actions;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        elements.put("countryCode", By.xpath("//span[@data-action='a-dropdown-button']"));
        elements.put("countryCodeValues", By.xpath("//a[@id='claim-input-dropdown-select-element_107']"));
        elements.put("continue", By.xpath("//input[@type='submit']"));
        elements.put("username", By.id("ap_email_login"));
        elements.put("password", By.id("ap_password"));
        elements.put("loginBtn", By.id("signInSubmit"));
        elements.put("logoutBtn", By.xpath("//span[normalize-space()='Sign Out']"));

    }

    public void enterUsername(String username) {
        driver.findElement(elements.get("username")).sendKeys(username);
        driver.findElement(elements.get("countryCode")).click();
        driver.findElement(elements.get("countryCodeValues")).click();
        driver.findElement(elements.get("continue")).click();
    }

    public void enterPassword(String password) {
        driver.findElement(elements.get("password")).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(elements.get("loginBtn")).click();
    }

    public void clickLogout() {
        actions.moveToElement(Hooks.driver.findElement(By.id("//span[@id='nav-link-accountList-nav-line-1']"))).perform();
        driver.findElement(elements.get("logoutBtn")).click();
    }

}