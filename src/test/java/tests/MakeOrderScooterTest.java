package tests;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import page.*;

import static org.hamcrest.CoreMatchers.containsString;

@RunWith(Parameterized.class)
public class MakeOrderScooterTest extends BaseTest {
    private final String buttonLocation;
    private final String newName;
    private final String newSurname;
    private final String newAddress;
    private final String newMetro;
    private final String newPhoneNumber;
    private final String newDate;
    private final int dayCount;
    private final String newColor;
    private final String newComment;

    private static final Object[] DATA_FOR_FIRST_ORDER = new Object[]{
            "lower", "Игнат", "Федоров", "Москва", "Сокольники",
            "+77882587883", "31.12.2022", 7, "grey", "Не потеряйся в пути"
    };

    private static final Object[] DATA_FOR_SECOND_ORDER = new Object[]{
            "upper", "Евгений", "Плюхин", "Щербинка", "Бульвар Дмитрия Донского",
            "+79881459611", "04.01.2023", 4, "black", "Нет комментариев"
    };

    public MakeOrderScooterTest(String buttonLocation, String newName, String newSurname, String newAddress,
                                String newMetro, String newPhoneNumber, String newDate, int dayCount,
                                String newColor, String newComment) {
        this.buttonLocation = buttonLocation;
        this.newName = newName;
        this.newSurname = newSurname;
        this.newAddress = newAddress;
        this.newMetro = newMetro;
        this.newPhoneNumber = newPhoneNumber;
        this.newDate = newDate;
        this.dayCount = dayCount;
        this.newColor = newColor;
        this.newComment = newComment;
    }

    @Parameterized.Parameters
    public static Object[] newOrderData() {
        return new Object[]{
                DATA_FOR_FIRST_ORDER, DATA_FOR_SECOND_ORDER
        };
    }

    @Test
    public void checkOrderTest() {
        HomePage homePage = new HomePage(driver);
        //Согласиться с cookie
        homePage.cookieButtonClick();

        //Нажать кнопку Заказа внизу или вверху
        homePage.chooseOrderButtonAndClick(buttonLocation);

        //Заполнить 1-ую страницу заказа
        OrderPagePersonData orderPagePersonData = new OrderPagePersonData(driver);
        orderPagePersonData.fill(newName, newSurname, newAddress, newMetro, newPhoneNumber);

        //Заполнить 2-ую страницу заказа
        OrderPageRentalCondition orderPageRentalCondition = new OrderPageRentalCondition(driver);
        orderPageRentalCondition.fill(newDate, dayCount, newColor, newComment);

        //Нажать кнопку "Заказать"
        OrderPageOrderConfirmation orderPageOrderConfirmation = new OrderPageOrderConfirmation(driver);
        orderPageOrderConfirmation.clickOkButton();

        //Проверить, что появилось сообщение об успешном создании заказа
        ResultPage resultPage = new ResultPage(driver);
        MatcherAssert.assertThat(resultPage.getResultMessage(), containsString("Заказ оформлен"));
    }
}