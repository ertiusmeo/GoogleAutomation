package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Page {

    public SelenideElement searchBar = $x(".//input[contains(@class, 'gsfi')]");
    public SelenideElement appsBtn = $x("//*[@aria-label='Google apps']");
    public SelenideElement signInBtn = $(By.linkText("Sign in"));

    public SelenideElement appList = $x("//ul[@class='LVal7b u4RcUd']");




}
