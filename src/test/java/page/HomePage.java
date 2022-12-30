package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private final WebDriver driver;
    // Кнопка Куки
    private final By cookieButton = By.id("rcc-confirm-button");
    // Кнопка "Заказать" сверху
    private final By upperOrderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    // Кнопка "Заказать" снизу
    private final By lowerOrderButton = By.className("Button_Middle__1CSJM");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void cookieButtonClick() {
        if (!driver.findElements(cookieButton).isEmpty()) {
            driver.findElement(cookieButton).click();
        }
    }

    public void upperOrderButtonClick() {
        driver.findElement(upperOrderButton).click();
    }

    public void lowerOrderButtonClick() {
        WebElement element = driver.findElement(lowerOrderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(lowerOrderButton).click();
    }

    public void chooseOrderButtonAndClick(String buttonLocation) {
        if ("upper".equals(buttonLocation)) {
            upperOrderButtonClick();
        } else if ("lower".equals(buttonLocation)) {
            lowerOrderButtonClick();
        }
    }
}
