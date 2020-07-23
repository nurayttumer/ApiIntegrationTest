import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import io.restassured.specification.RequestSpecification;

import java.util.List;


public class IntegrationTest {
    String fifthElement ;
    @Test
    public void GetClients()
    {
        RestAssured.baseURI = "http://generator.swagger.io/api/gen/clients";
        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET);

        String responseBody = response.getBody().asString();
        System.out.println("GetClients : Response GET Body is =>  " + responseBody);
        Integer statusCode=response.getStatusCode();
        System.out.println("GetClients : Response GET Status Code =>  " +statusCode);

        Assert.assertEquals(200, (int) statusCode);

    }

    @Test
    public void PostClientsWithGetData()
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
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET);

        List<String> jsonResponse = response.jsonPath().getList("$");    // GET data
        System.out.println(jsonResponse.get(4));
        fifthElement = jsonResponse.get(4);
        System.out.println(fifthElement + "is the fifth element"); //GET 5.th data
        Integer statusCode=response.getStatusCode();
        System.out.println("PostClientsWithGetData : Response GET Status Code =>  " +statusCode); //GET status code
        Assert.assertEquals(200, (int) statusCode);

        try {
            response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                    .post(fifthElement);                              //POST data send 5.th element in Post request
        } catch (Exception e) {
            e.printStackTrace();
        }

        String postClientsWithGetDataResponseBody = response.getBody().asString();
        System.out.println("PostClientsWithGetData : Response POST Body is =>  " + postClientsWithGetDataResponseBody);        //POST data 5th element response body

        Integer postClientsWithGetDatastatusCode=response.getStatusCode();
        System.out.println("PostClientsWithGetData : Response POST Status Code =>  " + postClientsWithGetDatastatusCode);     //POST data 5th element status code
        Assert.assertEquals(200, (int) statusCode);


    }

    @Test
    public void PostFailClients()
    {

        String requestBadBody = "{\n" +
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
                "  }\n" ;



        RestAssured.baseURI = "http://generator.swagger.io/api/gen/clients";

        Response response = null;

        try {
            response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(requestBadBody)
                    .post("/java");
        } catch (Exception e) {
            e.printStackTrace();
        }

        String responseBody = response.getBody().asString();
        System.out.println("Response POST Body is =>  " + responseBody);

        Integer statusCode=response.getStatusCode();
        System.out.println("Response POST Status Code =>  " +statusCode);

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
        System.out.println("Response POST Body is =>  " + responseBody);

        Integer statusCode=response.getStatusCode();
        System.out.println("Response POST Status Code =>  " +statusCode);

        Assert.assertEquals(200, (int) statusCode);



    }
}
