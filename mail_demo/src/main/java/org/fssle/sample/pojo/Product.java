package org.fssle.sample.pojo;

import com.google.common.base.Joiner;

public class Product {
    private String product_id;
    private String product_name;

    public Product() {
        this("", "");
    }

    public Product(String productId, String productName) {
        this.product_id = productId;
        this.product_name = productName;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getUrl() {
        return Joiner.on("-").join("product", product_id);
    }
}
