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

    /**
     * PrepareRequest
     * @param requestMethod
     * @param path
     */
    public RequestSpecification setRequest(String requestMethod, String  path) {
        httpMethod = requestMethod;
        pathURL = path;
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri(baseURL);
        builder.setContentType(ContentType.JSON);
        return RestAssured.given().spec(builder.build());
    }

    /**
     * Send the request to server basing on the httpMethod and pathURL
     * @return
     */
    private ResponseOptions<Response> executeAPI() {
        try {
            //write log.debug with message "${httpMethod} ${requestURI} ${parameters}"

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
        } catch (Exception e) {
            //write log.error
            e.getMessage();
            return null;
        }
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
    public ResponseOptions<Response> executeWithBody(Object body) {
        request.body(body);
        return executeAPI();
    }

    /**
     * ExecuteWithQueryParamsAndBody
     * @param queryParams
     * @param body
     * @return
     */
    public ResponseOptions<Response> executeWithQueryParamsAndBody(Map<String, String> queryParams, Object body) {
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
    public ResponseOptions<Response> executeWithPathParamsAndBody(Map<String, String> pathParams, Object body) {
        request.pathParams(pathParams);
        request.body(body);
        return executeAPI();
    }
}
