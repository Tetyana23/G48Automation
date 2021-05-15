package tests.api;

import io.qameta.allure.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasSize;


@Feature("Getting currencies using API tests")
@Owner("Tetyana23")
@Severity(SeverityLevel.CRITICAL)
@RunWith(Parameterized.class)
public class PrivatGetCurrencyTest extends BaseApiTest {

    private final int courseId;

    public PrivatGetCurrencyTest(int courseId) {
        this.courseId = courseId;
    }

    @Parameterized.Parameters
    public static List<Integer> data() {
        return new ArrayList<Integer>() {{
            add(5);
            add(11);
        }};

    }

    @Description("Тест нужен, чтобы проверить валюту в банке с помощью API тестов")
    @Test
    public void checkCurrencyInPB() {
        given().spec(rspec)
                .baseUri("https://api.privatbank.ua/p24api")
                .queryParam("json")
                .queryParam("exchange")
                .queryParam("coursid", this.courseId)
                .relaxedHTTPSValidation()
                .when()
                .log()
                .everything()
                .get("/pubinfo")
                .then()
                .log()
                .everything()
                .spec(respSpec)
                .assertThat()
                .body("ccy", hasItems("USD", "EUR", "BTC", "RUR"))
                .body("ccy", hasSize(4))
                .body("base_ccy", hasItem(equalTo("UAH")));
    }

}
