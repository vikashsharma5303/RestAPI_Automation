package api.endpoints;

public class Routes {
/*
 * https://petstore.swagger.io/v2/user/createWithList  ==Create New user
 * https://petstore.swagger.io/v2/user/{username}	   ==Read User
 * https://petstore.swagger.io/v2/user/{username}	   ==Update User
 * https://petstore.swagger.io/v2/user/{usernaem}      ==Deleter User
 * 
 *
 * 
 * 
 * 
 * *?
 */
	
	public static String base_URL = "https://petstore.swagger.io/v2/";
	public static String create_User = base_URL+"user/createWithList";
	public static String read_User = base_URL+"user/{username}";
	public static String update_User = base_URL+"user/{username}";
	public static String deleter_User = base_URL+"user/{username}";
	
	
}
