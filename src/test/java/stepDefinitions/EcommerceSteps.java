package stepDefinitions;

import io.cucumber.java.en.*;

public class EcommerceSteps {
    @Given("user is on the ecommerce home page")
    public void launch_ecommerce_site() {}

    @When("user searches for a product")
    public void search_product() {}

    @When("user adds the product to cart and checks out")
    public void add_to_cart_checkout() {}

    @When("user makes payment")
    public void make_payment() {}

    @Then("order confirmation should be displayed")
    public void show_order_confirmation() {}

    @Then("order details should be saved in the database")
    public void save_order_in_db() {}
}
