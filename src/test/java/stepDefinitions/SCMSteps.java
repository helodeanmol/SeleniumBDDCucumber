package stepDefinitions;

import io.cucumber.java.en.*;

public class SCMSteps {
    @Given("user logs in to the SCM portal")
    public void login_scm() {}

    @When("user creates a purchase order with valid supplier and item details")
    public void create_po() {}

    @Then("the purchase order should be saved")
    public void verify_po_saved() {}

    @Then("the inventory should be updated accordingly")
    public void verify_inventory_updated() {}
}
