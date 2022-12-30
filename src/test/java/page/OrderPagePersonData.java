package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderPagePersonData {
    private final WebDriver driver;
    //Поле "Имя"
    private final By name = By.xpath(".//div[@class='Order_Content__bmtHS']//input[1]");
    //Поле "Фамилия"
    private final By surname = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле "Адрес: куда привезти"
    private final By address = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поле "Станция метро"
    private final By metro = By.xpath(".//input[@placeholder='* Станция метро']");
    //Поле "Телефон: на него позвонит курьер"
    private final By phoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка "Далее"
    private final By nextButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");


    public OrderPagePersonData(WebDriver driver) {
        this.driver = driver;
    }

    //Заполнить поле "Имя"
    public void inputName(String newName) {
        driver.findElement(name).sendKeys(newName);
    }

    //Заполнить поле "Фамилия"
    public void inputSurname(String newSurname) {
        driver.findElement(surname).sendKeys(newSurname);
    }

    //Заполнить поле "Адрес:куда привезти заказ"
    public void inputAddress(String newAddress) {
        driver.findElement(address).sendKeys(newAddress);
    }

    //Заполнить поле "Станция метро"
    public void inputMetro(String newMetro) {
        driver.findElement(metro).click();
        driver.findElement(metro).sendKeys(newMetro);
        driver.findElement(metro).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }

    //Заполнить поле "Телефон:на него позвонит курьер"
    public void inputPhoneNumber(String newPhoneNumber) {
        driver.findElement(phoneNumber).sendKeys(newPhoneNumber);
    }

    //Нажать кнопку "Далее"
    public void nextButtonClick() {
        driver.findElement(nextButton).click();
    }

    //Заполнить данные на странице "Для кого самокат"
    public void fill(String newName, String newSurname, String newAddress, String newMetro, String newPhoneNumber) {
        inputName(newName);
        inputSurname(newSurname);
        inputAddress(newAddress);
        inputMetro(newMetro);
        inputPhoneNumber(newPhoneNumber);
        nextButtonClick();
    }
}
