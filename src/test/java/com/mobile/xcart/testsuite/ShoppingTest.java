package com.mobile.xcart.testsuite;

import com.mobile.xcart.pages.*;
import com.mobile.xcart.testbase.TestBase;
import org.testng.annotations.Test;

public class ShoppingTest extends TestBase {
    HomePage homePage = new HomePage();
    SalePage salePage = new SalePage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CheckOutPage checkOutPage = new CheckOutPage();
    SecureCheckOutPage secureCheckOutPage = new SecureCheckOutPage();
    OrderPage orderPage = new OrderPage();
    BestsellersPage bestsellersPage = new BestsellersPage();


    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForAvengersFabrikationsPlush() throws InterruptedException {
        homePage.setHotDealsLink();
        homePage.setSaleLink();
        salePage.saleTextVerify();
        salePage.sortByMouseHover();
        salePage.selectAToZClick();
        salePage.setAvengersMouseHover();
        salePage.addToCartButtonClick();
        salePage.addToCartTextVerify();
        salePage.clickCloseTheMessage();
        salePage.clickYourCartButton();
        salePage.clickViewCartButton();
        shoppingCartPage.shoppingCartText1Verify();
        shoppingCartPage.setChangeQuantity();
        shoppingCartPage.shoppingCartText2Verify();
        shoppingCartPage.setSubTotalIntegerText();
        shoppingCartPage.setSubTotalDecimalText();
        shoppingCartPage.setTotalIntegerText();
        shoppingCartPage.setTotalDecimalText();
        shoppingCartPage.setGoToCheckOut();
        checkOutPage.verifyLogInYourAccountText();
        checkOutPage.setEmailClick();
        checkOutPage.setEmailText();
        checkOutPage.clickContinueButton();
        secureCheckOutPage.verifySecureCheckoutText();
        secureCheckOutPage.setFirstName();
        secureCheckOutPage.setLastName();
        secureCheckOutPage.setAddress();
        secureCheckOutPage.setCity();
        secureCheckOutPage.setCountry();
        secureCheckOutPage.setState();
        secureCheckOutPage.setZipCode();
        secureCheckOutPage.setCreateAnAccount();
        secureCheckOutPage.setPassword();
        secureCheckOutPage.setDeliveryMethod();
        secureCheckOutPage.setPaymentMethod();
        secureCheckOutPage.setTotal();
        secureCheckOutPage.setPlaceOrder();
        orderPage.verifyOrderText();
    }
    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {
        homePage.setHotDealsLink();
        homePage.setBestSellersLink();
        bestsellersPage.saleTextVerify();
        bestsellersPage.sortByMouseHover();
        bestsellersPage.selectAToZClick();
        bestsellersPage.setVinylIdolz();
        bestsellersPage.setAddToCart();
        bestsellersPage.setAddToCartText();
        bestsellersPage.setCloseTheMessage();
        bestsellersPage.setYourCartButton();
        bestsellersPage.setViewCartButton();
        shoppingCartPage.shoppingCartText1Verify();
        shoppingCartPage.setEmptyYourCart();
        shoppingCartPage.alertTextVerify();
        shoppingCartPage.verifyItemDeletedFromCart();
        shoppingCartPage.setCloseTheMessage();
        shoppingCartPage.setEmptyCartMessage();
    }

}
