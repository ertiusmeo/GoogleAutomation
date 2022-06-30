package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class HomePage extends Page{

    public CookiesPopup cookiesPopup = new CookiesPopup();

    public SelenideElement searchBtn = $(By.className("gNO89b"));
    public SelenideElement luckySearchBtn = $(By.className("RNmpXc"));
    public SelenideElement gmailBtn = $(By.linkText("Gmail"));
    public SelenideElement imagesBtn = $(By.linkText("Images"));


    public void searchItem(String item) {
        searchBar.sendKeys(item);
        searchBar.shouldBe(enabled).click();
        searchBtn.shouldBe(enabled).click();
    }


}
