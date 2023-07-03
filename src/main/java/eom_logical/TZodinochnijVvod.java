package eom_logical;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class TZodinochnijVvod extends TaskConstructorPage{
    private SelenideElement elOdinochnijVvodBtn = $x("//*[contains(text(),'Одиночный ввод')]");
    private SelenideElement elAnswerField = $x("//input[@placeholder='Введите правильный ответ...']");
    private SelenideElement elRegistrToggle = $x("//*[contains(text(),'Учитывать регистр')]");

    public TZodinochnijVvod clickNaOdinochnijVvod() { // метод возвращает значение с типом TZodinochnijVvod
        elOdinochnijVvodBtn.click();
        return this;
    }

    public TZodinochnijVvod writeAnswerInFieldAnswer(String answer) {
        elAnswerField.sendKeys(answer);
        return this;
    }

    public TZodinochnijVvod clickUchitivatRegistrToggle() {
        elRegistrToggle.click();
        return this;
    }
}
