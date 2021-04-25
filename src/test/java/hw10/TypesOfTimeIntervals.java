package hw10;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import io.restassured.http.ContentType;
import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.internal.matcher.xml.XmlXsdMatcher.matchesXsd;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static java.lang.System.getProperty;

@RunWith(Parameterized.class)
public class TypesOfTimeIntervals extends BaseApiTest {

    ContentType contentType;
    Object body;
    String pathParameter;
    Matcher<?> bodyValidator;

    public TypesOfTimeIntervals(ContentType contentType, Object body, String pathParameter, Matcher<?> bodyValidator) {
        this.contentType = contentType;
        this.body = body;
        this.pathParameter = pathParameter;
        this.bodyValidator = bodyValidator;
    }

    @Parameterized.Parameters
    public static List<Object[]> data() throws JsonProcessingException {
        List<Object[]> result = new ArrayList<>();
        result.add(new Object[]{ContentType.JSON, createBodyForJson(), "/json", matchesJsonSchema(
                new File(getProperty("user.dir")
                        + "/src/test/resources/jsonSchema/schemeHW10.json"))});
        result.add(new Object[]{ContentType.XML, createBodyForXML(), "/xml", matchesXsd(
                new File(getProperty("user.dir")
                        + "/src/test/resources/xmlSchema/schemeXMLhw10.xsd"))});
        return result;
    }

    /**
     * метод который создает тело запроса для случая с использованием json
     * @return тело запроса
     */
    public static Object createBodyForJson() {
        Map<String, Object> body = new HashMap<>();
        Map<String, Object> methodProperties = new HashMap<>();
        methodProperties.put("RecipientCityRef", "8d5a980d-391c-11dd-90d9-001a92567626");
        methodProperties.put("DateTime", "18.09.2021");
        body.put("apiKey", "");
        body.put("modelName", "Common");
        body.put("calledMethod", "getTimeIntervals");
        body.put("methodProperties", methodProperties);
        return body;
    }

    /**
     * метод который создает тело запроса для случая с использованием xml
     * @return тело запроса
     */
    public static Object createBodyForXML() throws JsonProcessingException {
        Map<String, Object> body = new HashMap<>();
        Map<String, Object> methodProperties = new HashMap<>();
        methodProperties.put("RecipientCityRef", "8d5a980d-391c-11dd-90d9-001a92567626");
        methodProperties.put("DateTime", "18.09.2021");
        body.put("apiKey", "");
        body.put("modelName", "Common");
        body.put("calledMethod", "getTimeIntervals");
        body.put("methodProperties", methodProperties);
        return new XmlMapper().writeValueAsString(body);
    }

    @Test
    public void checkTypesOfTimesIntervals() {
        given().spec(this.rspec)
                .baseUri("https://api.novaposhta.ua/v2.0")
                .contentType(contentType)
                .body(body)
                .when()
                .log().all()
                .post(pathParameter + "/common/getTimeIntervals/")
                .then()
                .log().all()
                .spec(respSpec)
                .assertThat()
                .statusCode(200)
                .body(bodyValidator);

    }


}
