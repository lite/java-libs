package org.fssle.sample.controller;

import org.fssle.sample.presenter.ProductPresenter;
import org.fssle.sample.presenter.ProductsPresenter;
import org.fssle.sample.service.ProductsService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ProductControllerTest {
    private ProductController productController = new ProductController();
    private ModelMap modelMap;

    @Before
    public void setUp() throws Exception {
        productController.setProductsService(new ProductsService());
    }

    @Test
    public void should_return_default_products() {
        modelMap = new ModelMap();
        productController.index(modelMap);
        ProductsPresenter productsPresenter = (ProductsPresenter) modelMap.get("products");

        assertThat(productsPresenter, notNullValue());
        assertThat(productsPresenter.getProducts(), notNullValue());
    }

    @Test
    public void should_return_with_single_product_by_id() {
        modelMap = new ModelMap();
        productController.show("3", modelMap);
        ProductPresenter productPresenter = (ProductPresenter) modelMap.get("product");

        assertThat(productPresenter, notNullValue());
        assertThat(productPresenter.getUrl(), notNullValue());
    }
}
