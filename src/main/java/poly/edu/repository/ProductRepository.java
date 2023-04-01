package poly.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import poly.edu.domain.Product;


import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
    @Query("SELECT p FROM Product p WHERE p.category.id like '01'")
    List<Product> findByCategoryId();

    @Query("SELECT p FROM Product p WHERE p.category.id like '02'")
    List<Product> findByCategoryId1();

    @Query("SELECT p FROM Product p WHERE p.category.id like '03'")
    List<Product> findByCategoryId2();
}
