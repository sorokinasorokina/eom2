package eom_logical;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class TZmnozhestvennijVibor extends TaskConstructorPage{
    private SelenideElement elMnozhestvennijOtvetBtn = $x("//*[contains(text(),'Множественный выбор')]");
    private SelenideElement elFirstAnswerPole = $x("//*[contains(text(),'Укажите содержимое ответа')]/../..//span/..");
    private SelenideElement elAddVariantOtvetaPole = $x("//p[contains(text(),'Добавить вариант ответа...')]");
    private SelenideElement elThirdAnswerCheckBoxBtn = $x("//*[contains(text(),'third answer')]/../../../../../../../../../../..//input[@type='checkbox']");

    public TZmnozhestvennijVibor clickNaMnozhestvennijVibor() { // метод возвращает значение с типом TZopenAnswer
        elMnozhestvennijOtvetBtn.click();
        return this;
    }

    public TZmnozhestvennijVibor writeAnswerInFieldAnswerTZ(String answer){
        elFirstAnswerPole.sendKeys(answer);
        return this;
    }

    public TZmnozhestvennijVibor addVariantOtveta(){
        elAddVariantOtvetaPole.click();
        return this;
    }

    public TZmnozhestvennijVibor thirdAnswerCheckBoxBtn(){
        elThirdAnswerCheckBoxBtn.click();
        return this;
    }
}
