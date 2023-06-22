package org.example;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SelenideWithAllureStep extends TestBase{
    @Test
    public void TestIssueSearchWithAllureSteps () {
        step("Open main url of GitHub", () -> {
            open("https://github.com/");
        });

        step("Searching repo " + REPO, () -> {
            $(".header-search-input").click();
            $(".header-search-input").setValue(REPO);
            $(".header-search-input").submit();
        });
        step("Click on repo " + REPO, () -> {
            $(byLinkText(REPO)).click();
        });

        step("Assert that Issue is visible", () -> {
            $("[data-content=Issues]").shouldHave(text("Issues"));
        });
    }


}
