import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class A_SignUpAPI {
    //After register it will provide random student_id
    @Test
    public void TTechPostCall() throws JsonProcessingException {
        //Rest assured is java library for testing Restful Web services. It can be used to test XML & JSON based web services. It supports GET, POST, PUT, PATCH, DELETE, OPTIONS and HEAD requests and can be used to validate and verify the response of these requests.

        RestAssured.baseURI="http://qa.taltektc.com/api/";
        EncoderConfig encoderConfig = RestAssured.config().getEncoderConfig()
                .appendDefaultContentCharsetToContentTypeIfUndefined(false);
        RestAssured.config = RestAssured.config().encoderConfig(encoderConfig);

        Response rest = RestAssured.given() //Response is an Interface extends ResponseBody
                //public interface Response
                //extends ResponseBody<Response>
                .contentType("application/json")
                .body("{\n" +
                        "    \"firstName\" : \"Jhonson\",\n" +
                        "    \"lastName\" : \"Doe\",\n" +
                        "    \"email\"     : \"jhondd10@gmail.com\",\n" +
                        "    \"password\"  : \"123456\",\n" +
                        "    \"confirmPassword\"  : \"123456\",\n" +
                        "    \"dob\"       : {\n" +
                        "        \"year\"      : 2013,\n" +
                        "        \"month\"     : 12,\n" +
                        "        \"day\"       : 31\n" +
                        "    },\n" +
                        "    \"gender\"    : \"male\",\n" +
                        "    \"agree\"     : true\n" +
                        "}")
                .post("signup"); //endpoint

        System.out.println(rest.getStatusCode()); //201
        Assert.assertEquals(rest.getStatusCode(),201);
        System.out.println(rest.getBody().asString()); //body
        ObjectMapper map= new ObjectMapper(); //ObjectMapper is a class & coming from Jackson
        JsonNode js = map.readTree(rest.getBody().asString()); //JsonNode - converted to
        System.out.println(js.get("success")); //true -- get value for success from console
        System.out.println(js.get("id")); //id

    }
}
