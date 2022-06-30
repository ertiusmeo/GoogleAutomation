package utils;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "pagination")
    public Object[][] pagination() {
        return new Object[][]{{3}, {5}, {10}};
    }

    @DataProvider(name = "search")
    public Object[][] search() {
        return new Object[][]{{"Axl"}, {"Slash"}, {"Izzy"}};
    }
}
