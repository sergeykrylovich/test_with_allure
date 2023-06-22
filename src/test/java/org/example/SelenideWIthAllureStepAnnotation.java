package org.example;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

public class SelenideWIthAllureStepAnnotation extends TestBase{
    StepsAnnotation steps = new StepsAnnotation();
    @Test
    @Feature("Issue in the target repo")
    @Story("Issue is visible")
    @Description(value = "Test that menu 'Issues' is visible")
    @Severity(SeverityLevel.NORMAL)
    @Owner(value = "Sergey Krylovich")
    public void TestIssueSearchWithAllureStepAnnotation () {

        steps.openMainPage();
        steps.takeScreenshot();
        steps.searchRepoOnGitHub();
        steps.takeScreenshot();
        steps.openRepoByClick();
        steps.checkIssueIsVisibleInRepo();
        steps.takeScreenshot();
    }
}
