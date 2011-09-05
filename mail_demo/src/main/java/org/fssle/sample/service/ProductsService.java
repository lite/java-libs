package org.fssle.sample.service;

import org.fssle.sample.mapper.ProductDAO;
import org.fssle.sample.pojo.Product;
import org.fssle.sample.presenter.ProductPresenter;
import org.fssle.sample.presenter.ProductsPresenter;

public class ProductsService {
    private ProductDAO productDAO = new ProductDAO();

    public ProductsPresenter createProductsPresenter() {
        return new ProductsPresenter(productDAO.getProducts());
    }

    public ProductPresenter createProductPresenter() {
        return new ProductPresenter();
    }

    public ProductPresenter createProductPresenter(String productId) {
        return new ProductPresenter(getProduct(productId));
    }

    public void deleteProduct(String productId) {
        productDAO.deleteProduct(productId);
    }

    public void insertProduct(Product product) {
        productDAO.insertProduct(product);
    }

    public void updateProduct(String productId, Product product) {
        productDAO.updateProduct(productId, product);
    }

    public Product getProduct(String productId) {
        return productDAO.getProduct(productId);
    }

    public void deleteProducts() {
        productDAO.deleteProducts();
    }
}
