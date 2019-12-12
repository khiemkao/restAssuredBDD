package plain_Old_Java_Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@JsonPropertyOrder({"id", "name", "address"})
public class Stores_JO {
    private int id;
    private String name;
    private Address_JO address;

    public Stores_JO() {

    }

    public Stores_JO(JsonObject jsonObject) {
        Gson gson = new Gson();
        this.id = gson.fromJson(jsonObject, Stores_JO.class).getId();
        this.name = gson.fromJson(jsonObject, Stores_JO.class).getName();
        this.address = gson.fromJson(jsonObject, Stores_JO.class).getAddress();
    }

    @JsonProperty("id")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("address")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Address_JO getAddress() {
        return address;
    }

    public void setAddress(Address_JO address) {
        this.address = address;
    }
}

