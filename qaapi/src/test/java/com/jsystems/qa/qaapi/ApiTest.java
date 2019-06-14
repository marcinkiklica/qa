package com.jsystems.qa.qaapi;


import com.jsystems.qa.qaapi.model.error.ErrorResponse;
import com.jsystems.qa.qaapi.model.user.MyUser;
import com.jsystems.qa.qaapi.model.user.User;
import com.jsystems.qa.qaapi.service.ApiService;
import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@DisplayName("API tests")
public class ApiTest {

    @Test
    public void firstApitTest(){
        RestAssured
                .given()
                .get("http://www.mocky.io/v2/5a6b69ec3100009d211b8aeb")
                .then()
                .assertThat()
                .statusCode(200)
                .body("name", equalTo("Piotr"))
                .body("surname", equalTo("Kowalski"));
    }
    @Test
    public void secondApiTest(){
        RestAssured
                .given()
                .get("http://www.mocky.io/v2/5a6a58222e0000d0377a7789")
                .then()
                .assertThat()
                .statusCode(200)
                .body("[0].imie", equalTo("Piotr"))
                .body("[0].imie", notNullValue())
                .body("[0].nazwisko", equalTo("Kowalski"))
                .body("[0].device[0].type", equalTo("computer"));
//                .body("[0].device[0].device.model.produce", equalTo("computer"));
    }



    @Test
    @DisplayName("First test with mapping to JsonPath")
    public void jsonPathTest(){
        List<User> users = ApiService.getUsers();
        User singleUser = users.get(0);
        assertThat(singleUser.imie).isEqualTo("Piotr");
        assertThat(singleUser.nazwisko).isEqualTo("Kowalski");
        assertThat(singleUser.device.get(0).type).isEqualTo("computer");
        assertThat(singleUser.device.get(0).deviceModel.get(0).produce).isEqualTo("dell");
        assertThat(singleUser.device.get(0).deviceModel.get(0).screenSize).isEqualTo(17);
    }

    @Test
    public void firstApiUpgradeTest() {
        MyUser user = ApiService.getUser();
        assertThat(user.name).isEqualTo("Piotr");
        assertThat(user.surname).isEqualTo("Kowalski");
    }

    @Test
    public void postTest() {
        String[] strings = ApiService.postMyUser(new MyUser("Piotr", "Kowalski"));
        assertThat(strings).isEmpty();
    }

    @Test
    public void errorMessageTest() {
        ErrorResponse errorMsg = ApiService.getErrorResponse();
        assertThat(errorMsg.error).isNotNull();
        assertThat(errorMsg.error.errodCode).isEqualTo(400);
        assertThat(errorMsg.error.validationError).isEqualTo("invalid_email");
        assertThat(errorMsg.error.message).isEqualTo("your email is invalid");
    }
}
