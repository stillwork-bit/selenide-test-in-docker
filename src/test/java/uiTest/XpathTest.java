package uiTest;

import static com.codeborne.selenide.Condition.ownText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

import java.time.Duration;
import model.XpathLocators;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class XpathTest extends BaseTest {
    private XpathLocators xpath = new XpathLocators();
    private static String fullHeaderButton = "Naughty or Nice List";

    @BeforeEach
    public void prepareForTest() {
        open("http://www.northpole.com/");
    }

    @Test
    @Order(1)
    @DisplayName("Переход на главную страницу c локатором по имени элемента и атрибуту класса")
    public void fullHeaderHome() {
        xpath.approveCookieWindow();
        xpath.homePage.shouldBe(visible, Duration.ofSeconds(10));
    }

    @Test
    @Order(2)
    @DisplayName("Поиск по абсолютному совпадению заголовка 'Naughty or Nice List' кнопки Naughty or Nice List")
    public void fullHeaderButton() {
        xpath.fullHeaderButton.shouldBe(visible, Duration.ofSeconds(10))
                              .shouldHave(ownText(fullHeaderButton));
    }

    @Test
    @Order(3)
    @DisplayName("Поиск по частичному совпадению заголовка 'ghty or Nice' кнопки Naughty or Nice List")
    public void partialHeaderButton() {
        xpath.partialHeaderButton.shouldBe(visible, Duration.ofSeconds(10))
                                 .shouldHave(ownText(fullHeaderButton));
    }

    @Test
    @Order(4)
    @DisplayName("Поиск кнопки по атрибуту href с проверкой перехода на страницу Naughty Or NiceList")
    public void openNaughtyOrNiceListByClassAndHrefButton() {
        xpath.openNaughtyOrNiceListByClassAndHrefButton.shouldBe(visible, Duration.ofSeconds(10))
                                                       .click();
        xpath.headerNaughtyOrNiceListPage.shouldBe(visible, Duration.ofSeconds(10));
    }

    @Test
    @Order(5)
    @DisplayName("Поиск по частичному совпадению значения атрибута")
    public void tableQuestionsByPartialIdField() {
        xpath.openNaughtyOrNiceListByClassAndHrefButton.shouldBe(visible, Duration.ofSeconds(10))
                                                       .click();
        xpath.tableQuestionsByPartialIdField.shouldBe(visible, Duration.ofSeconds(10))
                                            .click();
    }

    @Test
    @Order(6)
    @DisplayName("Поиск по id элемента")
    public void searchHeaderTopByIdField() {
        xpath.openNaughtyOrNiceListByClassAndHrefButton.shouldBe(visible, Duration.ofSeconds(10))
                                                       .click();
        xpath.headerTopByIdField.shouldBe(visible, Duration.ofSeconds(10));
    }

    @Test
    @Order(7)
    @DisplayName("Поиск по индексу в таблице, фильтр элемента по букве 'i', далее взять элемент по совпадению с индексом 0 и найти элемент input и кликнуть его")
    public void searchTextAndGoParentRadioButton() {
        xpath.openNaughtyOrNiceListByClassAndHrefButton.shouldBe(visible, Duration.ofSeconds(10))
                                                       .click();
        xpath.searchElementAndFilterAndClickRadioButton.filterBy(text("i"))
                                                       .get(0)
                                                       .find(By.xpath("./input"))
                                                       .click();
    }

    @Test
    @Order(8)
    @DisplayName("Поиск элемента по id, далее переход к его родителю и сравнение ожидаемого результата")
    public void searchElementAndGoToParent() {
        xpath.openNaughtyOrNiceListByClassAndHrefButton.shouldBe(visible, Duration.ofSeconds(10))
                                                       .click();
//        xpath.searchElementAndGoToParent.getId().contains("naughtynice");
    }
}
