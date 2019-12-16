package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseVars {
    public static Logger logger = LogManager.getLogger();
    public static RequestSpecBuilder builder;
    public static ResponseOptions<Response> response;
    public static String baseURL = "http://localhost:3000";
    public static String pathURL;
    public static String httpMethod;
    public String testData_Users = "./src/test/java/data/Authentication.json";
    public String testData_Products = "./src/test/java/data/Products.json";
    public String testData_Stores = "./src/test/java/data/Stores.json";
    public String testData_Data = "./src/test/java/data/Data.json";
}
