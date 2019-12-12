package plain_Old_Java_Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@JsonPropertyOrder({"street", "ward", "district"})
public class Address_JO {
    private String street;
    private String ward;
    private String district;

    public Address_JO() {

    }

    public Address_JO(JsonObject jsonObject) {
        Gson gson = new Gson();
        this.street = gson.fromJson(jsonObject, Address_JO.class).getStreet();
        this.ward = gson.fromJson(jsonObject, Address_JO.class).getWard();
        this.district = gson.fromJson(jsonObject, Address_JO.class).getDistrict();
    }

    @JsonProperty("street")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @JsonProperty("ward")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    @JsonProperty("district")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
