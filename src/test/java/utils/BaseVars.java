package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

public class BaseVars {

    public static String baseURL = "http://localhost:3000";
    public static String pathURL;
    public static String httpMethod;
    public static RequestSpecBuilder builder = new RequestSpecBuilder();
    public static ResponseOptions<Response> response;

    public String testUserFile = "./src/test/java/data/Authentication.json";
    public String testProductFile = "./src/test/java/data/Products.json";
}
