package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

public class D02_loginStepDef {
    P02_login login = new P02_login();

    @Given("user go to login page")
    public void goLoginPage() {
        login.loginLink().click();
    }
    @When("^user login with \"(.*)\" and \"(.*)\"$")
    public void typeLoginData(String email, String password) {
        login.email().sendKeys(email);
        login.password().sendKeys(password);
    }
    @And("user press on login button")
    public void login() {
        login.loginButton().click();
    }
    @Then("user login to the system successfully")
    public void assertSuccessfulLogin() {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue( Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/") );
        soft.assertTrue( login.accountTab().isDisplayed() );
        soft.assertAll();
    }
    @Then("user could not login to the system")
    public void assertFailedLogin() {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue( login.errorMessage().getText().contains("Login was unsuccessful.") );
        soft.assertEquals( Color.fromString(login.errorMessage().getCssValue("color")).asHex(), "#e4434b");
        soft.assertAll();
    }
}
