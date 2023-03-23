package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CashwiseLoginPage;
import utilities.Config;
import utilities.Driver;
import utilities.Flow;
import utilities.MyLogger;

public class CashwiseLoginNegative_steps {

    CashwiseLoginPage cashwiseLoginPage = new CashwiseLoginPage();

    @Given("user is on cashwise application")
    public void user_is_on_cashwise_application() {
        Driver.getDriver().get(Config.getValue("cashwiseURL"));
    }

    @Given("user clicks on sign in button")
    public void user_clicks_on_sign_in_button() {
        cashwiseLoginPage.signInLink.click();
    }

    @When("user logs in {string} and {string}")
    public void user_logs_in_and(String email, String password) {
        MyLogger.info("Logging into software");
        cashwiseLoginPage.emailInputBox.sendKeys(email);
        cashwiseLoginPage.passwordInputBox.sendKeys(password);
        cashwiseLoginPage.signInButton.click();
        Flow.wait(2000);
    }

    @Then("user should land on {string} page")
    public void user_should_land_on_page(String url) {
        MyLogger.warn("Verification of login");
        String actualURL = Driver.getDriver().getCurrentUrl();
        Assert.fail("on purpose");
        Assert.assertEquals(url, actualURL);
    }

    @Then("user sees error messages {string} and {string}")
    public void user_sees_error_messages_and(String emailError, String passwordError) {
        String actualEmailError = cashwiseLoginPage.emailErrorMessage.getText().trim();
        String actualPasswordError = cashwiseLoginPage.passwordErrorMessage.getText().trim();
        Assert.assertEquals(emailError, actualEmailError);
        Assert.assertEquals(passwordError, actualPasswordError);
    }

}
