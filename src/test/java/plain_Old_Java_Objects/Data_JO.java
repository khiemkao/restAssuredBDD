package plain_Old_Java_Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@JsonPropertyOrder({"data","language","user"})
public class Data_JO {
    private Data data;
    private String language;
    private User_JO user;

    public Data_JO() {
    }
    public Data_JO(JsonObject object) {
        Gson gson = new Gson();
        this.data = gson.fromJson(object, Data_JO.class).getData();
        this.language = gson.fromJson(object, Data_JO.class).getLanguage();
        this.user = gson.fromJson(object, Data_JO.class).getUser();
    }

    @JsonProperty("data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @JsonProperty("language")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("user")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public User_JO getUser() {
        return user;
    }

    public void setUser(User_JO user) {
        this.user = user;
    }

    @JsonPropertyOrder({"month"})
    private class Data {
        private String month;

        public Data() {
        }
        public Data(JsonObject object) {
            Gson gson = new Gson();
            this.month = gson.fromJson(object, Data.class).getMonth();
        }

        @JsonProperty("month")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }
    }
}
