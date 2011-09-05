package org.fssle.sample.form;

import org.fssle.sample.pojo.Product;

public class ProductForm {
    private String productId;
    private String productName;

    public Product toProduct() {
        return new Product(productId, productName);
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
