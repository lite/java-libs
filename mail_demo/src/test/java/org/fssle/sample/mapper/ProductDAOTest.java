package org.fssle.sample.mapper;

import org.fssle.sample.model.Product;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ProductDAOTest {

    @Test
    public void should_get_products() {
        ProductDAO productDAO = new ProductDAO();
        List<Product> products = productDAO.getProducts();
        assertThat(products.size(), equalTo(0));
    }

    @Test
    public void should_get_product_by_id() {
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.getProduct("2");
        assertThat(product, notNullValue());
        assertThat(product.getId(), is("2"));
    }
}
