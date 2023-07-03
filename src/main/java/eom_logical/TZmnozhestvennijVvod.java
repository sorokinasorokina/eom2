package eom_logical;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class TZmnozhestvennijVvod extends TaskConstructorPage{
    private SelenideElement elMnozhestvennijVvodBtn = $x("//*[contains(text(),'Множественный ввод')]");
    private SelenideElement elAnswerField = $x("//input[@placeholder='Введите правильный ответ...']");
    private SelenideElement elAddVariantOtvetaPole = $x("//p[contains(text(),'Добавить вариант ответа...')]");
//    private SelenideElement elRegistrToggle = $x("//*[contains(text(),'Учитывать регистр')]");

    public TZmnozhestvennijVvod clickNaMnozhestvennijVvod() { // метод возвращает значение с типом TZmnozhestvennijVvod
        elMnozhestvennijVvodBtn.click();
        return this;
    }

    public TZmnozhestvennijVvod writeAnswerInFieldAnswer(String answer) {
        elAnswerField.sendKeys(answer);
        return this;
    }

    public TZmnozhestvennijVvod addVariantOtveta(){
        elAddVariantOtvetaPole.click();
        return this;
    }
}
