package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class D08_WishlistStepDef {
    P03_homePage home = new P03_homePage();

    @When("user click add to wishlist button")
    public void addToWishlist() {
        home.wishlistButton().click();
    }

    @Then("item should be added to wishlist")
    public void assertSuccess() {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(home.wishlistSuccessMessage().getText().contains("The product has been added "));
        WebElement parent = (WebElement) ((JavascriptExecutor) Hooks.driver).executeScript(
                "return arguments[0].parentNode;", home.wishlistSuccessMessage());
        soft.assertEquals(parent.getCssValue("background-color"), "rgba(75, 176, 122, 1)");
        soft.assertAll();
    }

    @And("user wait until success message disappears")
    public void waitForMessage() {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(home.wishlistSuccessMessageSelector()));
    }

    @And("user clicks wishlist tab")
    public void openWishlist() {
        home.wishlist().click();
    }

    @Then("item quantity in wishlist should be > 0")
    public void assertItemAdded() {
        List<WebElement> products = home.getProducts();
        Assert.assertTrue(Integer.parseInt(home.getProductQuantity(products.get(0)).getAttribute("value")) > 0);
    }
}
