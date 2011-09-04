package org.fssle.sample.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.fssle.sample.model.Product;

import java.util.List;

public interface ProductMapper {

    @Select("SELECT * FROM products")
    List<Product> getProducts();

    @Select("SELECT * FROM products WHERE product_id = #{productId}")
    Product getProduct(@Param("productId") String productId);

    @Delete("DELETE FROM products WHERE product_id = #{productId}")
    void deleteProduct(@Param("productId") String productId);

    @Insert("INSERT INTO products(product_id, product_name) VALUES( #{id}, #{name} )")
    void insertProduct(Product product);

    @Update("UPDATE products SET product_name = #{name} where product_id = #{id}")
    void updateProduct(Product product);
}
