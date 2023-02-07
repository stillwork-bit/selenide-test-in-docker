package uiTest;

import static com.codeborne.selenide.Condition.ownText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Condition;
import java.time.Duration;
import model.CssLocators;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class CssTest extends BaseTest {
    private CssLocators cssLocators = new CssLocators();
    private static String fullHeaderButton = "Naughty or Nice List";

    @BeforeEach
    public void prepareForTest() {

        open("http://www.northpole.com/");
    }

    @Test
    @Order(1)
    @DisplayName("Переход на главную страницу c локатором по имени элемента и атрибуту класса")
    public void fullHeaderHome() {
        cssLocators.approveCookieWindow();
        cssLocators.homePage.shouldBe(visible, Duration.ofSeconds(10));
    }

    @Test
    @Order(2)
    @DisplayName("Поиск по абсолютному совпадению заголовка 'Naughty or Nice List' кнопки Naughty or Nice List")
    public void fullHeaderButton() {
        cssLocators.fullHeaderButton.shouldBe(Condition.visible, Duration.ofSeconds(10))
                                    .shouldHave(ownText(fullHeaderButton));
    }

    @Test
    @Order(3)
    @DisplayName("Поиск по частичному совпадению заголовка 'ghty or Nice' кнопки Naughty or Nice List")
    public void partialHeaderButton() {
        cssLocators.partialHeaderButton.shouldBe(visible, Duration.ofSeconds(10))
                                       .shouldHave(ownText(fullHeaderButton));
    }

    @Test
    @Order(4)
    @DisplayName("Поиск кнопки по атрибуту href с проверкой перехода на страницу Naughty Or NiceList")
    public void openNaughtyOrNiceListByClassAndHrefButton() {
        cssLocators.openNaughtyOrNiceListByClassAndHrefButton.shouldBe(visible, Duration.ofSeconds(10))
                                                             .click();
        cssLocators.headerNaughtyOrNiceListPage.shouldBe(visible, Duration.ofSeconds(10));
    }

    @Test
    @Order(5)
    @DisplayName("Поиск по частичному совпадению значения атрибута")
    public void tableQuestionsByPartialIdField() {
        cssLocators.openNaughtyOrNiceListByClassAndHrefButton.shouldBe(visible, Duration.ofSeconds(10))
                                                             .click();
        cssLocators.tableQuestionsByPartialIdField.shouldBe(visible, Duration.ofSeconds(10))
                                                  .click();
    }

    @Test
    @Order(6)
    @DisplayName("Поиск по id элемента")
    public void searchHeaderTopByIdField() {
        cssLocators.openNaughtyOrNiceListByClassAndHrefButton.shouldBe(visible, Duration.ofSeconds(10))
                                                             .click();
        cssLocators.headerTopByIdField.shouldBe(visible, Duration.ofSeconds(10));
    }

    @Test
    @Order(7)
    @DisplayName("Поиск по индексу в таблице, фильтр элемента по букве 'i', далее взять элемент по совпадению с индексом 0 и найти элемент input и кликнуть его")
    public void searchTextAndGoParentRadioButton() {
        cssLocators.openNaughtyOrNiceListByClassAndHrefButton.shouldBe(visible, Duration.ofSeconds(10))
                                                             .click();
        cssLocators.searchElementAndFilterAndClickRadioButton.filterBy(text("i"))
                                                             .get(0)
                                                             .find(By.xpath("./input"))
                                                             .click();
    }
}
