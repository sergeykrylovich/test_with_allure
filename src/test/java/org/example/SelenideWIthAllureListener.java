package org.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.selectedText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideWIthAllureListener {

    @Test
    public void TestIssueSearchWithAllureListener () {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        open("https://github.com/");
        $(".header-search-input").click();
        $(".header-search-input").setValue("sergeykrylovich/demoqa-test-pageobject");
        $(".header-search-input").submit();
        $(byLinkText("sergeykrylovich/demoqa-test-pageobject")).click();
        $("[data-content=Issues]").shouldHave(text("Issues"));


    }
}
