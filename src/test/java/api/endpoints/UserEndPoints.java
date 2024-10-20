package api.endpoints;

import static io.restassured.RestAssured.*;
import org.json.JSONArray;
import org.json.JSONObject;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {

	public static Response createUser(User payload) {
		JSONArray data = new JSONArray();
		data.put(new JSONObject(payload));
		Response response = given().accept(ContentType.JSON).contentType(ContentType.JSON).body(data.toString()).when()
				.post(Routes.create_User);
		return response;
	}

	public static Response readUser(String username) {
		Response response = given().pathParam("username", username)
				.when().get(Routes.read_User);

		return response;
	}

	public static Response updateUser(String username, User payload) {

		Response response = given().contentType("application/json").accept("application/json")
				.pathParam("username", username).body(payload).when().put(Routes.update_User);
		return response;
	}

	public static Response deleteUser(String username) {
		Response response = given().pathParam("username", username).when().delete(Routes.deleter_User);

		return response;
	}
}
