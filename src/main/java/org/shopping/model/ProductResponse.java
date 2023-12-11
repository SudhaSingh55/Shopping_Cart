package org.shopping.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductResponse {
    private String productName;
    private long productId;
    private long quantity;
    private long price;

    public ProductResponse(Product productEntity){
        this.productId = productEntity.getProductId();
        this.productName = productEntity.getProductName();
        this.quantity = productEntity.getQuantity();
        this.price = productEntity.getPrice();

    }
}
