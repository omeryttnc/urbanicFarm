package utilities;


import enums.USER;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.asynchttpclient.request.body.multipart.StringPart;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiUtilities {
    public static Response response;
    public static String token;
    public static RequestSpecification specification;

    public static Map<String, Object> payload = new HashMap<>();

    public static RequestSpecification requestSpecification(String token) {
        return specification = new RequestSpecBuilder()
                .addHeader("Authorization", "Bearer " + token)
                .setBaseUri("https://test.urbanicfarm.com/api")
                .setRelaxedHTTPSValidation()
                .build();
    }

    public static RequestSpecification requestSpecification(USER user) {
        return specification = new RequestSpecBuilder()
                .addHeader("Authorization", "Bearer " + user.getToken())
                .setBaseUri("https://test.urbanicfarm.com/api")
                .setRelaxedHTTPSValidation()
                .build();
    }

    public static String loginWithAPI(String email, String password) {
        payload.put("email", email);
        payload.put("password", password);
        response = given()
                .formParams(payload)
                .baseUri("https://test.urbanicfarm.com/api")
                .post("/public/login");
        response.prettyPrint();
        token = response.jsonPath().getString("token");
        return token;
    }

    public static class Address {


        public static List<Integer> getAddress(USER user) {
            response = given().spec(requestSpecification(user)).post("/account/address/getAddress");

            response.prettyPrint();


            return response.jsonPath().getList("addresses.id");


        }

        public static int addAddress(String address, String city, boolean isDefault, boolean isSellerAddress, String postal, String state, String title, boolean emptyBasket, USER user) {
            payload.put("address", address);
            payload.put("city", city);
            payload.put("isDefault", isDefault);
            payload.put("isSellerAddress", isSellerAddress);
            payload.put("postal", postal);
            payload.put("state", state);
            payload.put("title", title);
            payload.put("emptyBasket?", emptyBasket);

            response = given().
                    body(payload).
                    spec(requestSpecification(user)).post("/account/address/addAddress");

            response.prettyPrint();

            return response.jsonPath().getInt("address.id");


        }

        public static int addAddress(String address, String city, boolean isDefault, boolean isSellerAddress, String postal, String state, String title, boolean emptyBasket, String token) {
            payload.put("address", address);
            payload.put("city", city);
            payload.put("isDefault", isDefault);
            payload.put("isSellerAddress", isSellerAddress);
            payload.put("postal", postal);
            payload.put("state", state);
            payload.put("title", title);
            payload.put("emptyBasket?", emptyBasket);

            response = given().
                    contentType(ContentType.JSON).
                    spec(requestSpecification(token)).
                    body(payload).
                    post("/account/address/addAddress");

            response.prettyPrint();

            return response.jsonPath().getInt("address.id");


        }

        public static void updateAddress(int addressId, String address, String city, boolean isDefault, boolean isSellerAddress, String postal, String state, String title, boolean emptyBasket, String token) {
            payload.put("addressId", addressId);
            payload.put("address", address);
            payload.put("city", city);
            payload.put("isDefault", isDefault);
            payload.put("isSellerAddress", isSellerAddress);
            payload.put("postal", postal);
            payload.put("state", state);
            payload.put("title", title);
            payload.put("emptyBasket?", emptyBasket);

            response = given().
                    contentType(ContentType.JSON).
                    spec(requestSpecification(token)).
                    body(payload).
                    post("/account/address/update");

            response.prettyPrint();

//        return response.jsonPath().getInt("address.id");


        }

        public static void updateAddress(int addressId, String address, String city, boolean isDefault, boolean isSellerAddress, String postal, String state, String title, boolean emptyBasket, USER user) {
            payload.put("addressId", addressId);
            payload.put("address", address);
            payload.put("city", city);
            payload.put("isDefault", isDefault);
            payload.put("isSellerAddress", isSellerAddress);
            payload.put("postal", postal);
            payload.put("state", state);
            payload.put("title", title);
            payload.put("emptyBasket?", emptyBasket);

            response = given().
                    contentType(ContentType.JSON).
                    body(payload).
                    spec(requestSpecification(user)).post("/account/address/update");

            response.prettyPrint();

//        return response.jsonPath().getInt("address.id");


        }

        public static void deleteAddress(int addressId, USER user) {
            payload.put("addressId", addressId);

            response = given().
                    contentType(ContentType.JSON).
                    body(payload).
                    spec(requestSpecification(user)).post("/account/address/delete");

            response.prettyPrint();

//        return response.jsonPath().getInt("address.id");


        }

        public static void deleteAddress(Integer addressId, String token) {
//        payload.put("addressId", addressId);

            response = given().
                    contentType(ContentType.JSON).
                    body("addressId=" + addressId).
                    spec(requestSpecification(token)).post("/account/address/delete");

            response.prettyPrint();


        }

        @Test
        public  void deleteAddress() {
            int silmedenOncekiListeSize = getAdressisDefault().size();


        payload.put("addressId", getAdressisDefault().get(getAdressisDefault().size()-1));

            response = given().
                    contentType(ContentType.JSON).
                    body(payload)
//                    spec(requestSpecification(USER.EZRA))
                    .auth().oauth2(USER.EZRA.getToken())
                    .post("https://test.urbanicfarm.com/api/account/address/delete");

            response.prettyPrint();
            int silmedenSonrakiListeSize = getAdressisDefault().size();

            System.out.println("silmedenOncekiListeSize = " + silmedenOncekiListeSize);
            System.out.println("silmedenSonrakiListeSize = " + silmedenSonrakiListeSize);
            Assert.assertNotEquals(silmedenSonrakiListeSize,silmedenOncekiListeSize);


        }

//        @Test
        public static List<Integer> getAdressisDefault() {

            List<Integer> list = new ArrayList<>();
            response = given().
                    contentType(ContentType.JSON)
                    .auth().oauth2(USER.EZRA.getToken())
                    .post("https://" + (USER.EZRA.isTest() ? "test." : "") + "urbanicfarm.com/api/account/address/getAddress");
            Assert.assertTrue(response.jsonPath().getBoolean("success"));
            Assert.assertEquals(200, response.statusCode());

            List<Integer> listId = response.jsonPath().getList("addresses.id");
            List<Boolean> isDefault = response.jsonPath().getList("addresses.isDefault");

            for (int i = 0; i < listId.size(); i++) {
                if (!isDefault.get(i)) {
                    list.add(listId.get(i));
                }
            }

            return list;

        }
    }
}

