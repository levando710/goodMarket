package edu.ptit.goodmarket.repository;

import edu.ptit.goodmarket.entity.Category;
import edu.ptit.goodmarket.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Optional<Product> findByProductId(String productId);

    List<Product> findByCategory(Category category);
    List<Product> findByTitleContainingIgnoreCase(String productName);

    List<Product> findBySellUser_UserId(String userId);

    List<Product> findByPriceBetween(double minPrice, double maxPrice);
}
