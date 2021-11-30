package com.mobile.xcart.utility;

import com.google.common.base.Function;
import com.mobile.xcart.drivermanager.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import javax.annotation.Nullable;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Utility extends DriverManager {

    //This method will click on element
    public void clickOnElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }

    //This method will get text from element
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    //This method will sendKeys in to element
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

//    public void actionMouseHoverAndCLickOnListElement(){
//        sortByValueTab,ratesTab
//    }

    //This method for visible text in dropdown
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    //This method for value from dropdown
    public void selectByValueFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(text);
    }

    //This method for Index from dropdown
    public void selectByIndexFromDropDown(By by, int index) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(index);
    }

    //This method for accept alert
    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    //This method for dismiss alert
    public void dismissAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    //This method will get text from alert
    public String getTextFromAlert() {
        Alert alert = driver.switchTo().alert();
        String textOnAlert = alert.getText();
        System.out.println(textOnAlert);
        return textOnAlert;
    }

    // This method will drag an element and drop it onto another
    public void dragAndDrop(By drag, By drop) {
        Actions actions = new Actions(driver);
        WebElement draggable = driver.findElement(drag);
        WebElement droppable = driver.findElement(drop);
        actions.dragAndDrop(draggable, droppable).build().perform();
    }

    // This method is for keyboard events on elements
    public void sendKeysToElement(By by, CharSequence keys) {
        driver.findElement(by).sendKeys(keys);
    }

    // This method is for keyboard events (e.g. CTRL + A, CTRL + C, CTRL + V)
    public void sendKeys(@Nullable CharSequence precedingKeys, CharSequence keys) {
        new Actions(driver).keyDown(precedingKeys).sendKeys(keys).build().perform();
    }

    public void verifyText(String exceptedMessage, String actualMessage, @Nullable String errorMessage) {
        Assert.assertEquals(errorMessage == null ? "" : errorMessage, exceptedMessage, actualMessage);
    }

    public void verifyText(String expectedMessage, By by, String displayMessage) {
        String actualMessage = getTextFromElement(by);
        Assert.assertEquals(displayMessage, expectedMessage, actualMessage);
    }

    public void mouseHoverClick(By by) throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement mouseHoover = driver.findElement(by);
        Thread.sleep(2000);
        actions.moveToElement(mouseHoover).click().build().perform();
    }

    public void mouseHoverOnly(By by) throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement mouseHoover = driver.findElement(by);
        Thread.sleep(2000);
        actions.moveToElement(mouseHoover).build().perform();
    }

    public WebElement waitUntilVisibilityOfElementLocated(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitForElementWithFluentWait(By by, int time, int pollingTime) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
        return element;
    }
    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString() + "@gmail.com";
        return saltStr;

    }

    public List<String> sortAlphabeticAscending(List<String> strings) {
        strings.sort(String::compareTo);
        return strings;
    }


}





