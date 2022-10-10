package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class D03_currenciesStepDef {
    P03_homePage home = new P03_homePage();

    @Given("user go to home page")
    public void Home() {
        home.homeLink().click();
    }
    @When("select Euro currency from the dropdown")
    public void changeCurrency() {
        home.currencyMenu().sendKeys("Euro");
    }
    @Then("Euro Symbol is shown on the 4 products displayed in Home page")
    public void assertCurrencyChange() {
        List<WebElement> products = home.productCard();
        SoftAssert soft = new SoftAssert();
        for(WebElement product : products) {
            soft.assertTrue( home.productPrice(product).getText().contains("€"));
        }
        soft.assertAll();
    }
}
