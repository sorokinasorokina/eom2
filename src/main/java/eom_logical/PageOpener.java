package eom_logical;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class PageOpener {
    static String urlSchoolTestMosRu = "http://school-test.mos.ru";
    static String urlUchebnikTestMosRuMain = "https://uchebnik-test.mos.ru/main"; // куки загружаются тут
    static String urlPageNewTask = "https://uchebnik-test.mos.ru/exam/constructor/task/new";


    public static void openSchoolTestMosRu(){
        open(urlSchoolTestMosRu);
    }

    public static void openUchebnikTestMosRuMain(){
        open(urlUchebnikTestMosRuMain);
        sleep(3000);
    }

    public static void openPageNewTask() {
        open(urlPageNewTask);
    }

}
