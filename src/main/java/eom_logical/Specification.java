package eom_logical;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;

public class Specification {
    String baseUrl = "https://uchebnik-test.mos.ru";
//    String basePath = "/cms/api/atomic_objects/";
    String baseUserSessions = "/api/sessions";
    public RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(baseUrl)
                .setBasePath(baseUserSessions)
                .build();
    }
    public ResponseSpecification getResponseSpecification() {
        return new ResponseSpecBuilder()
                .expectStatusCode(Matchers.oneOf(200, 201, 204))
                .build();
    }
}
