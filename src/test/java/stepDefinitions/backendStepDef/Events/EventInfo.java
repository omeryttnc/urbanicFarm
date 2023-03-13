package stepDefinitions.backendStepDef.Events;

import enums.USERINFO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.*;
import org.junit.Assert;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static io.restassured.RestAssured.given;
import static stepDefinitions.Hooks.faker;
import static stepDefinitions.Hooks.random;

@AllArgsConstructor
@ToString
public class EventInfo {
    @Getter
    private int fee, addressId, duration, attendeeLimit;
    @Getter
    private String title, date, tac;

    @Setter
    private int eventId;


    private String date(int day, int hour) {
        // 2023-03-17T21:31
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, day);
        calendar.add(Calendar.HOUR, hour);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        return (simpleDateFormat.format(calendar.getTime()));
    }

    private int getRandomAdressisDefault(USERINFO userinfo) {
        Response response;
        List<Integer> list = new ArrayList<>();
        response = given().
                contentType(ContentType.JSON)
                .auth().oauth2(userinfo.getToken())
                .post("https://" + (userinfo.isTest() ? "test." : "") + "urbanicfarm.com/api/account/address/getAddress");
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(200, response.statusCode());

        List<Integer> listId = response.jsonPath().getList("addresses.id");
        List<Boolean> isDefault = response.jsonPath().getList("addresses.isDefault");

        for (int i = 0; i < listId.size(); i++) {
            if (!isDefault.get(i)) {
                list.add(listId.get(i));
            }
        }

        return list.get(random.nextInt(list.size()));

    }



    public EventInfo(int day, int hour, USERINFO userinfo) {

        this.title = faker.name().name();
        this.date = date(day, hour);
        this.tac = faker.funnyName().name();
        this.duration = random.nextInt(100) + 1;
        this.fee = random.nextInt(100) + 1;
        this.attendeeLimit = random.nextInt(100) + 1;
        this.addressId = getRandomAdressisDefault(userinfo);

    }




}
