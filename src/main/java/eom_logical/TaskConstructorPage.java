package eom_logical;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.*;

public class TaskConstructorPage {
    String task = "task text";
    private SelenideElement elOdinochnijViborBtn = $x("//*[contains(text(),'Одиночный выбор')]");
    private SelenideElement elTekstZadaniyapolevv = $x("//*[contains(text(),'Текст задания')]//..//..//*[@role='textbox']");
    private SelenideElement elSettingBtn = $x("//button[@data-testid='metaButton']");
    private SelenideElement elNamePole = $x("//input[@placeholder='Введите название задания...']");
    private SelenideElement elDescriptionPole = $x("//textarea[@placeholder='Введите описание задания...']");
    private SelenideElement elSecondTub = $x("//*[contains(text(),'Параллели и предметы')]");
    private SelenideElement elParallelBtn = $x("//*[@placeholder='Начните вводить название или выберите из списка']");
    private SelenideElement elTemi = $x("//*[contains(text(),'Темы и ДЕ')]");
    private SelenideElement elViborTemi = $x("//*[contains(text(),'Выбрать тему')]");
    private SelenideElement elSave = $x("//*[contains(@class,'AddTheme')]//button[contains(text(),'Сохранить')]");
    private ElementsCollection elsParallel = $$x("//*[contains(text(),'Параллель')]/..//button[text()]");
    private ElementsCollection elsP1 = $$x("//*[@role='presentation']//button//p[1]");
    private SelenideElement elMirVokrugMenya = $x("//*[contains(text(),'".concat("Мир вокруг меня").concat("')]/..//*[@type='checkbox']"));
    private SelenideElement elSaveVMoiMateriali = $x("//*[contains(text(),'Сохранить в мои материалы')]");
    private SelenideElement elKrestikZakritiyaModalView = $x("/html/body/div[4]/div[3]/div/div/div/div/button[2]");
    private SelenideElement elContinueBtnOnModalView = $x("//button[contains(text(),'Продолжить')]");
    // для проверки url
    private SelenideElement elSpravka = $x("//*[contains(text(),'Справка')]");
    private SelenideElement elButton = $x("//button");
    private SelenideElement elDlyaRabotiBibl = $x("//*[contains(text(),'Для работы в Библиотеке')]");
    private SelenideElement elViewMaterialBtn = $x("//*[contains(text(),'Посмотреть')]");

    public TaskConstructorPage obrabotkaOknaNachatogoTZ() {
        sleep(5000); //!!!!!!! заменить
        if (elContinueBtnOnModalView.exists()) {
            elKrestikZakritiyaModalView.click();
        }
        return this; // возвращение экземпляра класса TaskConstructorPage
    }

    public TaskConstructorPage writeTaskFieldTZ() { // метод возвращает значение с типом TZopenAnswer
//        Date сalendar = new Date();
//        Long time = сalendar.getTime();
        elTekstZadaniyapolevv.sendKeys(task.concat(" - "));
        return this;
    }

    public TaskConstructorPage openSpisokTypeTZ() { // метод возвращает значение с типом TZopenAnswer
        elOdinochnijViborBtn.click();
        return this;   // возвращает текущий экземпляр этого класса
    }

    public TaskConstructorPage fillSettingFieldsTZ(){
        elSettingBtn.click(); //клик по шестеренке
        //первая вкладка
        elNamePole.sendKeys(task);
        elDescriptionPole.sendKeys(task);
        elSecondTub.click(); //клик по второй вкладке настроек
        //вторая вкладка
        elsParallel.get(1).click();
        elParallelBtn.click();
        elsP1.get(1).click();
        //третья вкладка
        elTemi.click();
        elViborTemi.click();
        elMirVokrugMenya.click();
        elSave.click();
        return this;
    }

    public TaskConstructorPage saveTZ(){
        elSaveVMoiMateriali.click();
        return this;
    }

    public int getValueOfTaskIdSubstring() {
        String actualBaseUrl = "https://uchebnik-test.mos.ru";
        if (actualBaseUrl.equals("https://uchebnik-dev.mos.ru")) { return 57; }
        else if (actualBaseUrl.equals("https://uchebnik-test.mos.ru")) { return 58; }
        else if (actualBaseUrl.equals("https://uchebnik.mos.ru")) { return 53; }
        throw new RuntimeException("URL ".concat(actualBaseUrl).concat(" is incorrect."));
    }

    public TaskConstructorPage checkUrlAfterSaveTZ(){
        elSpravka.shouldNotBe(Condition.visible);   //проверка урла...
        elButton.shouldBe(Condition.visible);
        if (elDlyaRabotiBibl.exists()) {
            back();
        }
        elViewMaterialBtn.shouldBe(Condition.visible);
        String materialId = WebDriverRunner.getWebDriver().getCurrentUrl().substring(getValueOfTaskIdSubstring());
        if (!materialId.matches("^\\d+$")) {
            throw new RuntimeException("=======FAIL======== URL".concat(materialId).concat(" is incorrect."));
        }
        return this; // this потому что возвращается что-то с типом TaskConstructorPage
    }

    public int getIdTz() {
        String materialId = WebDriverRunner.getWebDriver().getCurrentUrl().substring(getValueOfTaskIdSubstring());
        if (!materialId.matches("^\\d+$")) {
            throw new RuntimeException("=======FAIL======== URL".concat(materialId).concat(" is incorrect."));
        }
        int materialIdInt = Integer.parseInt(materialId);
        return materialIdInt;
    }


//elOdinochnijViborBtn.shouldBe(Condition.visible); - ожидание !!!!!!!!!!!!!!!!!!

//      public static void main(String[] args) {
//      System.out.println("ss");
//      String ss = "Коллекции и работа с ними";
//      int a = 999999999;
//      long c = 999999999999999999L;
//      char b = 'b';
//      double v = 4.6;
//      float s = 1.3F;
//*[contains(text(),'Варианты ответов')]/../../..//*[@role='textbox']
//*[@class='SelectAnswerType-menu']//*[@class='SelectMenuItem-itemName']
//*[contains(@class,'SelectAnswerType-menu')]//*[contains(@class,'SelectMenuItem-itemName')]
//*[contains(@*,'SelectAnswerType-menu')]//*[contains(@*,'SelectMenuItem-itemName')]
//*[contains(text(),'Правильный')]/../button
//      }
}