package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import page.QuestionsPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class CheckQuestionAboutImportantTest extends BaseTest {
    private final int buttonIndex;
    private static final Object[] PAGE_INDEXES = new Object[]{
            0, 1, 2, 3, 4, 5, 6, 7
    };

    public CheckQuestionAboutImportantTest(int buttonIndex) {
        this.buttonIndex = buttonIndex;
    }

    @Parameterized.Parameters
    public static Object[] getTestData() {
        return PAGE_INDEXES;
    }

    @Test
    public void checkTextAnswer() {
        QuestionsPage questionsPage = new QuestionsPage(driver);
        //Развернуть выпадающий список одного из вопросов
        questionsPage.clickButtonQuestion(buttonIndex);
        //Сравнить ожидаемый и фактический текст ответа
        assertTrue(questionsPage.contentIsDisplayed(buttonIndex));
    }
}
