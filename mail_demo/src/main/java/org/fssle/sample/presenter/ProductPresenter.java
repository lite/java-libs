package org.fssle.sample.presenter;

import com.google.common.base.Joiner;
import org.fssle.sample.model.Product;

public class ProductPresenter {
    private String url;
    private Product product;

    public ProductPresenter(Product product) {
        this.product = product;
    }

    public String getUrl() {
        return Joiner.on("-").join("product", product.getId());
    }

}
