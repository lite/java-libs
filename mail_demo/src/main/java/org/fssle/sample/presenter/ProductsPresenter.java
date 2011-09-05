package org.fssle.sample.presenter;

import org.fssle.sample.pojo.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductsPresenter {
    private List<Product> products;

    public ProductsPresenter(Collection<Product> values) {
        products = new ArrayList<Product>(values);
    }

    public List<Product> getProducts() {
        return products;
    }
}
