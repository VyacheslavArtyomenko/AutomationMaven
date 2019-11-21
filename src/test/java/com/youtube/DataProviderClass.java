package com.youtube;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
    @DataProvider(name = "set1")
    public Object[][] dataProvider() {
        return new Object[][]{{"nature"}, {"music"}, {"other"}};
    }
}
