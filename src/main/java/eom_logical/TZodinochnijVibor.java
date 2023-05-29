package eom_logical;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class TZodinochnijVibor extends TaskConstructorPage {
    private SelenideElement elOdinochnijOtvetBtn = $x("//*[contains(text(),'Одиночный выбор')]");
    private SelenideElement elFirstAnswerPole = $x("//*[contains(text(),'Укажите содержимое ответа')]/../..//span/..");
    private SelenideElement elAddVariantOtvetaPole = $x("//p[contains(text(),'Добавить вариант ответа...')]");

    public TZodinochnijVibor clickNaOdinochnijVibor() { // метод возвращает значение с типом TZopenAnswer
        elOdinochnijOtvetBtn.click();
        return this;
    }

    public TZodinochnijVibor writeAnswerInFieldAnswerTZ(String answer){
        elFirstAnswerPole.sendKeys(answer);
        return this;
    }

    public TZodinochnijVibor addVariantOtveta(){
        elAddVariantOtvetaPole.click();
        return this;
    }
}