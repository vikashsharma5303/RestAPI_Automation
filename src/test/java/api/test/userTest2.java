package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints2;
import api.payload.User;
import io.restassured.response.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class userTest2 {
	
	
	Faker faker;
	User userPayload;
	
	public Logger logger;
	
	@BeforeClass
	public void setUpData() {
		
		faker = new Faker();
		userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		
		//Logs
		logger= LogManager.getLogger(this.getClass());
		
	}
	
	@Test(priority = 1)
	public void testPostUser() {
		logger.info("******** Creating User ************");
		Response response = UserEndPoints2.createUser(userPayload);		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("******** User Created ************");
		
	}
	
	@Test(priority = 2)
	public void testGetUserDetails() {
		logger.info("******** Getting User ************");
		Response response = UserEndPoints2.readUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("******** User Get Successfully ************");
	}
	
	@Test(priority =3)
	public void testUpdateUserDetails(){
		logger.info("******** Updating User ************");
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response = UserEndPoints2.updateUser(this.userPayload.getUsername(), userPayload);
		
		response.then().statusCode(200);
		response.then().log().all();
		
		logger.info("******** User Updated ************");
	}
	
	@Test(priority = 4)
	public void testDeleteUserDetails() {
		logger.info("******** Deleting User ************");
		Response response = UserEndPoints2.deleteUser(this.userPayload.getUsername());
		response.then().statusCode(200);
		response.then().log().all();
		logger.info("******** User Deleted ************");
	}

}
