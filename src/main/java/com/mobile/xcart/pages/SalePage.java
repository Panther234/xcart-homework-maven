package com.mobile.xcart.pages;

import com.mobile.xcart.utility.Utility;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SalePage extends Utility {

    By saleText = By.xpath("//h1[@id='page-title']");
    By sortBy = By.xpath("//span[@class='sort-by-label']");
    By selectAToZ = By.xpath("//a[normalize-space()='Name A - Z']");
    By selectPriceLowToHigh = By.xpath("//a[normalize-space()='Price Low - High']");
    By selectRates = By.xpath("//a[normalize-space()='Rates']");
    By avengersMouseHover = By.xpath("//a[@class='product-thumbnail next-previous-assigned']");
    By addToCartButton = By.xpath("//button[contains(@class,'regular-button add-to-cart product-add2cart productid-16')]//span[contains(text(),'Add to cart')]");
    By addToCartText = By.xpath("//li[contains(.,'Product has been added to your cart')]");
    By closeTheMessage = By.xpath("//a[@title='Close']");
    By yourCartButton = By.xpath("//div[@title='Your cart']");
    By viewCartButton = By.xpath("//a[@class='regular-button cart']");
    By productAlphabetSort = By.xpath("//h5[@class='product-name']");
    By productPriceSort = By.xpath("//span[@class='price product-price']");



    public void saleTextVerify() {
        verifyText("Sale", saleText, "Error-Message not displayed");
    }

    public void sortByMouseHover() throws InterruptedException {
        mouseHoverOnly(sortBy);
    }

    public void selectAToZClick() throws InterruptedException {
        mouseHoverClick(selectAToZ);
    }

    public void selectPriceLowToHighClick() throws InterruptedException {
        mouseHoverClick(selectPriceLowToHigh);
    }

    public void selectRatesClick() throws InterruptedException {
        mouseHoverClick(selectRates);
    }

    public void setAvengersMouseHover() throws InterruptedException {
        //waitUntilVisibilityOfElementLocated(avengersMouseHover, 20);
        Thread.sleep(1000);
        mouseHoverOnly(avengersMouseHover);
    }

    public void addToCartButtonClick() throws InterruptedException {
        //waitUntilVisibilityOfElementLocated(addToCartButton, 20);
        Thread.sleep(1000);
        mouseHoverClick(addToCartButton);
    }

    public void addToCartTextVerify() {
        verifyText("Product has been added to your cart", addToCartText, "Error, Message not displayed");
    }

    public void clickCloseTheMessage() {
        clickOnElement(closeTheMessage);
    }

    public void clickYourCartButton() {
        clickOnElement(yourCartButton);
    }
    public void clickViewCartButton() throws InterruptedException {
        //waitUntilVisibilityOfElementLocated(viewCartButton, 20);
        Thread.sleep(1000);
        clickOnElement(viewCartButton);

    }
    public void verifyTextSortByAscending(){
        List<WebElement> originalList = driver.findElements(productAlphabetSort);
        List<String> originalProductNameList = new ArrayList<>();
        for (WebElement product : originalList) {
            originalProductNameList.add(product.getText());
        }
        Collections.sort(originalProductNameList);  // We sorted this list to ascending
        System.out.println(originalProductNameList);
        waitUntilVisibilityOfElementLocated(productAlphabetSort, 10);
        List<WebElement> afterSortingList = driver.findElements(productAlphabetSort);
        List<String> afterSortingProductName = new ArrayList<>();
        for (WebElement product : afterSortingList) {
            afterSortingProductName.add(product.getText());
        }
        System.out.println(afterSortingProductName);
        Assert.assertEquals("Product not sorted", originalProductNameList, afterSortingProductName);
    }

    public void verifyTextSortByLowToHigh(){
        List<WebElement> originalList = driver.findElements(productPriceSort);
        List<Double> originalProductPriceList = new ArrayList<>();
        for (WebElement product : originalList) {
            originalProductPriceList.add(Double.parseDouble(product.getText().substring(1)));
        }
        originalProductPriceList.sort(Double::compareTo);
        System.out.println(originalProductPriceList);
        waitUntilVisibilityOfElementLocated(productPriceSort, 10);
        List<WebElement> afterSortingList = driver.findElements(productPriceSort);
        List<Double> afterSortingProductName = new ArrayList<>();
        for (WebElement product : afterSortingList) {
            afterSortingProductName.add(Double.parseDouble(product.getText().substring(1)));
        }
        System.out.println(afterSortingProductName);
        Assert.assertEquals("Product not sorted", originalProductPriceList, afterSortingProductName);
    }

    By productRatesSort = By.cssSelector(".stars-row.full");

    public void verifyTextSortByRates() throws InterruptedException {
        List<WebElement> originalList = driver.findElements(productRatesSort);
        List<Integer> originalProductRateList = new ArrayList<>();
        for (WebElement product : originalList) {
            originalProductRateList.add(Integer.parseInt(product.getAttribute("style").substring(7,9)));
        }
        //originalProductNameList.sort(Collections.reverseOrder());
        Collections.sort(originalProductRateList);
        System.out.println(originalProductRateList);
        waitUntilVisibilityOfElementLocated(productAlphabetSort, 10);

        List<WebElement> afterSortList = driver.findElements(productRatesSort);
        List<Integer> afterSortProductRates = new ArrayList<>();
        for (WebElement product : afterSortList) {
            afterSortProductRates.add(Integer.parseInt(product.getAttribute("style").substring(7,9)));
        }
        System.out.println(afterSortProductRates);
        Assert.assertEquals("Products not sorted", originalProductRateList, afterSortProductRates);
    }
}
