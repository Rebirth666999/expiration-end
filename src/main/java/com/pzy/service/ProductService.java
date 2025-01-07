package com.pzy.service;

import com.pzy.entity.Product;
import com.pzy.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository; // 假设有一个 JPA Repository 连接数据库

    /**
     * 根据用户ID获取产品列表
     */
    public List<Product> getProductsByUserId(Long userId) {
        return productRepository.findByUserId(userId);
    }

    /**
     * 添加一个新产品
     */
    public void addProduct(Product product) {
        productRepository.save(product); // 保存产品到数据库
    }

    /**
     * 删除一个产品
     */
    public boolean deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }


    /**
     * 根据用户ID和产品类型获取产品列表
     */
    public List<Product> getProductsByUserIdAndType(Long userId, String productType) {
        if (userId == null || userId <= 0) {
            throw new IllegalArgumentException("Invalid user ID");
        }
        if (productType == null || productType.trim().isEmpty()) {
            throw new IllegalArgumentException("Product type cannot be null or empty");
        }
        return productRepository.findByUserIdAndProductType(userId, productType);
    }


}

