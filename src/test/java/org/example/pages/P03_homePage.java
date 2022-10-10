package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P03_homePage
{
        //////////////////////////
        //////Currency Test///////
        /////////////////////////
    public WebElement homeLink()
    {
        return Hooks.driver.findElement(By.cssSelector("a[href=\"/\"]"));
    }

    public WebElement currencyMenu()
    {
        return Hooks.driver.findElement(By.id("customerCurrency"));
    }
    public List<WebElement> productCard()
    {
        return Hooks.driver.findElements(By.className("product-item"));
    }
    public WebElement productPrice(WebElement product)
    {
        return product.findElement(By.className("actual-price"));
    }

        ////////////////////////////
        ////////Search Test/////////
        ///////////////////////////
    public WebElement searchTextbox()
    {
        return Hooks.driver.findElement(By.id("small-searchterms"));
    }
    public List<WebElement> products() {
        return Hooks.driver.findElements(By.className("product-item"));
    }
    public WebElement productTitle(WebElement product) {
        return product.findElement(By.cssSelector("h2[class=\"product-title\"] > a"));
    }
    public WebElement getSKU() {
        return Hooks.driver.findElement(By.cssSelector(" div[class=\"sku\"] > span[class=\"value\"]"));
    }

        //////////////////////////
        /////Hover Categories/////
        /////////////////////////
    public List<WebElement> categories()
    {
        return Hooks.driver.findElement(By.className("top-menu")).findElements(By.tagName("li"));
    }
    public WebElement pageTitle() {
        return Hooks.driver.findElement(By.cssSelector("div[class=\"page-title\"] > h1"));
    }
    public List<WebElement> subCategories(WebElement category)
    {
        return category.findElements(By.tagName("li"));
    }

        ////////////////////
        ///////Slider///////
        ///////////////////
    public WebElement homeSlider(String sliderNo) {

        return Hooks.driver.findElement(By.xpath("(//a[@href='http://demo.nopcommerce.com/'])[" + sliderNo + "]"));
    }
        //////////////////////
        ///////Follow Us///////
        //////////////////////
    public WebElement facebookIcon()
    {
        return Hooks.driver.findElement(By.cssSelector("a[href=\"http://www.facebook.com/nopCommerce\"]"));
    }

    public WebElement twitterIcon()
    {
        return Hooks.driver.findElement(By.cssSelector("a[href=\"https://twitter.com/nopCommerce\"]"));
    }

    public WebElement rssIcon()
    {
        return Hooks.driver.findElement(By.cssSelector("a[href=\"/news/rss/1\"]"));
    }

    public WebElement youtubeIcon()
    {
        return Hooks.driver.findElement(By.cssSelector("a[href=\"http://www.youtube.com/user/nopCommerce\"]"));
    }

        ///////////////////////
        ////////Wishlist///////
        //////////////////////
    public WebElement wishlistButton()
    {
        return Hooks.driver.findElement(By.cssSelector("div[data-productid=\"18\"]")).findElement(By.className("add-to-wishlist-button"));
    }
    public WebElement wishlistSuccessMessage()
    {
        return Hooks.driver.findElement(By.cssSelector("p[class=\"content\"]"));
    }
    public By wishlistSuccessMessageSelector()
    {
        return By.cssSelector("p[class=\"content\"]");
    }
    public WebElement wishlist()
    {
        return Hooks.driver.findElement(By.className("ico-wishlist"));
    }
    public List<WebElement> getProducts() {
        return Hooks.driver.findElements(By.cssSelector(" table[class=\"cart\"] > tbody > tr"));
    }
    public WebElement getProductQuantity(WebElement product){
        return product.findElement(By.className("qty-input"));
    }
}
