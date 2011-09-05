package org.fssle.sample.mapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.fssle.sample.pojo.Product;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class ProductDAO {
    private SqlSessionFactory sqlSessionFactory;

    public ProductDAO() {
        sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
    }

    public void deleteProducts() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ProductMapper mapper = session.getMapper(ProductMapper.class);
            mapper.deleteProducts();
            session.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }

    public List<Product> getProducts() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ProductMapper mapper = session.getMapper(ProductMapper.class);
            List<Product> list = mapper.getProducts();
            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return newArrayList();
    }

    public Product getProduct(String productId) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ProductMapper mapper = session.getMapper(ProductMapper.class);
            Product list = mapper.getProduct(productId);
            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return null;
    }

    public void updateProduct(String productId, Product product) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ProductMapper mapper = session.getMapper(ProductMapper.class);
            mapper.updateProduct(productId, product);
            session.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }

    public void insertProduct(Product product) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ProductMapper mapper = session.getMapper(ProductMapper.class);
            mapper.insertProduct(product);
            session.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }

    public void deleteProduct(String productId) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ProductMapper mapper = session.getMapper(ProductMapper.class);
            mapper.deleteProduct(productId);
            session.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }
}

