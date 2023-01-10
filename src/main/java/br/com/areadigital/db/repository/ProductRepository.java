package br.com.areadigital.db.repository;

import br.com.areadigital.db.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
//    default Product procurarid(@Param("id") Long id) {
//        return findById(id).get();
//    }


    List<Product> findByName(@Param("name") String name);
}