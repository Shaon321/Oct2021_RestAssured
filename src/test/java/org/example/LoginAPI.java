package org.example;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class LoginAPI {

    @Test
    public void TTechLoginCall() {

        RestAssured.baseURI = "http://qa.taltektc.com/api/";
        EncoderConfig encoderConfig = RestAssured.config().getEncoderConfig()
                .appendDefaultContentCharsetToContentTypeIfUndefined(false);
        RestAssured.config = RestAssured.config().encoderConfig(encoderConfig);

        Response rest = RestAssured.given()
                .contentType("application/json")
                .body("{\n" +
                        "    \"email\" : \"jhon.doe305@gmail.com\",\n" +
                        "    \"password\" : \"123456\"\n" +
                        "}")
                .post("login");

        System.out.println(rest.getStatusCode());
        System.out.println(rest.getBody().asString());
    }
}