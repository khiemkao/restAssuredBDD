package utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.util.Map;


public class BaseAPI extends BaseVars {

    public BaseAPI() {
    }

    private ResponseOptions<Response> executeAPI() {
        switch (httpMethod.toUpperCase()) {
            case "GET":
                return request.get(pathURL);
            case "POST":
                return request.post(pathURL);
            case "DELETE":
                return request.delete(pathURL);
            case "PUT":
                return request.put(pathURL);
            default:
                return null;
        }
    }
    public RequestSpecification prepareHeader(String method, String  path) {
        httpMethod = method;
        pathURL = path;
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri(baseURL);
        builder.setContentType(ContentType.JSON);
        return RestAssured.given().spec(builder.build());
    }

    public ResponseOptions<Response> executeWithQueryParams(Map<String, String> queryParams) {
        request.queryParams(queryParams);
        return executeAPI();
    }

    public ResponseOptions<Response> executeWithPathParams(Map<String, String> pathParams) {
        request.pathParams(pathParams);
        return executeAPI();
    }

    public ResponseOptions<Response> executeWithPathParams(String pathParam) {
//        request.pathParam(pathParam, );
        return executeAPI();
    }
}
