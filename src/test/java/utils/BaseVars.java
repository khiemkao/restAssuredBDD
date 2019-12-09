package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

public class BaseVars {
    public static RequestSpecBuilder builder;
    public static ResponseOptions<Response> response;
    public static String baseURL = "http://localhost:3000";
    public static String pathURL;
    public static String httpMethod;
    public String testData_Users = "./src/test/java/data/Authentication.json";
    public String testData_Products = "./src/test/java/data/Products.json";
}
