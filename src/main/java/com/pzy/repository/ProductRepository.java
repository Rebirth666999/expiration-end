package com.pzy.repository;

import com.pzy.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByUserId(Long userId); // 自定义查询方法

    /**
     * 根据产品类型获取产品列表
     */
    @Query("SELECT p FROM Product p WHERE p.productType = :productType")
    List<Product> findByProductType(@Param("productType") String productType);

    /**
     * 根据用户ID和产品类型查询产品列表
     */
    @Query("SELECT p FROM Product p WHERE p.userId = :userId AND p.productType = :productType")
    List<Product> findByUserIdAndProductType(@Param("userId") Long userId, @Param("productType") String productType);

}
