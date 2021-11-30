package com.mobile.xcart.pages;

import com.mobile.xcart.utility.Utility;
import org.openqa.selenium.By;

public class OrderPage extends Utility {

    By orderText = By.xpath("//h1[contains(.,'Thank you for your order')]");


   public void verifyOrderText() throws InterruptedException {
       Thread.sleep(2000);
       verifyText("Thank you for your order", orderText, "Error, Message not displayed as expected");
   }
}
