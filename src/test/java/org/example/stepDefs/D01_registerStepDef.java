package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class D01_registerStepDef {
    P01_register register = new P01_register();

    @Given("user go to register page")
    public void goRegisterPage()
    {
        register.registerlink().click();
    }

    @When("user select gender type")
    public void SelectGenderType() {
        register.gender().click();
    }

    @And("^user enter first name \"(.*)\" and last name \"(.*)\"$")
    public void FNameAndLName(String fname, String lname) {
        register.fname().sendKeys(fname);
        register.lname().sendKeys(lname);
    }

    @And("user enter date of birth")
    public void DateOfBirth() {
        register.day().sendKeys("5");
        register.day().sendKeys(Keys.ENTER);

        register.month().sendKeys("10");
        register.month().sendKeys(Keys.ENTER);

        register.year().sendKeys("2020");
        register.year().sendKeys(Keys.ENTER);
    }

    @And("^user enter email \"(.*)\" field$")
    public void EmailField(String email) {
        register.email().sendKeys(email);
    }

    @And("^user fills Password fields \"(.*)\" \"(.*)\"$")
    public void PasswordFields(String pass1, String pass2) {
        register.password().sendKeys(pass1);
        register.confirmPassword().sendKeys(pass2);
    }

    @And("user clicks on register button")
    public void RegisterButton() {
        register.button().click();
    }

    @Then("success message is displayed")
    public void successMessageIsDisplayed() {
        SoftAssert soft = new SoftAssert();

        soft.assertTrue( register.confirmationMessage().getText().contains("Your registration completed") );
        soft.assertTrue( register.confirmationMessage().getCssValue("color").contains("rgba(76, 177, 124, 1)"));

        soft.assertAll();
    }
}
