package NegativeTesting;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class E_DeleteAPI {
    @Test
    public void deleteStudent() throws JsonProcessingException {

        RestAssured.baseURI="http://qa.taltektc.com/api/";
        EncoderConfig encoderConfig = RestAssured.config().getEncoderConfig()
                .appendDefaultContentCharsetToContentTypeIfUndefined(false);
        RestAssured.config = RestAssured.config().encoderConfig(encoderConfig);

        Response response = RestAssured.given()
                .contentType("application/json")
                .header("Authorization", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9xYS50YWx0ZWt0Yy5jb20iLCJhdWQiOiJUSEVfQVVESUVOQ0UiLCJpYXQiOjE2NDc2MzU3NTcsIm5iZiI6MTY0NzYzNTc2NywiZXhwIjoxNjQ3NzIyMTU3LCJpc19hZG1pbiI6ZmFsc2UsImRhdGEiOnsiaWQiOiIxNDA2IiwiZmlyc3RfbmFtZSI6Ikpob25zb24iLCJsYXN0X25hbWUiOiJEb2UiLCJlbWFpbCI6Impob25kMjAyMkBnbWFpbC5jb20iLCJzdHVkZW50SWQiOiJUVEMyaG9pNSJ9fQ.R5qNnyXzl71w7fQtBa666vq-vM9KEenG0y4x3HWATu4")
               // .header("Authorization", "Bearer")        // Token used here
                .delete("student/TTC2hoi5");  //id TTC8keHE
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody().asString());
        ObjectMapper map= new ObjectMapper();
        JsonNode body = map.readTree(response.getBody().asString());
        System.out.println(body.get("message"));
        System.out.println(body.get("data"));

    }
}












//eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9xYS50YWx0ZWt0Yy5jb20iLCJhdWQiOiJUSEVfQVVESUVOQ0UiLCJpYXQiOjE2MzUyNzc0MjMsIm5iZiI6MTYzNTI3NzQzMywiZXhwIjoxNjM1MzYzODIzLCJpc19hZG1pbiI6ZmFsc2UsImRhdGEiOnsiaWQiOiI0NyIsImZpcnN0X25hbWUiOiJhYWFhYSIsImxhc3RfbmFtZSI6ImFhYWFhYWFhIiwiZW1haWwiOiJhYWFhQGdtYWlsLmNvbSIsInN0dWRlbnRJZCI6IlRUQzhrZUhFIn19.J_4-j5kptJ3n5rqOYY_ddm0pz5CfV3QAB2eiG6qv8fs