package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QuestionsPage {
    private final WebDriver driver;
    public static final int MAX_INDEX = 8;
    private final By[] buttonQuestionLocatorsArray = getButtonQuestionLocatorsArray();

    /**
     * Кнопки вопросов блока "Вопросы о важном":
     * Индекс [0] - Сколько это стоит? И как оплатить?
     * Индекс [1] - Хочу сразу несколько самокатов! Так можно?
     * Индекс [2] - Как рассчитывается время аренды?
     * Индекс [3] - Можно ли заказать самокат прямо на сегодня?
     * Индекс [4] - Можно ли продлить заказ или вернуть самокат раньше?
     * Индекс [5] - Вы привозите зарядку вместе с самокатом?
     * Индекс [6] - Можно ли отменить заказ?
     * Индекс [7] - Я живу за МКАДом, привезёте?
     */
    private By[] getButtonQuestionLocatorsArray() {
        By[] buttonQuestionLocatorsArray = new By[MAX_INDEX];
        for (int i = 0; i < MAX_INDEX; i++) {
            buttonQuestionLocatorsArray[i] = By.id("accordion__heading-" + i);
        }
        return buttonQuestionLocatorsArray;
    }

    private final By[] textResponseLocatorsArray = getTextResponseLocatorsArray();

    /**
     * Фактический текст ответов на вопросы, отображающихся при открытии вопросов блока "Вопросы о важном":
     * Индекс [0] - ответ на вопрос Сколько это стоит? И как оплатить?
     * Индекс [1] - ответ на вопрос Хочу сразу несколько самокатов! Так можно?
     * Индекс [2] - ответ на вопрос Как рассчитывается время аренды?
     * Индекс [3] - ответ на вопрос Можно ли заказать самокат прямо на сегодня?
     * Индекс [4] - ответ на вопрос Можно ли продлить заказ или вернуть самокат раньше?
     * Индекс [5] - ответ на вопрос Вы привозите зарядку вместе с самокатом?
     * Индекс [6] - ответ на вопрос Можно ли отменить заказ?
     * Индекс [7] - ответ на вопрос Я живу за МКАДом, привезёте?
     */
    private By[] getTextResponseLocatorsArray() {
        By[] textResponseLocatorsArray = new By[MAX_INDEX];
        for (int i = 0; i < MAX_INDEX; i++) {
            textResponseLocatorsArray[i] = By.xpath(".//div[@id='accordion__panel-" + i + "']/p");
        }
        return textResponseLocatorsArray;
    }

    /**
     * Массив ожидаемого контента
     */
    private final String[] expectedTextResponseArray = {
            "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    };

    public QuestionsPage(WebDriver driver) {
        this.driver = driver;
    }

    //Открыть ответ на вопрос
    public void clickButtonQuestion(int buttonIndex) {
        By locator = buttonQuestionLocatorsArray[buttonIndex];

        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

        driver.findElement(locator).click();
    }

    //Получить фактический текст ответов
    public String getContentText(int buttonIndex) {
        By locator = textResponseLocatorsArray[buttonIndex];
        return driver.findElement(locator).getText();
    }

    //Проверить содержимое ответов
    public boolean contentIsDisplayed(int buttonIndex) {
        By locator = textResponseLocatorsArray[buttonIndex];
        String expectedContentText = expectedTextResponseArray[buttonIndex];
        return driver.findElement(locator).isDisplayed() && getContentText(buttonIndex).equals(expectedContentText);
    }
}

