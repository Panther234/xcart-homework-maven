package com.mobile.xcart.testsuite;

import com.mobile.xcart.pages.HomePage;
import com.mobile.xcart.testbase.TestBase;
import org.testng.annotations.Test;

public class TopMenuTest extends TestBase {
    HomePage homePage = new HomePage();

    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully(){
        homePage.setShippingLink();
        homePage.verifyShippingText();
    }
    @Test
    public void verifyUserShouldNavigateToNewPageSuccessfully(){
        homePage.setNewLink();
        homePage.verifyNewText();
    }
    @Test
    public void verifyUserShouldNavigateToComingSoonPageSuccessfully(){
        homePage.setComingSoonLink();
        homePage.verifyComingSoonText();
    }
    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully(){
        homePage.setContactUsLink();
        homePage.verifyContactUsText();
    }

}
