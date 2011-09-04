package org.fssle.sample.service;

import org.fssle.sample.mapper.ProductMapper;
import org.fssle.sample.model.Product;
import org.fssle.sample.presenter.ProductsPresenter;

import java.util.HashMap;
import java.util.Map;

public class ProductsService {
    private Map<String, Product> products = new HashMap();
    private ProductMapper productMapper;

    public void setUserMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public ProductsService() {
        addProduct("1", "Ruby");
        addProduct("2", "Perl");
        addProduct("3", "Python");
    }

    public ProductsPresenter createProductsPresenter() {
        return new ProductsPresenter(products.values());
    }

    private void addProduct(String id, String name) {
        products.put(id, new Product(id, name));
    }

    public Product getProduct(String productId) {
        return this.productMapper.getProduct(productId);
    }
}
