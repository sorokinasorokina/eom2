package eom_logical;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class TZopenAnswer extends TaskConstructorPage {
    private SelenideElement elOtkritijOtvetBtn = $x("//*[contains(text(),'Открытый ответ')]");

    public TZopenAnswer clickNaOtkritijOtvet() { // метод возвращает значение с типом TZopenAnswer
        elOtkritijOtvetBtn.click();
        return this;
    }
}