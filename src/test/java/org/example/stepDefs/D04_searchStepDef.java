package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.example.pages.P03_homePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class D04_searchStepDef {
    P02_login login = new P02_login();
    P03_homePage home  = new P03_homePage();

    @Given("user has logged in")
    public void login() {
        login.loginLink().click();
        login.login("test@example.com","P@ssw0rd");
    }
    @And("user is at home page")
    public void toHome() {
        home.homeLink().click();
    }
    @When("^user enter product name as \"(.*)\"$")
    public void typeProductName(String item) {
        home.searchTextbox().sendKeys(item);
    }
    @And("user press enter")
    public void pressEnter() {
        home.searchTextbox().sendKeys(Keys.ENTER);
    }
    @Then("^search results should appear and contain \"(.*)\"$")
    public void assertSucess(String item) {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue( Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q="));
        List<WebElement> products = home.products();
        for (WebElement product : products) {
            soft.assertTrue( home.productTitle(product).getText().toLowerCase().trim().contains(item) );
        }
        soft.assertAll();
    }
    @When("^user enter product sku as \"(.*)\"$")
    public void typeProductSKU(String sku) {
        home.searchTextbox().sendKeys(sku);
    }

    @Then("search result should contain {string}")
    public void searchResultShouldContain(String item) {
        List<WebElement> products = home.products();
        for (WebElement product : products) {
            product.click();
            System.out.println(this.home.getSKU().getText());
            System.out.println(item);
            Assert.assertTrue( this.home.getSKU().getText().toLowerCase().trim().contains(item.toLowerCase()) );
        }
    }
}
