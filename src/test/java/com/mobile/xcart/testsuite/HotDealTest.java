package com.mobile.xcart.testsuite;

import com.mobile.xcart.pages.BestsellersPage;
import com.mobile.xcart.pages.HomePage;
import com.mobile.xcart.pages.SalePage;
import com.mobile.xcart.testbase.TestBase;
import org.testng.annotations.Test;

public class HotDealTest extends TestBase {

    HomePage homePage = new HomePage();
    SalePage salePage = new SalePage();
    BestsellersPage bestsellersPage = new BestsellersPage();


    @Test
    public void verifySaleProductsArrangeAlphabetically() throws InterruptedException {
        homePage.setHotDealsLink();
        homePage.setSaleLink();
        salePage.saleTextVerify();
        salePage.sortByMouseHover();
        salePage.selectAToZClick();
        salePage.verifyTextSortByAscending();
    }

    @Test
    public void verifySaleProductsArrangeLowToHigh() throws InterruptedException {
        homePage.setHotDealsLink();
        homePage.setSaleLink();
        salePage.saleTextVerify();
        salePage.sortByMouseHover();
        salePage.selectPriceLowToHighClick();
        salePage.verifyTextSortByLowToHigh();
    }

    @Test
    public void verifySaleProductsArrangeByRates() throws InterruptedException {
        homePage.setHotDealsLink();
        homePage.setSaleLink();
        salePage.saleTextVerify();
        salePage.sortByMouseHover();
        salePage.selectRatesClick();
        salePage.verifyTextSortByRates();
    }

    @Test
    public void verifyBestSellersProductsArrangeByZToA() throws InterruptedException {
        homePage.setHotDealsLink();
        homePage.setBestSellersLink();
        bestsellersPage.saleTextVerify();
        bestsellersPage.sortByMouseHover();
        bestsellersPage.selectZToAClick();
        bestsellersPage.verifyTextSortByDescending();
    }

    @Test
    public void verifyBestSellersProductsArrangeHighToLow() throws InterruptedException {
        homePage.setHotDealsLink();
        homePage.setBestSellersLink();
        bestsellersPage.saleTextVerify();
        bestsellersPage.sortByMouseHover();
        bestsellersPage.selectPriceHighToLowClick();
        bestsellersPage.verifyTextSortByHighToLow();
    }

    @Test
    public void verifyBestSellersProductsArrangeByRates() throws InterruptedException {
        homePage.setHotDealsLink();
        homePage.setBestSellersLink();
        bestsellersPage.saleTextVerify();
        bestsellersPage.sortByMouseHover();
        bestsellersPage.selectRatesClick();
        bestsellersPage.verifyTextSortByRates();
    }
}
