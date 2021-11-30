package com.mobile.xcart.pages;

import com.mobile.xcart.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class SecureCheckOutPage extends Utility {
    By secureCheckOutText = By.xpath("//h1[contains(text(),'Secure Checkout')]");
    By firstName = By.xpath("//input[@id='shippingaddress-firstname']");
    By lastName = By.xpath("//input[@id='shippingaddress-lastname']");
    By address = By.xpath("//input[@id='shippingaddress-street']");
    By city = By.xpath("//input[@id='shippingaddress-city']");
    By country = By.xpath("//select[@id='shippingaddress-country-code']");
    By state = By.xpath("//input[@id='shippingaddress-custom-state']");
    By zipCode = By.xpath("//input[@id='shippingaddress-zipcode']");
    By createAnAccount = By.xpath("//input[@id='create_profile']");
    By password = By.xpath("//input[@id='password']");
    By deliveryMethod = By.xpath("//span[normalize-space()='Local shipping']");
    By paymentMethod = By.xpath("//span[normalize-space()='COD']");
    By total = By.xpath("//span[contains(text(),'$37.03')]");
    By placeOrder = By.xpath("//button[@class='btn regular-button regular-main-button place-order submit']");






    public void verifySecureCheckoutText() throws InterruptedException {
        Thread.sleep(2000);
        verifyText("Secure Checkout", secureCheckOutText, "Error, Message not displayed as expected");
    }

    public void setFirstName() {sendKeysToElement(firstName, "Bob");}

    public void setLastName() {sendKeysToElement(lastName, "Alexa");}

    public void setAddress() {sendKeysToElement(address, "69 Haydon Drive");}

    public void setCity() {sendKeysToElement(city, Keys.CLEAR + "London");}

    public void setCountry() {selectByVisibleTextFromDropDown(country, "United Kingdom");}

    public void setState() {sendKeysToElement(state, "London, City of");}

    public void setZipCode() {sendKeysToElement(zipCode, Keys.BACK_SPACE + "1");}

    public void setCreateAnAccount() {clickOnElement(createAnAccount);}

    public void setPassword() {sendKeysToElement(password, "abc123");}

    public void setDeliveryMethod(){clickOnElement(deliveryMethod);}

    public void setPaymentMethod(){clickOnElement(paymentMethod);}

    public void setTotal(){verifyText("Place order: $37.03", total, "Error, Message not displayed as expected");}

    public void setPlaceOrder() throws InterruptedException {
        Thread.sleep(2000);
        clickOnElement(placeOrder);}

}
