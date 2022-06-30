package tests;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.DataProvider;
import testSetup.TestMain;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PageFactory;
import utils.DataProviders;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;


public class HomePage extends TestMain {
    PageFactory pages = new PageFactory();


    @BeforeMethod
    public void beforeTestCase() {

        open("http://google.com");

        // Accept cookies policy
        pages.homePage.cookiesPopup.languageBtn.shouldBe(enabled).click();
        pages.homePage.cookiesPopup.languagesList.get(10).click();
        pages.homePage.cookiesPopup.agreeBtn.shouldBe(enabled).click();
    }

    @AfterMethod
    public void afterTestCase() {
        WebDriverRunner.closeWebDriver();
    }

    @Test()
    public void TC01_HomePageOpen() {

        // 1. Click [Search] button
        pages.homePage.searchBtn.shouldBe(enabled);

        // Verify elements on the page
        pages.homePage.luckySearchBtn.shouldBe(enabled);
        pages.homePage.searchBar.shouldBe(enabled);
        pages.homePage.gmailBtn.shouldBe(enabled);
        pages.homePage.imagesBtn.shouldBe(enabled);
        pages.homePage.appsBtn.shouldBe(enabled);
        pages.homePage.signInBtn.shouldBe(enabled);
    }


    @Test()
    public void TC02_GmailPageOpen() {

        // 1. Click [Gmail] button
        pages.homePage.gmailBtn.shouldBe(enabled).click();

        // Verify elements on the page
        pages.gmailWelcomePage.forWorkBtn.shouldBe(enabled);
        pages.gmailWelcomePage.signInBtn.shouldBe(enabled);
        pages.gmailWelcomePage.getGmailBtn.shouldBe(enabled);

    }

    @Test()
    public void TC03_ImagesPageOpen() {

        // 1. Click [Images] button
        pages.homePage.imagesBtn.shouldBe(enabled).click();

        // Verify elements on the page
        pages.imagesPage.imagesLogo.shouldBe(visible);
        pages.imagesPage.searchByImageBtn.shouldBe(enabled);


    }

    @Test()
    public void TC04_AppsPageOpen() {

        // 1. Click [Apps] button
        pages.homePage.appsBtn.shouldBe(enabled).click();

        // Switch to frame and verify elements
        switchTo().frame(0);
        pages.homePage.appList.shouldBe(visible);
        pages.homePage.appList.$$(By.tagName("li")).shouldHave(size(16));

    }


    @Test(dataProvider = "search", dataProviderClass = DataProviders.class)
    public void TC05_HomePageSearch(String item) {

        // 1. Open home page
        TC01_HomePageOpen();

        // 2. Search for result
        pages.homePage.searchItem(item);

        // Verify elements on the page
        pages.searchResultsPage.resultStats.shouldBe(visible);
        pages.searchResultsPage.searchListAll.shouldHave(sizeGreaterThan(0));
        pages.searchResultsPage.searchBar.shouldBe(enabled).shouldHave(value(item));
        pages.searchResultsPage.nextPageBtn.shouldBe(enabled);
        pages.searchResultsPage.appsBtn.shouldBe(enabled);
        pages.searchResultsPage.signInBtn.shouldBe(enabled);
        pages.searchResultsPage.pagesTable.$$x(".//td").shouldHave(sizeGreaterThan(0));
        pages.searchResultsPage.searchModeAllBtn.shouldBe(enabled);
        pages.searchResultsPage.searchModeImagesBtn.shouldBe(enabled);
        pages.searchResultsPage.searchModeNewsBtn.shouldBe(enabled);
        pages.searchResultsPage.searchModeVideosBtn.shouldBe(enabled);
        pages.searchResultsPage.searchModeMapsBtn.shouldBe(enabled);

    }

    @Test(dataProvider = "pagination", dataProviderClass = DataProviders.class)
    public void TC06_SearchResultPagination(int page) {

        // 1. Open home page
        TC01_HomePageOpen();

        // 2. Search for result
        pages.homePage.searchItem("Axl");

        // Search page is opened
        pages.searchResultsPage.resultStats.shouldBe(visible);

        // 3. Click on Page 10
        pages.searchResultsPage.clickOnPage(page);

        // Verify elements on the page
        pages.searchResultsPage.resultStats.shouldBe(visible).shouldHave(text("Page " + page));
        pages.searchResultsPage.nextPageBtn.shouldBe(enabled);
        pages.searchResultsPage.previousPageBtn.shouldBe(enabled);
    }

    @Test()
    public void TC07_SearchByImages() {

        // 1. Open home page
        TC01_HomePageOpen();

        // 2. Search for result
        pages.homePage.searchItem("Axl");

        // Search page is opened
        pages.searchResultsPage.resultStats.shouldBe(visible);

        // 3. Click on [Images] button
        pages.searchResultsPage.searchModeImagesBtn.shouldBe(enabled).click();

        // Verify elements on the page
        pages.searchResultsPage.searchListImages.shouldHave(sizeGreaterThan(0));

    }

    @Test()
    public void TC08_SearchByNews() {

        // 1. Open home page
        TC01_HomePageOpen();

        // 2. Search for result
        pages.homePage.searchItem("Slash");

        // Search page is opened
        pages.searchResultsPage.resultStats.shouldBe(visible);

        // 3. Click on [News] button
        pages.searchResultsPage.searchModeNewsBtn.shouldBe(enabled).click();

        // Verify elements on the page
        pages.searchResultsPage.searchListNews.shouldHave(sizeGreaterThan(0));
    }

    @Test()
    public void TC09_SearchByVideos() {

        // 1. Open home page
        TC01_HomePageOpen();

        // 2. Search for result
        pages.homePage.searchItem("Duff");

        // Search page is opened
        pages.searchResultsPage.resultStats.shouldBe(visible);

        // 3. Click on [Videos] button
        pages.searchResultsPage.searchModeVideosBtn.shouldBe(enabled).click();

        // Verify elements on the page
        pages.searchResultsPage.searchListVideos.shouldHave(sizeGreaterThan(0));

    }

    @Test()
    public void TC10_SearchByMaps() {

        // 1. Open home page
        TC01_HomePageOpen();

        // 2. Search for result
        pages.homePage.searchItem("Izzy");

        // Search page is opened
        pages.searchResultsPage.resultStats.shouldBe(visible);

        // 3. Click on [Maps] button
        pages.searchResultsPage.searchModeMapsBtn.shouldBe(enabled).click();

        // Verify elements on the page
        pages.searchResultsPage.searchListMap.shouldHave(sizeGreaterThan(0));
        pages.searchResultsPage.mapCanvas.shouldBe(visible);

    }


}
