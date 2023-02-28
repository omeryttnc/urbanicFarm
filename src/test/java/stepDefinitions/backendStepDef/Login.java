package stepDefinitions.backendStepDef;

import enums.USER;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Login {
    String endPoint = "https://test.urbanicfarm.com/api/public/login";
    Map<String, String> map = new HashMap<>();

    Response response;
    JsonPath jsonPath;

    @Test
    public void name() {

        map.put("email", USER.BUYER.getEmail());
        map.put("password", USER.BUYER.getPassword());


        response = given()
                .contentType(ContentType.JSON)
                .body(map)
                .post(endPoint);

        response.prettyPrint();

        jsonPath = response.jsonPath();

        System.out.println(jsonPath.getBoolean("success"));
        System.out.println(jsonPath.getString("email"));
        String actualEmail = jsonPath.getString("email");

        Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals(USER.BUYER.getEmail(), actualEmail);
        Assert.assertEquals(USER.BUYER.getFirstName(), jsonPath.getString("first_name"));
        Assert.assertEquals(USER.BUYER.getMiddleName(), jsonPath.getString("first_middle"));
        Assert.assertEquals(USER.BUYER.getLastName(), jsonPath.getString("first_lastname"));



    }
}
