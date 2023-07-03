package eom_logical;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.proxy.ResponseSizeWatchdog;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.asynchttpclient.RequestBuilder;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import java.util.regex.Matcher;

public class TestTaskApi {
    String baseUrl = "https://uchebnik-test.mos.ru";
    String basePath = "/cms/api/atomic_objects/";

    public void deleteTestTask(int idTZ) {
        RestAssured
                .given()
                .spec(getRequestSpecification(idTZ))
                .header("accept", "application/vnd.cms-v4+json")
                .cookies(Cookies.basicTeacherCookies(getCookie()))
                .log().all()
                .delete()
                .then()
                .log().all()
                .spec(getResponseSpecification());
    }

    public RequestSpecification getRequestSpecification(int idTZ) {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(baseUrl)
                .setBasePath(basePath + idTZ)
                .build();
    }
    public ResponseSpecification getResponseSpecification() {
        return new ResponseSpecBuilder()
                .expectStatusCode(Matchers.oneOf(200, 201, 204))
                .build();
    }

    public String getCookie(){
        return WebDriverRunner.getWebDriver().manage().getCookieNamed("auth_token").getValue();
    }
}
