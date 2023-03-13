package stepDefinitions.backendStepDef.Events;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import enums.USERINFO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import org.hamcrest.Matchers;

import pojos.Events.CreateEvents.PEvents;
import pojos.Events.GetEvents.PEventsGetInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class Event {
    Response response;
    ObjectMapper objectMapper = new ObjectMapper();
    String endpoint_create = "https://test.urbanicfarm.com/api/account/event/create";
    String endpoint_getAddress = "https://test.urbanicfarm.com/api/public/basket/getAddress";
    String endpoint_getMyEvent = "https://test.urbanicfarm.com/api/account/event/getMyEvents";
    String endpoint_update = "https://test.urbanicfarm.com/api/account/event/update";
    String endpoint_cancel = "https://test.urbanicfarm.com/api/account/event/cancel";
    String endpoint_delete = "https://test.urbanicfarm.com/api/account/event/delete";

    int createdEventID;
    EventInfo eventInfoCreated;
    EventInfo eventInfoUpdated;

    @SneakyThrows

    public int create() {
        eventInfoCreated = new EventInfo(2, 3, USERINFO.BUYER);

        response = given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(USERINFO.BUYER.getToken())
                .body(eventInfoCreated)
                .post(endpoint_create);

        //  response.prettyPrint();
        createdEventID = response.jsonPath().getInt("event.id");

        PEvents pEvents;


        pEvents = objectMapper.readValue(response.asString(), PEvents.class);


        System.out.println("pEvents.getEvent().getAddress().getId() = " + pEvents.getEvent().getAddress().getId());
        System.out.println("eventInfo.getAddressId() = " + eventInfoCreated.getAddressId());

        System.out.println("eventInfo.getAttendeeLimit() = " + eventInfoCreated.getAttendeeLimit());
        System.out.println("pEvents.getEvent().getAttendeeLimit() = " + pEvents.getEvent().getAttendeeLimit());
        System.out.println("createdEventID = " + createdEventID);
        return createdEventID;
    }


    @SneakyThrows
    public List<Integer> getAllEvents() {
        response = given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(USERINFO.BUYER.getToken())

                .post(endpoint_getMyEvent);

        PEventsGetInfo pEvents;
        System.out.println("response.jsonPath().getList(\"events.id\") = " + response.jsonPath().getList("events.id"));
        pEvents = objectMapper.readValue(response.asString(), PEventsGetInfo.class);

        return pEvents.getEvents().stream().map(t -> t.getId()).collect(Collectors.toList());

    }


    public void update(int eventId) {
        eventInfoUpdated = new EventInfo(3, 2, USERINFO.BUYER);
        eventInfoUpdated.setEventId(eventId);
        System.out.println(eventInfoUpdated);
        Faker faker = new Faker();
        String newName = faker.name().name();

        Map<String, Object> body = new HashMap<>();
        body.put("eventId", eventId);
        body.put("title", newName);

        response = given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(USERINFO.BUYER.getToken())
                .body(eventInfoUpdated)
                .post(endpoint_update)
//                 .then()
//                 .assertThat()
//                 .body("event.title",Matchers.equalTo(newName))
//                 .statusCode(200)
//                 .body("success",Matchers.equalTo(true))
//                 .log()
//                 .body()

        ;
        response.prettyPrint();

    }


    public void cancel(int eventId) {

        String body = "{\"eventId\":" + eventId + "}";
        response = given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(USERINFO.BUYER.getToken())
                .body(body)
                .post(endpoint_cancel);

        response.prettyPrint();
    }


    public void delete(int eventId) {

        String body = "{\"eventId\":" + eventId + "}";
        given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(USERINFO.BUYER.getToken())
                .body(body)
                .post(endpoint_delete)
                .then()
                .assertThat()
//                .body("descr", Matchers.equalTo("Event deleted"))
//                .body("success",Matchers.equalTo(true))
                .body(
                        "descr", Matchers.equalTo("Event deleted"),
                        "success", Matchers.equalTo(true))

                .log()
                .body()
        ;
        // response.prettyPrint();
    }


}
