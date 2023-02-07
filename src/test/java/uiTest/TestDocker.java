package uiTest;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestDocker {
    private Locators locators = new Locators();

    private static void configurationRemote() {
        //Указание базовой url тестируемого сайта
        Configuration.baseUrl = "https://testit.software/";
        //Указание удаленной url для selenoid
        if(System.getenv("StartRemote").equals("yes")){
            Configuration.remote = "http://kubernetes.docker.internal:4444/wd/hub";
        }
        //Определение типа браузера = chrome
        Configuration.browser = "chrome";
        //Отключение системы безопасности браузера
        System.setProperty("chromeoptions.args", "--no-sandbox");
        //Параметры для игнорирования ошибок сертификта
        System.setProperty("chromeoptions.args", "--ignore-certificate-errors");
        //Определение расширения браузера
        Configuration.browserSize = "1920x1080";
        //Создаём объект класса DesiredCapabilities, используется как настройка  вашей конфигурации с помощью пары ключ-значение
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //Включить поддержку отображения экрана браузера во время выполнения теста
        capabilities.setCapability("enableVNC",true);
        //Включение записи видео в процессе выполнения тестов
        capabilities.setCapability("enableVideo",true);
        //Переопределяем Browser capabilities
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeAll
    public static void setUp() {
        configurationRemote();
    }

    @AfterAll
    public static void tearDown() {
        Selenide.closeWebDriver();
    }

    @BeforeEach
    public void prepareForTest() {
        open("/");
    }

    @Test
    @DisplayName("Переход в раздел 'О продукте' в подраздел 'Автоматизация тестирования'")
    public void aboutOfProductTest() {
        $("h1[class='title intro__title']").shouldHave(Condition.ownText("Единый интерфейс"));
        locators.clickNavLink("О продукте");
        locators.clickSubNavLink("Автоматизация тестирования");
        locators.checkTextSubNavLink("Автоматизация");
    }

    @Test
    @DisplayName("Переход в раздел 'Версии' в подраздел 'Enterprise VS Cloud'")
    public void aboutOfVersionProductTest() {
        $("h1[class='title intro__title']").shouldHave(Condition.ownText("Единый интерфейс"));
        locators.clickNavLink("Версии");
        locators.clickSubNavLink("Enterprise VS Cloud");
        locators.checkTextSubNavLink("Cloud или Enterprise — что выбрать?");
    }

    @Test
    @DisplayName("Переход в раздел 'Цены' в подраздел 'Enterprise'")
    public void aboutOfPriceForProductTest() {
        $("h1[class='title intro__title']").shouldHave(Condition.ownText("Единый интерфейс"));
        locators.clickNavLink("Цена");
        locators.clickSubNavLink("Enterprise");
        $x("//h3[@class='form-calc__startup-title']").shouldHave(Condition.ownText("Скидка за кейс"));
    }
}
