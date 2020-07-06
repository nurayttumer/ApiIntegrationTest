import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import io.restassured.specification.RequestSpecification;


public class IntegrationTest {

    @Test
    public void GetClients()
    {
        RestAssured.baseURI = "http://generator.swagger.io/api/gen/clients";
        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET);

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);

        Integer statusCode=response.getStatusCode();
        System.out.println("Response Status Code =>  " +statusCode);

        Assert.assertEquals(200, (int) statusCode);



    }

    @Test
    public void PostClients()
    {
        String requestBody = "{\n" +
                "  \"spec\": {},\n" +
                "  \"options\": {\n" +
                "    \"additionalProp1\": \"Hepsiburada\",\n" +
                "    \"additionalProp2\": \"string\",\n" +
                "    \"additionalProp3\": \"string\"\n" +
                "  },\n" +
                "  \"swaggerUrl\": \"http://petstore.swagger.io/v2/swagger.json\",\n" +
                "  \"authorizationValue\": {\n" +
                "    \"value\": \"string\",\n" +
                "    \"type\": \"string\",\n" +
                "    \"keyName\": \"string\"\n" +
                "  },\n" +
                "  \"securityDefinition\": {\n" +
                "    \"type\": \"string\",\n" +
                "    \"description\": \"string\"\n" +
                "  }\n" +
                "}" ;


        RestAssured.baseURI = "http://generator.swagger.io/api/gen/clients";

        Response response = null;

        try {
            response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                    .post("/java");
        } catch (Exception e) {
            e.printStackTrace();
        }

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);

        Integer statusCode=response.getStatusCode();
        System.out.println("Response Status Code =>  " +statusCode);

        Assert.assertEquals(200, (int) statusCode);



    }
}
