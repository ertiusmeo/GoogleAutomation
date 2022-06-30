package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.*;

public class SearchResultsPage extends Page{

    public SelenideElement resultStats = $(By.id("result-stats"));
    public SelenideElement search = $(By.className("RNmpXc"));
    public ElementsCollection searchListAll=$$x("//*[@data-sokoban-container]");
    public SelenideElement pagesTable=$(By.className("AaVjTc"));
    public SelenideElement searchModes=$(By.className("MUFPAc"));
    public SelenideElement nextPageBtn=pagesTable.$x(".//span[text()='Next']");
    public SelenideElement previousPageBtn=pagesTable.$x(".//span[text()='Previous']");

    public SelenideElement searchModeAllBtn=searchModes.$x(".//*[text()='All']");
    public SelenideElement searchModeImagesBtn=searchModes.$x(".//*[text()='Images']");
    public SelenideElement searchModeNewsBtn=searchModes.$x(".//*[text()='News']");
    public SelenideElement searchModeVideosBtn=searchModes.$x(".//*[text()='Videos']");
    public SelenideElement searchModeMapsBtn=searchModes.$x(".//*[text()='Maps']");

    public ElementsCollection searchListImages=$$x("//*[@class='wXeWr islib nfEiy']");
    public ElementsCollection searchListNews=$$x("//*[@class='xuvV6b BGxR7d']");
    public ElementsCollection searchListVideos=$$x("//video-voyager");
    public ElementsCollection searchListMap=$$x("//*[@class='S9kvJb']/../../..");

    public SelenideElement mapCanvas=$x("//*[@class='MyME0d widget-scene-canvas']");


    public SearchResultsPage clickOnPage(int number)
    {
        pagesTable.$x(String.format(".//td//a[text()='%s']", number)).shouldBe(enabled).click();
        return this;
    }

}
