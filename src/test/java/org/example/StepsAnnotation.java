package org.example;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.commands.TakeScreenshot;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StepsAnnotation extends TestBase{


    @Step("Open main page of GitHub {URL}")
    public void openMainPage () {
        open(URL);
    }

    @Step("Search {REPO} on Github main page")
    public void searchRepoOnGitHub () {
        $(".header-search-input").click();
        $(".header-search-input").setValue(REPO);
        $(".header-search-input").submit();
    }

    @Step("Open {REPO} by clicking on the link")
    public void openRepoByClick () {
        $(byLinkText("sergeykrylovich/demoqa-test-pageobject")).click();
    }

    @Step("Check that Issue is visible")
    public static void checkIssueIsVisibleInRepo() {
        $("[data-content=Issues]").shouldHave(text("Issues"));
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = ".png")
    public byte[] takeScreenshot () {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }


}
