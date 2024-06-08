package net.code.java;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO products (name, description, price, category_id) VALUES ('Laptop', 'Lenovo laptop.', '$1000', 1)", nativeQuery = true)
    void saveProduct(@Param("name") String name,
                     @Param("description") String description,
                     @Param("price") BigDecimal price,
                     @Param("categoryId") Long categoryId);
}
