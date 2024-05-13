package api.base.postapis;

import org.testng.annotations.Test;

import api.base.BaseTest;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SendOTP extends BaseTest {

	@Test
	public void sendOTP() {
		given().baseUri("https://gomechanic.app")
				.header("Authorization", "7d078510aa0e34d6703f0bad46bdbd4cfc8a620a307a2e076483ac2256f71b9e")
				.contentType("application/json")
				.body("{\"number\":\"8447466512\",\"source\":\"website\",\"random_id\":\"UNoDb\"}").when()
				.post("/api/v2/send_otp").then().statusCode(200).body("message", equalTo("OTP sent to your phone!"))
				.body("data.status_code", equalTo(200));

	}

}
