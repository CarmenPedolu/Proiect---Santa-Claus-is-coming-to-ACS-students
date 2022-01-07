package fileio;

import com.fasterxml.jackson.annotation.JsonProperty;
import enums.Category;

public final class SantaGiftsOutput {
    @JsonProperty("productName")
    private String productName;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("category")
    private Category category;

    public SantaGiftsOutput(final SantaGiftsInput gift) {
        productName = gift.getProductName();
        price = gift.getPrice();
        category = gift.getCategory();
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

}
