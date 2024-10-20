package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTest {

	@Test( priority = 1, dataProvider = "data", dataProviderClass = DataProviders.class)
	public void testPostuser(String userID, String username, String fname, String lname, String usernamEmail,
			String pwd, String ph) {

		User userPayload = new User();
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(username);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(usernamEmail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);

		
		Response response = UserEndPoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void testDeleteUserByName(String username) {
		Response response = UserEndPoints.deleteUser(username);
		response.then().statusCode(200);
	}
}
