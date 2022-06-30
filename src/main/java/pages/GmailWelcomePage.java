package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;

public class GmailWelcomePage extends Page{

    public ElementsCollection headerAsideButtons = $$x("//div[@class='header__aside__buttons']//a");
    public SelenideElement forWorkBtn = headerAsideButtons.get(0);
    public SelenideElement signInBtn = headerAsideButtons.get(1);
    public SelenideElement getGmailBtn = headerAsideButtons.get(2);

}
