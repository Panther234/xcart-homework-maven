package com.mobile.xcart.pages;

import com.mobile.xcart.utility.Utility;
import org.openqa.selenium.By;

public class HomePage extends Utility {
    By shippingLink = By.xpath("(//span[contains(text(),'Shipping')])[2]");
    By shippingText = By.xpath("//h1[@id='page-title']");
    By newLink = By.xpath("(//span[contains(text(),'New!')])[2]");
    By newLinkText = By.xpath("//h1[@id='page-title']");
    By comingSoonLink = By.xpath("(//span[contains(text(),'Coming soon')])[2]");
    By comingSoonText = By.xpath("//h1[@id='page-title']");
    By contactUsLink = By.xpath("(//span[contains(text(),'Contact us')])[2]");
    By contactUsText = By.xpath("//h1[@id='page-title']");
    By hotDealsLink = By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']");
    By saleLink = By.xpath("(//span[contains(text(),'Sale')])[2]");
    By bestSellersLink = By.xpath("(//span[contains(text(),'Bestsellers')])[2]");


    public void setShippingLink() {
        clickOnElement(shippingLink);
    }

    public void verifyShippingText() {
        verifyText("Shipping", shippingText, "Error-Message not displayed");
    }

    public void setNewLink() {
        clickOnElement(newLink);
    }

    public void verifyNewText() {
        verifyText("New arrivals", newLinkText, "Error-Message not displayed");
    }

    public void setComingSoonLink() {
        clickOnElement(comingSoonLink);
    }

    public void verifyComingSoonText() {
        verifyText("Coming soon", comingSoonText, "Error-Message not displayed");
    }
    public void setContactUsLink(){
        clickOnElement(contactUsLink);
    }
    public void verifyContactUsText(){
        verifyText("Contact us",contactUsText,"Error-Message not displayed");
    }
    public void setHotDealsLink() throws InterruptedException {
        mouseHoverOnly(hotDealsLink);
    }
    public void setSaleLink() throws InterruptedException {
        mouseHoverClick(saleLink);
    }
    public void setBestSellersLink() throws InterruptedException {
        mouseHoverClick(bestSellersLink);
    }

}
