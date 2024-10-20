package api.endpoints;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import org.json.JSONArray;
import org.json.JSONObject;



import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints2 {
	
	static ResourceBundle getURL(){		
		ResourceBundle routes = ResourceBundle.getBundle("routers"); //Load properties file
		return routes;
	}

	public static Response createUser(User payload) {
		String createUser = getURL().getString("create_User");		
		JSONArray data = new JSONArray();
		data.put(new JSONObject(payload));
		Response response = given().accept(ContentType.JSON).contentType(ContentType.JSON).body(data.toString()).when()
				.post(createUser);
		return response;
	}

	public static Response readUser(String username) {
		String getUser = getURL().getString("read_User");	
		Response response = given().pathParam("username", username)
				.when().get(getUser);

		return response;
	}

	public static Response updateUser(String username, User payload) {
		String updateUser = getURL().getString("update_User");	
		Response response = given().contentType("application/json").accept("application/json")
				.pathParam("username", username).body(payload)
				.when().put(updateUser);
		return response;
	}

	public static Response deleteUser(String username) {
		String deleteUser = getURL().getString("delete_User");	
		Response response = given().pathParam("username", username)
				.when().delete(deleteUser);
		return response;
		
	}
	
	
}
