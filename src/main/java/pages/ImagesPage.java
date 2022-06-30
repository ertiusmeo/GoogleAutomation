package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ImagesPage extends Page{


    public SelenideElement imagesLogo = $(By.className("T8VaVe"));
    public SelenideElement searchByImageBtn = $(By.className("tdPRye"));


}
