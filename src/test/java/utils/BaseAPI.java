package utils;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveOAuth2HeaderScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.apache.logging.log4j.Logger;
import plain_Old_Java_Objects.Authentication_JO;

import java.util.Map;

public class BaseAPI {

    private RequestSpecBuilder builder;
    private RequestSpecification request;
    private Logger logger;

    public BaseAPI() {
        this.builder = BaseVars.builder;
        this.logger = BaseVars.logger;
    }

    /**
     * PrepareRequest
     * @param requestMethod
     * @param path
     */
    public RequestSpecBuilder setRequestPathMethod(String requestMethod, String path) {
        // init specBuilder
        builder = new RequestSpecBuilder();
        // set Base URL basing on BaseVars file
        builder.setBaseUri(BaseVars.baseURL);
        // set path URL basing on the request
        BaseVars.pathURL = path;
        // set API method basing on the request type
        BaseVars.httpMethod = requestMethod;
        // set Content Type as JSON
        builder.setContentType(ContentType.JSON);
        return builder;
    }

    /**
     * Set OAuthentication
     * @param specBuilder
     * @param authUser
     */
    public void setOAuth2Header(RequestSpecBuilder specBuilder, Authentication_JO authUser) {
        String token = RestAssured.given()
                .baseUri(BaseVars.baseURL).contentType(ContentType.JSON)
                .body(authUser)
                .when().post("/auth/login").getBody().jsonPath().get("access_token");
        if (token != null) {
            PreemptiveOAuth2HeaderScheme scheme = new PreemptiveOAuth2HeaderScheme();
            scheme.setAccessToken(token);
            specBuilder.setAuth(scheme);
        }
    }

    /**
     * Send the request to server basing on the httpMethod and pathURL
     * @return
     */
    private ResponseOptions<Response> executeAPI() {
        try {
            //init request
            request = RestAssured.given().spec(builder.build());
            ResponseOptions<Response> response;
            // perform Call basing on the method
            switch (BaseVars.httpMethod.toUpperCase()) {
                case "GET":
                    response = request.get(BaseVars.pathURL);
                    break;
                case "POST":
                    response = request.post(BaseVars.pathURL);
                    break;
                case "DELETE":
                    response = request.delete(BaseVars.pathURL);
                    break;
                case "PUT":
                    response = request.put(BaseVars.pathURL);
                    break;
                default:
                    logger.debug("API method is unidentified! It must be GET/POST/PUT/DELETE");
                    return null;
            }
            QueryableRequestSpecification logQuery = SpecificationQuerier.query(request);
            logger.debug(logQuery.getMethod() + " | " + logQuery.getURI() + " | " + logQuery.getBody());
            return response;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    /**
     * ExecuteWithQueryParams
     * @param queryParams
     * @return
     */
    public ResponseOptions<Response> executeWithQueryParams(Map<String, String> queryParams) {
        builder.addQueryParams(queryParams);
        return executeAPI();
    }

    /**
     * ExecuteWithPathParams
     * @param pathParams
     * @return
     */
    public ResponseOptions<Response> executeWithPathParams(Map<String, String> pathParams) {
        builder.addPathParams(pathParams);
        return executeAPI();
    }

    /**
     * ExecuteWithBody
     * @param body
     * @return
     */
    public ResponseOptions<Response> executeWithBody(Object body) {
        builder.setBody(body);
        return executeAPI();
    }

    /**
     * ExecuteWithQueryParamsAndBody
     * @param queryParams
     * @param body
     * @return
     */
    public ResponseOptions<Response> executeWithQueryParamsAndBody(Map<String, String> queryParams, Object body) {
        builder.addQueryParams(queryParams);
        builder.setBody(body);
        return executeAPI();
    }

    /**
     * ExecuteWithPathParamsAndBody
     * @param pathParams
     * @param body
     * @return
     */
    public ResponseOptions<Response> executeWithPathParamsAndBody(Map<String, String> pathParams, Object body) {
        builder.addPathParams(pathParams);
        builder.setBody(body);
        return executeAPI();
    }
}
