package uiTest;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.Condition;

public class Locators {

    public void clickNavLink(String nameNavLink) {
        $x("//span[contains(normalize-space(.),'" + nameNavLink + "')]").click();
    }

    public void clickSubNavLink(String nameSubNavLink) {
        $x("//a[contains(normalize-space(.),'" + nameSubNavLink + "')]").click();
    }

    public void checkTextSubNavLink(String nameSubNavLink) {
        $x("//h1[@class='title intro__title']").shouldHave(Condition.ownText(nameSubNavLink));
    }
}
