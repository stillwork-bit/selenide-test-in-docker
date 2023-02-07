package uiTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.remote.DesiredCapabilities;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseTest {

    public static void configurationRemote() {
        Configuration.baseUrl = "http://www.northpole.com/";
        Configuration.browser = "chrome";
        Configuration.browserVersion = "95";
        System.setProperty("chromeoptions.args", "--no-sandbox");
        System.setProperty("chromeoptions.args", "--ignore-certificate-errors");
        Configuration.remote = "http://kubernetes.docker.internal:4444/wd/hub";
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
}
