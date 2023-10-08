import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C09_Get_BodyTekrarlardanKurtulma {

    @Test
    public void test01(){
        /*
        https://restful-booker.herokuapp.com/booking/10 url’ine
        bir GET request gonderdigimizde
        donen Response’un,
            status code’unun 200,
            ve content type’inin application-json,
            ve response body’sindeki
            "firstname“in, "Susan",
            ve "lastname“in, "Jackson",
            ve "totalprice“in, 612,
            ve "depositpaid“in, false,
            ve "additionalneeds“in, "Breakfast"
            oldugunu test edin
         */

        // 1- End-point ve request body hazırlamak
        String url="https://restful-booker.herokuapp.com/booking/10";

        //2- expected data oluştur

        //3- request gonderip donen response'i kaydet
        Response response=given().when().get(url);
        response.prettyPrint();

        //4- Assertion

        response.then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", Matchers.equalTo("Jim"))
                .body("lastname", Matchers.equalTo("Jones"))
                .body("totalprice", Matchers.lessThan(1000))
                .body("depositpaid",Matchers.equalTo(false));
    }
}
