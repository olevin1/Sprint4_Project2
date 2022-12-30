package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;

    @Before
    public void setUp() {
        /**
         Выбор браузера для запуска тестов
         */

        /**
         Драйвер для запуска тестов в Chrome
         Закомментируй две строки ниже (если не нужен запуск тестов в Chrome)
         или раскомментируй (если хочешь запустить тесты в Chrome)
         */
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();

        /**
         Драйвер для запуска тестов в Firefox
         Закомментируй две строки ниже(если не нужен запуск тестов в Firefox)
         или раскомментируй (если хочешь запустить тесты в Firefox)
         */
//        System.setProperty("webdriver.firefox.driver", "geckodriver.exe");
//        driver = new FirefoxDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
