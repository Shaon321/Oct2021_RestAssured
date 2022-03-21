import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class D_GetAllStudentsAPI {

    @Test
    public void getAllStudentInfo() throws JsonProcessingException {

        RestAssured.baseURI="http://qa.taltektc.com/api/";
        EncoderConfig encoderConfig = RestAssured.config().getEncoderConfig()
                .appendDefaultContentCharsetToContentTypeIfUndefined(false);
        RestAssured.config = RestAssured.config().encoderConfig(encoderConfig);

        Response response = RestAssured.given()
                .contentType("application/json")
                .get("students");

        System.out.println(response.getStatusCode());
        System.out.println(response.getBody().asString());
        ObjectMapper map= new ObjectMapper();
        JsonNode body = map.readTree(response.getBody().asString());
        JsonNode data = body.get("data");

        for(int i=0;i<data.size();i++){
            System.out.println(data.get(i).get("lastName"));

            String lastName = data.get(i).get("lastName").toString().replaceAll("\"","");
           if(lastName.equals("Fillmore")){
               System.out.println(data.get(i).get("firstName"));
               System.out.println(data.get(i).get("email"));
               System.out.println(data.get(i).get("dob"));
                break;
            }
        }

    }
}
