package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Random;

public class DemoBlazeSignUp_steps {

    @Given("user is on demo blaze application")
    public void user_is_on_demo_blaze_application() {

    }
    @Given("user clicks on sign up button")
    public void user_clicks_on_sign_up_button() {

    }
    @When("user enters credentials {string} and {string} and clicks sign up")
    public void user_enters_credentials_and_and_clicks_sign_up(String username, String password) {
        //
        if (username.equals("placeholder")){
            username = username + new Random().nextInt(10000);
        }

    }
    @Then("user should see alert message {string}")
    public void user_should_see_alert_message(String string) {

    }

}
