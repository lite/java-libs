package org.fssle.sample.mapper;

import org.fssle.sample.pojo.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class ProductDAOTest {

    private ProductDAO productDAO;

    @Before
    public void setUp() throws Exception {
        productDAO = new ProductDAO();
        defaultProducts();
    }

    @Test
    public void should_get_product_by_id() {
        assertNull(productDAO.getProduct("none"));
        Product product = productDAO.getProduct("3");
        assertThat(product, notNullValue());
        assertThat(product.getProduct_id(), is("3"));
    }

    @Test
    public void should_update_product_by_id() {
        productDAO.updateProduct("2", new Product("4", "product_four"));
        assertNull(productDAO.getProduct("2"));
        Product product = productDAO.getProduct("4");
        assertThat(product, notNullValue());
        assertThat(product.getProduct_name(), is("product_four"));
    }

    @Test
    public void should_delete_products() {
        productDAO.deleteProducts();
        List<Product> products = productDAO.getProducts();
        assertThat(products.size(), equalTo(0));
    }

    @Test
    public void should_insert_product() {
        productDAO.insertProduct(new Product("4", "product_one"));
        productDAO.insertProduct(new Product("5", "product_two"));
        Product productOne = productDAO.getProduct("4");
        assertThat(productOne.getProduct_name(), is("product_one"));
        Product productTwo = productDAO.getProduct("5");
        assertThat(productTwo.getProduct_name(), is("product_two"));
    }

    @Test
    public void should_delete_product() {
        for (Product product : productDAO.getProducts()) {
            productDAO.deleteProduct(product.getProduct_id());
        }
        List<Product> products = productDAO.getProducts();
        assertThat(products.size(), equalTo(0));
    }

    @After
    public void tearDown() throws Exception {
        defaultProducts();
    }

    private void defaultProducts() {
        productDAO.deleteProducts();
        productDAO.insertProduct(new Product("1", "Ruby"));
        productDAO.insertProduct(new Product("2", "Python"));
        productDAO.insertProduct(new Product("3", "Perl"));
    }
}
