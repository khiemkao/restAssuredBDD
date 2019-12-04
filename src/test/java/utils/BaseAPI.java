package utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
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

    /**
     * PrepareRequest
     * @param requestMethod
     * @param path
     * @return
     */
    public RequestSpecification prepareRequest(String requestMethod, String  path) {
        httpMethod = requestMethod;
        pathURL = path;
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri(baseURL);
        builder.setContentType(ContentType.JSON);
        return RestAssured.given().spec(builder.build());
    }

    /**
     * ExecuteWithQueryParams
     * @param queryParams
     * @return
     */
    public ResponseOptions<Response> executeWithQueryParams(Map<String, String> queryParams) {
        request.queryParams(queryParams);
        return executeAPI();
    }

    /**
     * ExecuteWithPathParams
     * @param pathParams
     * @return
     */
    public ResponseOptions<Response> executeWithPathParams(Map<String, String> pathParams) {
        request.pathParams(pathParams);
        return executeAPI();
    }

    /**
     * ExecuteWithBody
     * @param body
     * @return
     */
    public ResponseOptions<Response> executeWithBody(Map<String, String> body) {
        request.body(body);
        return executeAPI();
    }

    /**
     * ExecuteWithQueryParamsAndBody
     * @param queryParams
     * @param body
     * @return
     */
    public ResponseOptions<Response> executeWithQueryParamsAndBody(Map<String, String> queryParams, Map<String, String> body) {
        request.queryParams(queryParams);
        request.body(body);
        return executeAPI();
    }

    /**
     * ExecuteWithPathParamsAndBody
     * @param pathParams
     * @param body
     * @return
     */
    public ResponseOptions<Response> executeWithPathParamsAndBody(Map<String, String> pathParams, Map<String, String> body) {
        request.pathParams(pathParams);
        request.body(body);
        return executeAPI();
    }
}
