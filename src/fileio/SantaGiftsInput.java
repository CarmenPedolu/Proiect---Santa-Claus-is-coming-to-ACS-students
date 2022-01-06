package fileio;

import com.fasterxml.jackson.annotation.JsonProperty;
import enums.Category;

public final class SantaGiftsInput {
    @JsonProperty("productName")
    private String productName;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("category")
    private Category category;
    @JsonProperty("quantity")
    private int quantity;

    public SantaGiftsInput() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(final String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(final Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(final Category category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
