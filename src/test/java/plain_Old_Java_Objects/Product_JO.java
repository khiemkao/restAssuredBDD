package plain_Old_Java_Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@JsonPropertyOrder({"id","name","cost","quantity"})
public class Product_JO {

    private int id;
    private String name;
    private int cost;
    private int quantity;

    public Product_JO() {

    }

    public Product_JO(JsonObject jsonObject) {
        Gson gson = new Gson();
        this.id = gson.fromJson(jsonObject, Product_JO.class).getId();
        this.name = gson.fromJson(jsonObject, Product_JO.class).getName();
        this.cost = gson.fromJson(jsonObject, Product_JO.class).getCost();
        this.quantity = gson.fromJson(jsonObject, Product_JO.class).getQuantity();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("id")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public int getId() {
        return id;
    }

    @JsonProperty("name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getName() {
        return name;
    }

    @JsonProperty("cost")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public int getCost() {
        return cost;
    }

    @JsonProperty("quantity")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public int getQuantity() {
        return quantity;
    }

    public boolean isMatched(Product_JO po) {
        if (this.id != po.id) {
            return false;
        }
        if (!this.name.equalsIgnoreCase(po.name)) {
            return false;
        }
        if (this.cost != po.cost) {
            return false;
        }
        if (this.quantity != po.quantity) {
            return false;
        }
        return true;
    }
}
