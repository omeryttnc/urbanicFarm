package stepDefinitions.backendStepDef;

import enums.USER;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import pojos.DeliverySettings.FlexibleDeliveryOption;
import pojos.DeliverySettings.PDeliveryOptions;

import java.util.*;

import static io.restassured.RestAssured.given;

public class DeliverySettings {

    enum DELIVERYTYPES {
        SELLER_FLEXIBLE,
        BUYER_PICKUP_FROM_BRANCH,
        BUYER_PICKUP,
        SELLER_DELIVERY
    }

    Response response;
    String endpoint = "https://test.urbanicfarm.com/api/account/change/delivery";
    String time = "09:00-12:00";


    @Test
    public void stringBody() {
        String body = "{\n" +
                "    \"availability\": \"" + time + "\",\n" +
                "    \"availabilityBranch\": \"08:00-17:00\",\n" +
                "    \"deliveryType\": [\n" +
                "        \"SELLER_FLEXIBLE\",\n" +
                "        \"BUYER_PICKUP_FROM_BRANCH\",\n" +
                "        \"BUYER_PICKUP\",\n" +
                "        \"SELLER_DELIVERY\"\n" +
                "    ],\n" +
                "    \"estimatedDeliveryTime\": [\n" +
                "        \"60_0.06\"\n" +
                "    ],\n" +
                "    \"flexibleDeliveryOptions\": [\n" +
                "        {\n" +
                "            \"deliveryBy\": 8973,\n" +
                "            \"orderBegin\": 2652,\n" +
                "            \"orderEnd\": 4040\n" +
                "        }\n" +
                "    ],\n" +
                "    \"freeDeliveryRange\": 1,\n" +
                "    \"maxDeliveryRange\": 30,\n" +
                "    \"minFreeDeliveryOrder\": 13,\n" +
                "    \"perMileCost\": 2\n" +
                "}";


        response = given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(USER.BUYER.getToken())
                .body(body)
                .post(endpoint);

        response.prettyPrint();


    }


    @Test
    public void mapBody() {
        Map<String, Object> body = new HashMap();

        List<String> deliveryTypeList = new ArrayList<>();
        deliveryTypeList.add(DELIVERYTYPES.SELLER_FLEXIBLE.name());

        body.put("freeDeliveryRange", 10);
        body.put("maxDeliveryRange", 30);
        body.put("minFreeDeliveryOrder", 5);
        body.put("perMileCost", 1);


        body.put("deliveryType", deliveryTypeList);


        Map<String, Integer> innerMap = new HashMap<>();
        innerMap.put("deliveryBy", 8973);
        innerMap.put("orderBegin", 4040);
        innerMap.put("orderEnd", 3000);

        List<Map<String, Integer>> mapFlexiableOptions = new ArrayList<>();

        mapFlexiableOptions.add(innerMap);

        body.put("flexibleDeliveryOptions", mapFlexiableOptions);


        response = given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(USER.BUYER.getToken())
                .body(body)
                .post(endpoint);

        response.prettyPrint();


    }


    @Test
    public void pojoBody_1() {

        PDeliveryOptions body = new PDeliveryOptions();

        body.setAvailabilityBranch("08:00-12:00");

        //way 1
//        List<String> deliveryOptions = new ArrayList<>();
//        deliveryOptions.add("BUYER_PICKUP_FROM_BRANCH");
//        body.setDeliveryType(deliveryOptions);
//
        //way 2
        body.setDeliveryType(Arrays.asList(DELIVERYTYPES.BUYER_PICKUP_FROM_BRANCH.name()));


        given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(USER.BUYER.getToken())
                .body(body)
                .post(endpoint)
                .then()
                .assertThat()
                .statusCode(200)
                .body("success", Matchers.equalTo(true))
                .log()
                .headers();



    }


    @Test
    public void pojoBody_2() {

        PDeliveryOptions body = new PDeliveryOptions();

        body.setDeliveryType(List.of(DELIVERYTYPES.SELLER_FLEXIBLE.name()));

        body.setFreeDeliveryRange(2);
        body.setMaxDeliveryRange(30);
        body.setMinFreeDeliveryOrder(20);
        body.setPerMileCost(1);

        FlexibleDeliveryOption deliveryOption = new FlexibleDeliveryOption();

        /**
         *
         *             "deliveryBy": 8973,
         *             "orderBegin": 4652,
         *             "orderEnd": 2040
         *
         */
        deliveryOption.setDeliveryBy(7000);
        deliveryOption.setOrderBegin(3000);
        deliveryOption.setOrderEnd(5000);

        body.setFlexibleDeliveryOptions(List.of(deliveryOption));
//        body.setFlexibleDeliveryOptions(Arrays.asList(deliveryOption));

        /**
         *  "freeDeliveryRange": 1,
         *     "maxDeliveryRange": 60,
         *     "minFreeDeliveryOrder": 13,
         *     "perMileCost": 2
         */

        given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(USER.BUYER.getToken())
                .body(body)
                .post(endpoint)
                .then()
                .assertThat()
                .statusCode(200)
                .body("success", Matchers.equalTo(true))
        ;


    }


}
