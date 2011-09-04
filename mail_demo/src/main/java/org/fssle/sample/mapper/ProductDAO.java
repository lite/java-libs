package org.fssle.sample.mapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.fssle.sample.model.Product;

import java.util.List;

public class ProductDAO {
    private SqlSessionFactory sqlSessionFactory;

    public ProductDAO(){
        sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
    }

    public List<Product> getProducts(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ProductMapper mapper = session.getMapper(ProductMapper.class);
            List<Product> list = mapper.getProducts();
            return list;
        } finally {
            session.close();
        }
    }

    public Product getProduct(String productId){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ProductMapper mapper = session.getMapper(ProductMapper.class);
            Product list = mapper.getProduct(productId);
            return list;
        } finally {
            session.close();
        }
    }

    public void updateProduct(Product Product){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ProductMapper mapper = session.getMapper(ProductMapper.class);
            mapper.updateProduct(Product);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void insertProduct(Product Product){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ProductMapper mapper = session.getMapper(ProductMapper.class);
            mapper.insertProduct(Product);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void deleteProduct(String productId){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ProductMapper mapper = session.getMapper(ProductMapper.class);
            mapper.deleteProduct(productId);
            session.commit();
        } finally {
            session.close();
        }
    }
}

