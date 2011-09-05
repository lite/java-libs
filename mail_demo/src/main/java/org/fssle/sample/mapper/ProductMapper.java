package org.fssle.sample.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.fssle.sample.pojo.Product;

import java.util.List;

public interface ProductMapper {

    @Select("SELECT product_id, product_name FROM products")
    List<Product> getProducts();

    @Select("SELECT product_id, product_name FROM products WHERE product_id = #{productId}")
    Product getProduct(@Param("productId") String productId);

    @Delete("DELETE FROM products WHERE product_id=#{productId}")
    void deleteProduct(@Param("productId") String productId);

    @Insert("INSERT INTO products(product_id, product_name) VALUES( #{product.product_id}, #{product.product_name} )")
    void insertProduct(@Param("product")Product product);

    @Update("UPDATE products SET  product_id = #{product.product_id}, product_name = #{product.product_name} where product_id = #{productId}")
    void updateProduct(@Param("productId") String productId, @Param("product")Product product);

    @Delete("DELETE FROM products")
    void deleteProducts();
}
