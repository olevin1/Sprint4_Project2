package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultPage {
    private final WebDriver driver;
    //Сообщение "Заказ оформлен"
    private final By resultMessage = By.className("Order_ModalHeader__3FDaJ");

    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }

    //Получить подтверждение оформления заказа
    public String getResultMessage() {
        return driver.findElement(resultMessage).getText();
    }

}
