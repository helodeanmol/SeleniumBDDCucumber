//package stepDefinitions;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import com.mysql.cj.jdbc.Driver;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import net.bytebuddy.asm.Advice.This;
//
//public class AmazonSteps {
//
//	WebDriver driver;
//
//	@Given("user launches the amazon site")
//	public void launch_site() throws Exception {
//		// Setting the property of chrome driver and passing chromedrive path
//		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Software\\chromedriver_win32\\chromedriver.exe");
//
//		// Launching Chrome browser instance
//		WebDriver driver = new ChromeDriver();
//
//		// manage() method
//		driver.manage().window().maximize();
//
//		// Open application URL using get() and navigate() method
//		driver.get("https://www.amazon.com/");
//		Thread.sleep(3000);
//	}
//
//	@When("user navigates to the sign")
//	public void navigate_to_sign() {
//		driver.findElement(By.xpath("//div[@id='nav-link-accountList']//a[contains(@class,'nav-progressive-attribute')]")).click();
//	}
//
//	@When("user logs in with valid credentials")
//	public void login() {
//		driver.findElement(By.xpath("//input[@id='ap_email_login']")).sendKeys("anmolhelode@gmail.com");
//		driver.findElement(By.xpath("//input[@type='submit']")).click();
//		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("Anmol1016#");
//		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
//	}
//
//	@When("user fills travel details and requests a quote")
//	public void fill_quote_details() {
//	}
//
//	@When("user enters personal details")
//	public void fill_personal_details() {
//	}
//
////	@When("user proceeds to make the payment")
////	public void payment() {
////	}
//
//	@Then("policy should be created and acknowledgement should be shown")
//	public void acknowledge_policy() {
//	}
//
//	@Then("all journey details should be stored in the database")
//	public void verify_db_entry() {
//	}
//}
