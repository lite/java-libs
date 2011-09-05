package org.fssle.sample.presenter;

import com.google.common.base.Joiner;
import org.fssle.sample.pojo.Product;

public class ProductPresenter {
    private String url;
    private Product product;

    public ProductPresenter(Product product) {
        this.product = product;
    }

    public ProductPresenter() {
        this.product = new Product();
    }

    public String getUrl() {
        return Joiner.on("-").join("product", product.getProduct_id());
    }

    public String getId(){
        return product.getProduct_id();
    }

    public String getName(){
        return product.getProduct_name();
    }

}
