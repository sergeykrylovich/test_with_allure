package org.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    public final String REPO = "sergeykrylovich/demoqa-test-pageobject";
    public final String URL = "https://github.com/";
    @BeforeAll
    public static void initConfiguration () {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        Configuration.headless = true;
    }
}
