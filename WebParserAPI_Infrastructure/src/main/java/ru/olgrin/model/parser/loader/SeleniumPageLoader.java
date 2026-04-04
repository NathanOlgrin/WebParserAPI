package ru.olgrin.model.parser.loader;

import org.openqa.selenium.WebDriver;

public class SeleniumPageLoader implements PageLoader {

    private WebDriver driver;

    public SeleniumPageLoader(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public String load(String url) throws Exception {
        driver.get(url);
        return driver.getPageSource();
    }
}
