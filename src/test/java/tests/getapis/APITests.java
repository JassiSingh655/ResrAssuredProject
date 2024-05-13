package tests.getapis;

import api.base.BaseTest;
import io.restassured.response.Response;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITests extends BaseTest {
	
	@Test
	public void testGetCityAPI() {
		
		String latitude = "28.4136657";
        String longitude = "77.0424521";
        String expectedCity = "Gurgaon";
        // Make GET request
        Response response = given()
            .param("latitude", latitude)
            .param("longitude", longitude)
        .when()
            .get("/get-city");

        // Validate response status code
        int statusCode = response.getStatusCode();
        assertEquals(statusCode, 200, "Status code is not 200");

        // Validate response body
        String name = response.jsonPath().getString("city.name");
        // Assert that the extracted value is equal to "Gurgaon"
        assertEquals(name, "Gurgaon", "Value of key 'name' is not 'Gurgaon'");
        
        String sitemap_name = response.jsonPath().getString("city.sitemap_name").toLowerCase();
        assertEquals(sitemap_name, "gurgaon", "Value of key 'name' is not 'Gurgaon'");
    }

}
