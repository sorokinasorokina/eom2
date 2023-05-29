package eom_tests;
import com.codeborne.selenide.*;
import eom_logical.*;
import org.testng.annotations.Test;
import static eom_logical.PageOpener.*;


public class TestDifferentTZ {
    String firstAnswer = "first answer";
    String secondAnswer = "second answer";
    String thirdAnswer = "third answer";

    @Test
    void myOpenAnswerTest(){
        Configuration.timeout=100000;
        Autorization autorization= new Autorization("15145652956", "pR6vs9eG"); // экземпляр класса (инстанс, объект) авторизации
        TZopenAnswer tzopen = new TZopenAnswer();  // создание экземпляра класса
        TestTaskApi testTaskApi = new TestTaskApi();

        PageOpener.openSchoolTestMosRu();
        autorization.autorizationUserWithRoleTeacher();
        openUchebnikTestMosRuMain();
        autorization.selectRoleTeacher();
        openPageNewTask();
        tzopen                                      //вызов экземпляра класса
                .obrabotkaOknaNachatogoTZ()
                .writeTaskFieldTZ()
                .openSpisokTypeTZ();
        tzopen
                .clickNaOtkritijOtvet()
                .fillSettingFieldsTZ()
                .saveTZ()
                .checkUrlAfterSaveTZ();
        int idTZ = tzopen.getIdTz();
        testTaskApi.deleteTestTask(idTZ);
    }

    @Test
    void myOdinochnijViborTest(){
        Configuration.timeout=100000;
        Autorization autorization= new Autorization("15145652956", "pR6vs9eG"); // экземпляр класса (инстанс, объект) авторизации
        TZodinochnijVibor tzodinochnijVibor = new TZodinochnijVibor();
        TestTaskApi testTaskApi = new TestTaskApi();

        PageOpener.openSchoolTestMosRu();
        autorization.autorizationUserWithRoleTeacher();
        PageOpener.openUchebnikTestMosRuMain();
        autorization.selectRoleTeacher();
        PageOpener.openPageNewTask();
        tzodinochnijVibor
                .obrabotkaOknaNachatogoTZ()
                .writeTaskFieldTZ()
                .openSpisokTypeTZ();
        tzodinochnijVibor
                .clickNaOdinochnijVibor()
                .writeAnswerInFieldAnswerTZ(firstAnswer)
                .addVariantOtveta()
                .writeAnswerInFieldAnswerTZ(secondAnswer)
                .fillSettingFieldsTZ()
                .saveTZ()
                .checkUrlAfterSaveTZ();
        int idTZ = tzodinochnijVibor.getIdTz();
        testTaskApi.deleteTestTask(idTZ);
    }

    @Test
    void myMnozhestvennijViborTest(){
        Configuration.timeout=100000;
        Autorization autorization= new Autorization("15145652956", "pR6vs9eG"); // экземпляр класса (инстанс, объект) авторизации
        TZmnozhestvennijVibor tzmnozhestvennijVibor = new TZmnozhestvennijVibor();
        TestTaskApi testTaskApi = new TestTaskApi();

//        autorization.getAuthResponse().getAuthentication_token();
//        autorization.getAuthResponse().getProfiles().get(0).getId();
//        autorization.getAuthResponse().getProfiles().get(0).getType();


        PageOpener.openSchoolTestMosRu();                   ///
        autorization.autorizationUserWithRoleTeacher();     /// вынести все это в один метод авторизации учителя!!!!!!!!

        System.out.println("!!!!мой Authentication_token = ");
        System.out.println(autorization.getAuthResponse().getAuthentication_token());

        PageOpener.openUchebnikTestMosRuMain();             ///
        autorization.selectRoleTeacher();                   ///
        PageOpener.openPageNewTask();


        System.out.println(autorization.getAuthResponse().getProfiles().get(0).getId());
        System.out.println(autorization.getAuthResponse().getProfiles().get(0).getType());


        tzmnozhestvennijVibor
                .obrabotkaOknaNachatogoTZ()                 /// перенести в PageOpener !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                .writeTaskFieldTZ()
                .openSpisokTypeTZ();
        tzmnozhestvennijVibor
                .clickNaMnozhestvennijVibor()
                .writeAnswerInFieldAnswerTZ(firstAnswer)
                .addVariantOtveta()
                .writeAnswerInFieldAnswerTZ(secondAnswer)
                .addVariantOtveta()
                .writeAnswerInFieldAnswerTZ(thirdAnswer)
                .thirdAnswerCheckBoxBtn()
                .fillSettingFieldsTZ()
                .saveTZ()
                .checkUrlAfterSaveTZ();
        int idTZ = tzmnozhestvennijVibor.getIdTz();
        testTaskApi.deleteTestTask(idTZ);
    }
}