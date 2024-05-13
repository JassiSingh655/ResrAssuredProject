package api.base;

import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import io.restassured.RestAssured;

public class BaseTest {
	
	protected static final String BASE_URI = "https://gomechanic.in/api/v1";

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = BASE_URI;
    }
}
