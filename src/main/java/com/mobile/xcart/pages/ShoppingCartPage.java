package com.mobile.xcart.pages;

import com.mobile.xcart.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ShoppingCartPage extends Utility {
    By shoppingCartText1 = By.xpath("//h1[contains(text(),'Your shopping cart - 1 item')]");
    By changeQuantity = By.xpath("//input[contains(@id, 'amount16')]");
    By shoppingCartText2 = By.xpath("//h1[contains(text(),'Your shopping cart - 2 item')]");
    By subTotalIntegerText = By.xpath("//ul[@class='sums']//span[@class='part-integer'][normalize-space()='29']");
    By subTotalDecimalText = By.xpath("//ul[@class='sums']//span[@class='part-decimal'][normalize-space()='98']");
    By totalIntegerText = By.xpath("//span[normalize-space()='36']");
    By totalDecimalText = By.xpath("//span[normalize-space()='00']");
    By goToCheckOut = By.xpath("//button[contains(@class,'regular-button regular-main-button checkout')]");
    By emptyYourCart = By.xpath("//a[normalize-space()='Empty your cart']");
    By itemDeleteFromCartText = By.xpath("//li[contains(.,'Item(s) deleted from your cart')]");
    By closeTheMessage = By.xpath("//a[@title='Close']");
    By emptyCartMessage= By.xpath("//h1[contains(.,'Your cart is empty')]");




    public void shoppingCartText1Verify() {
        verifyText("Your shopping cart - 1 item", shoppingCartText1, "Error, Message not displayed as expected");
    }

    public void setChangeQuantity() {
        sendKeysToElement(changeQuantity, Keys.BACK_SPACE + "2");
    }

    public void shoppingCartText2Verify() throws InterruptedException {
        //waitUntilVisibilityOfElementLocated(shoppingCartText2, 20);
        Thread.sleep(2000);
        verifyText("Your shopping cart - 2 items", shoppingCartText2, "Error, Message not displayed as expected");
    }

    public void setSubTotalIntegerText() {
        verifyText("29", subTotalIntegerText, "Error, Message not displayed as expected");
    }

    public void setSubTotalDecimalText() {
        verifyText("98", subTotalDecimalText, "Error, Message not displayed as expected");
    }

    public void setTotalIntegerText() {
        verifyText("36", totalIntegerText, "Error, Message not displayed as expected");
    }

    public void setTotalDecimalText() {
        verifyText("00", totalDecimalText, "Error, Message not displayed as expected");
    }

    public void setGoToCheckOut() {
        clickOnElement(goToCheckOut);
    }

    public void setEmptyYourCart() {
        clickOnElement(emptyYourCart);
    }

    public void alertTextVerify() throws InterruptedException {
        Thread.sleep(2000);
        String Message = getTextFromAlert();
        verifyText("Are you sure you want to clear your cart?", Message, "Error, Message not displayed as expected");
        acceptAlert();
    }
    public void verifyItemDeletedFromCart(){
        verifyText("Item(s) deleted from your cart",itemDeleteFromCartText,"Error, Message not displayed");
    }
    public void setCloseTheMessage() throws InterruptedException {
        Thread.sleep(2000);
        clickOnElement(closeTheMessage);
    }
    public void setEmptyCartMessage() throws InterruptedException {
        Thread.sleep(2000);
        verifyText("Your cart is empty", emptyCartMessage, "Error, Message not displayed");
    }

}
