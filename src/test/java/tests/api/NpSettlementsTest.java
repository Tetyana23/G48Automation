package tests.api;

import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static java.lang.System.getProperty;

@Ignore
public class NpSettlementsTest extends BaseApiTest {

    private Map<String, Object> body = new HashMap<>();

    @Before
    public void setBodyForTest() {
        Map<String, Object> methodProperties = new HashMap<>();
        methodProperties.put("CityName", "Київ");
        methodProperties.put("Limit", 5);
        body.put("apiKey", "");
        body.put("modelName", "Address");
        body.put("calledMethod", "searchSettlements");
        body.put("methodProperties", methodProperties);
    }

    @Test
    public void checkSettlements() {
        given().spec(this.rspec)
                .baseUri("https://api.novaposhta.ua/v2.0")
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .log()
                .all()
                .put("/json/Address/searchSettlements/")
                .then()
                .log()
                .all()
                .spec(respSpec)
        .assertThat()
                .body(
                        matchesJsonSchema(
                                new File(getProperty("user.dir")
                                        +"src/test/resources/jsonSchema/settlements.json")));



    }


}
