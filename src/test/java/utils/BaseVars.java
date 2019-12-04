package utils;

import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

public class BaseVars {

    public static String baseURL = "http://localhost:3000/";
    public static String pathURL;
    public static String httpMethod;
    public static RequestSpecification request;
    public static ResponseOptions<Response> response;
}
