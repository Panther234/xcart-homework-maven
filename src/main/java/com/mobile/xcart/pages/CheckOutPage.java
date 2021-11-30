package com.mobile.xcart.pages;

import com.mobile.xcart.utility.Utility;
import org.openqa.selenium.By;

public class CheckOutPage extends Utility {

    By logInYourAccountText = By.xpath("//h3[contains(text(),'Log in to your account')]");
    By emailClick = By.id("email");
    By emailText = By.id("email");
    By continueButton = By.xpath("//button[contains(@class,'regular-button anonymous-continue-button submit')]");


    public void verifyLogInYourAccountText() {
        verifyText("Log in to your account", logInYourAccountText, "Error, Message not displayed as expected");
    }

    public void setEmailClick() {
        clickOnElement(emailClick);
    }

    public void setEmailText() {
        sendTextToElement(emailText, getSaltString());
    }

    public void clickContinueButton() {
        clickOnElement(continueButton);
    }

}
