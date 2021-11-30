package com.mobile.xcart.pages;

import com.mobile.xcart.utility.Utility;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestsellersPage extends Utility {

    By bestsellersText = By.xpath("//h1[@id='page-title']");
    By sortBy = By.xpath("//span[@class='sort-by-label']");
    By selectZToA = By.xpath("//a[normalize-space()='Name Z - A']");
    By selectPriceHighToLow = By.xpath("//a[normalize-space()='Price High - Low']");
    By selectRates = By.xpath("//a[normalize-space()='Rates']");
    By selectAToZ = By.xpath("//a[normalize-space()='Name A - Z']");
    By vinylIdolz = By.xpath("//a[@class='product-thumbnail next-previous-assigned']");
    By addToCart = By.xpath("//button[contains(@class,'btn  regular-button add-to-cart product-add2cart productid-13')]");
    By addToCartText = By.xpath("//li[contains(text(),'Product has been added to your cart')]");
    By closeTheMessage = By.xpath("//a[@title='Close']");
    By yourCartButton = By.xpath("//div[@title='Your cart']");
    By viewCartButton = By.xpath("//a[@class='regular-button cart']");
    By productAlphabetSort = By.xpath("//h5[@class='product-name']");
    By productPriceSort = By.xpath("//span[@class='price product-price']");


    public void saleTextVerify() {
        verifyText("Bestsellers", bestsellersText, "Error-Message not displayed");
    }

    public void sortByMouseHover() throws InterruptedException {
        mouseHoverOnly(sortBy);
    }

    public void selectZToAClick() throws InterruptedException {
        mouseHoverClick(selectZToA);
    }

    public void selectPriceHighToLowClick() throws InterruptedException {
        mouseHoverClick(selectPriceHighToLow);
    }

    public void selectRatesClick() throws InterruptedException {
        mouseHoverClick(selectRates);
    }

    public void selectAToZClick() throws InterruptedException {
        mouseHoverClick(selectAToZ);
    }

    public void setVinylIdolz() throws InterruptedException {
        Thread.sleep(3000);
        mouseHoverOnly(vinylIdolz);
    }

    public void setAddToCart() throws InterruptedException {
        Thread.sleep(3000);
        mouseHoverClick(addToCart);
    }

    public void setAddToCartText() {
        verifyText("Product has been added to your cart", addToCartText, "Error, Message not displayed");
    }

    public void setCloseTheMessage() {
        clickOnElement(closeTheMessage);
    }

    public void setYourCartButton() {
        clickOnElement(yourCartButton);
    }

    public void setViewCartButton() throws InterruptedException {
        Thread.sleep(2000);
        clickOnElement(viewCartButton);
    }

    public void verifyTextSortByDescending() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> originalList = driver.findElements(productAlphabetSort);
        waitUntilVisibilityOfElementLocated(productAlphabetSort, 10);
        List<String> originalProductNameList = new ArrayList<>();
        for (WebElement product : originalList) {
            originalProductNameList.add(product.getText());
        }
        originalProductNameList.sort(String.CASE_INSENSITIVE_ORDER.reversed());
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

    public void verifyTextSortByHighToLow() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> originalList = driver.findElements(productPriceSort);
        waitUntilVisibilityOfElementLocated(productPriceSort, 10);
        List<Double> originalProductPriceList = new ArrayList<>();
        for (WebElement product : originalList) {
            originalProductPriceList.add(Double.parseDouble(product.getText().substring(1)));
        }
        originalProductPriceList.sort(Double::compareTo);
        List<Double> reverseProductPriceList = new ArrayList<>();
        for (int i = 1; i <= originalProductPriceList.size(); i++) {
            reverseProductPriceList.add(originalProductPriceList.get(originalProductPriceList.size() - i));
        }
        System.out.println(reverseProductPriceList);
        waitUntilVisibilityOfElementLocated(productPriceSort, 10);
        List<WebElement> afterSortingList = driver.findElements(productPriceSort);
        List<Double> afterSortingProductName = new ArrayList<>();
        for (WebElement product : afterSortingList) {
            afterSortingProductName.add(Double.parseDouble(product.getText().substring(1)));
        }
        System.out.println(afterSortingProductName);
        Assert.assertEquals("Product not sorted", reverseProductPriceList, afterSortingProductName);
    }

    By productRatesSort = By.cssSelector(".stars-row.full");

    public void verifyTextSortByRates() throws InterruptedException {
        List<WebElement> originalList = driver.findElements(productRatesSort);
        List<Integer> originalProductRateList = new ArrayList<>();
        for (WebElement product : originalList) {
            originalProductRateList.add(Integer.parseInt(product.getAttribute("style").substring(7,9)));
        }
        originalProductRateList.sort(Collections.reverseOrder());
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

