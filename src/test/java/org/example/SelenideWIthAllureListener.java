package org.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.selectedText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideWIthAllureListener extends TestBase {

    @Test
    public void TestIssueSearchWithAllureListener () {
        open("https://github.com/");
        $(".header-search-input").click();
        $(".header-search-input").setValue(REPO);
        $(".header-search-input").submit();
        $(byLinkText(REPO)).click();
        $("[data-content=Issues]").shouldHave(text("Issues"));


    }
}
