package plain_Old_Java_Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@JsonPropertyOrder({"userId","accountTypeId","accountId","levelType","subAccountId"})
public class User_JO {
    private int userId;
    private int accountTypeId;
    private int accountId;
    private String levelType;
    private String subAccountId;

    public User_JO() {
    }

    public User_JO(JsonObject jsonObject) {
        Gson gson = new Gson();
        this.userId = gson.fromJson(jsonObject, User_JO.class).getUserId();
        this.accountTypeId = gson.fromJson(jsonObject, User_JO.class).getAccountTypeId();
        this.accountId = gson.fromJson(jsonObject, User_JO.class).getAccountId();
        this.levelType = gson.fromJson(jsonObject, User_JO.class).getLevelType();
        this.subAccountId = gson.fromJson(jsonObject, User_JO.class).getSubAccountId();
    }

    @JsonProperty("userId")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @JsonProperty("accountTypeId")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public int getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(int accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    @JsonProperty("accountId")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @JsonProperty("levelType")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getLevelType() {
        return levelType;
    }

    public void setLevelType(String levelType) {
        this.levelType = levelType;
    }

    @JsonProperty("subAccountId")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getSubAccountId() {
        return subAccountId;
    }

    public void setSubAccountId(String subAccountId) {
        this.subAccountId = subAccountId;
    }
}
