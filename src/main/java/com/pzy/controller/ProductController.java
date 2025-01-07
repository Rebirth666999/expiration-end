package com.pzy.controller;

import com.pzy.entity.Product;
import com.pzy.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/product")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    /**
     * 获取用户的产品列表
     */
    @GetMapping("/getProductsByUserId/{userId}")
    public ResponseEntity<?> getProducts(@PathVariable Long userId) {
        try {
            if (userId == null || userId <= 0) {
                return new ResponseEntity<>("Invalid user ID", HttpStatus.BAD_REQUEST);
            }
            List<Product> products = productService.getProductsByUserId(userId);
            if (products.isEmpty()) {
                return new ResponseEntity<>("No products found for the given user ID", HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            logger.error("Error occurred while fetching products for user ID: " + userId, e);
            return new ResponseEntity<>("An error occurred while fetching products", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 增加一个产品
     */
    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        System.out.println("添加物品");
        try {
            if (product == null || product.getUserId() == null || product.getProductName() == null) {
                return new ResponseEntity<>("Invalid product data", HttpStatus.BAD_REQUEST);
            }
            productService.addProduct(product);
            return new ResponseEntity<>("Product added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error occurred while adding a product", e);
            return new ResponseEntity<>("An error occurred while adding the product", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 删除一个产品
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        try {
            if (id == null || id <= 0) {
                return new ResponseEntity<>("Invalid product ID", HttpStatus.BAD_REQUEST);
            }
            boolean isDeleted = productService.deleteProduct(id);
            if (!isDeleted) {
                return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error occurred while deleting the product with ID: " + id, e);
            return new ResponseEntity<>("An error occurred while deleting the product", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 根据用户ID和产品类型获取产品列表
     */
    @GetMapping("/getProductsByUserIdAndType")
    public ResponseEntity<?> getProductsByUserIdAndType(@RequestParam Long userId, @RequestParam String productType) {
        try {
            if (userId == null || userId <= 0) {
                return new ResponseEntity<>("Invalid user ID", HttpStatus.BAD_REQUEST);
            }
            if (productType == null || productType.trim().isEmpty()) {
                return new ResponseEntity<>("Invalid product type", HttpStatus.BAD_REQUEST);
            }
            List<Product> products = productService.getProductsByUserIdAndType(userId, productType.trim());
            if (products.isEmpty()) {
                return new ResponseEntity<>("No products found for the given user ID and product type", HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            logger.error("Error occurred while fetching products for user ID: {} and product type: {}", userId, productType, e);
            return new ResponseEntity<>("An error occurred while fetching products", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
