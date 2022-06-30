package testSetup;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


public abstract class TestMain {

    @BeforeSuite
    public void beforeSuite(){
        Configuration.timeout = 6000;
        Configuration.browserSize="1920x1080";
    }
    @BeforeClass
    public void beforeClass() {

        Selenide.open("http://google.com");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        WebDriverRunner.closeWebDriver();
    }

}
