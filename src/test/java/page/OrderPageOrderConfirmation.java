package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPageOrderConfirmation {
    private final WebDriver driver;
    //Кнопка "Да"
    private final By okButton = By.xpath(".//*[text()='Да']");

    public OrderPageOrderConfirmation(WebDriver driver) {
        this.driver = driver;
    }

    //Подтвердить оформление заказа
    public void clickOkButton() {
        driver.findElement(okButton).click();
    }
}


