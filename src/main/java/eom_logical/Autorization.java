package eom_logical;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import javax.swing.text.html.HTMLDocument;

import java.util.HashMap;

import static com.codeborne.selenide.Selenide.*;

public class Autorization { //класс авторизации
    String login = "";
    String password = "";
    String urlSchoolTestMosRu = "http://school-test.mos.ru";
    String urlUchebnikTestMosRuMain = "https://uchebnik-test.mos.ru/main"; // куки загружаются тут
    public SelenideElement elVojtiBtn = $x("//*[contains(text(),'Войти')]");
    public SelenideElement elLoginBtn = $x("//input[@id='login']");
    public SelenideElement elPasswordBtn = $x("//input[@id='password']");
    public SelenideElement elVoitiBtn = $x("//button[contains(text(),'Войти')]");

    public SelenideElement labelModeratorBtn = $x("//*[contains(text(),'Модератор')]");
    public SelenideElement labelTeacherBtn = $x("//*[contains(text(),'Учитель')]");
    public Autorization(String login, String password){ //конструктор класса авторизации
        this.login = login;
        this.password = password;
     }
      private AuthResponse authResponse = new AuthResponse();

    private Specification specification = new Specification();

    private AuthResponse authorizationWithLoginAndPassword(String login, String password) { //метод авторизации пользователя
        elVojtiBtn.click();
        elLoginBtn.sendKeys(login);
        elPasswordBtn.sendKeys(password);
        $x("//button[contains(text(),'Войти')]").click();
        sleep(5000);
        PageOpener.openUchebnikTestMosRuMain();
        authResponse = RestAssured
                .given()
                .spec(specification.getRequestSpecification())
                .header("Accept", "application/json; charset=UTF-8")
                .body(new HashMap(){
                     {
                         put("auth_token", WebDriverRunner.getWebDriver().manage().getCookieNamed("auth_token").getValue());
                    }
                 })
                .post()
                .then()
                .log().all()
                .spec(specification.getResponseSpecification())
                .extract()
                .body()
                .as(AuthResponse.class);

        return authResponse;
    }

    public Autorization selectRoleTeacher() { //метод смены роли на Учителя
        labelModeratorBtn.click();
        labelTeacherBtn.click();
        sleep(3000);
        return this;
    }

    public Autorization autorizationUserWithRoleTeacher() { //метод авторизации пользователя с ролью Учитель
        authorizationWithLoginAndPassword(UserCredentials.TEACHER_MALYUTIN.login, UserCredentials.TEACHER_MALYUTIN.password);
        //selectRoleTeacher();
        return this;
    }

    public AuthResponse getAuthResponse() {
        return authResponse;
    }
}