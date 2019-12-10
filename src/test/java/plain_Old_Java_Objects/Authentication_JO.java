package plain_Old_Java_Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@JsonPropertyOrder({"email","password"})
public class Authentication_JO {

    private String email;
    private String password;

    public Authentication_JO() {

    }

    public Authentication_JO(JsonObject userObject) {
        Gson gson = new Gson();
        this.email = gson.fromJson(userObject, Authentication_JO.class).getEmail();
        this.password = gson.fromJson(userObject, Authentication_JO.class).getPassword();
    }

    @JsonProperty("email")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getEmail() {
        return email;
    }

    @JsonProperty("password")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
