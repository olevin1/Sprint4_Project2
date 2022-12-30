package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderPageRentalCondition {
    private final WebDriver driver;
    //Максимальный срок аренды.
    public static final int MAX_PERIOD = 7;
    //Поле "Когда привезти самокат".
    private final By date = By.xpath(".//div[@class='react-datepicker__input-container']/input");
    //Поле "Срок аренды".
    private final By period = By.className("Dropdown-placeholder");
    //Чекбокс "Цвет черный жемчуг".
    private final By blackColor = By.xpath(".//input[@id='black']");
    //Чекбокс "Цвет серая безысходность".
    private final By greyColor = By.xpath(".//input[@id='grey']");
    //Поле "Комментарий для курьера".
    private final By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Кнопка "Заказать".
    private final By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    private final By[] periodDays = getPeriodDays();

    /**
     * Значения поля Срок аренды:
     * Индекс [0] - значение "сутки"
     * Индекс [1] - значение "двое суток"
     * Индекс [2] - значение "трое суток"
     * Индекс [3] - значение "четверо суток"
     * Индекс [4] - значение "пятеро суток"
     * Индекс [5] - значение "шестеро суток"
     * Индекс [6] - значение "семеро суток"
     */
    private By[] getPeriodDays() {
        By[] periodDays = new By[MAX_PERIOD];
        for (int i = 0, j = 1; i < MAX_PERIOD; i++, j++) {
            periodDays[i] = By.xpath(".//*[@class='Dropdown-option'][" + j + "]");
        }
        return periodDays;
    }

    public OrderPageRentalCondition(WebDriver driver) {
        this.driver = driver;
    }

    //Заполнить поле "Когда привезти самокат"
    public void inputDate(String newDate) {
        driver.findElement(date).sendKeys(newDate);
        driver.findElement(date).sendKeys(Keys.ENTER);
    }

    //Заполнить поле "Срок аренды"
    public void inputPeriod(int numberPeriod) {
        driver.findElement(period).click();
        driver.findElement(periodDays[numberPeriod - 1]).click();
    }

    //Выбрать цвет самоката "Черный жемчуг"
    public void clickBlackColor() {
        driver.findElement(blackColor).click();
    }

    //Выбрать цвет самоката "Серая безысходность"
    public void clickGreyColor() {
        driver.findElement(greyColor).click();
    }

    //Заполнить поле "Цвет самоката"
    public void chooseColor(String newColor) {
        if ("black".equals(newColor)) {
            clickBlackColor();
        } else if ("grey".equals(newColor)) {
            clickGreyColor();
        }
    }

    //Заполнить поле "Комментарий для курьера"
    public void inputComment(String newComment) {
        driver.findElement(comment).sendKeys(newComment);
    }

    //Нажать кнопку "Заказать"
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    //Заполнить данные на странице "Про аренду"
    public void fill(String newDate, int numberPeriod, String newColor, String newComment) {
        inputDate(newDate);
        inputPeriod(numberPeriod);
        chooseColor(newColor);
        inputComment(newComment);
        clickOrderButton();
    }
}
