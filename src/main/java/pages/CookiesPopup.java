package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CookiesPopup {

    public SelenideElement agreeBtn = $(By.id("L2AGLb"));
    public SelenideElement languageBtn = $(By.id("vc3jof"));
    public SelenideElement languageDropList =$(By.id("tbTubd"));

    public ElementsCollection languagesList = languageDropList.$$x(".//li");
}
