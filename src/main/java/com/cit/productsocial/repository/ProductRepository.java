package com.cit.productsocial.repository;

import com.cit.productsocial.domain.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductRepository extends JpaRepository<Products, Long>,
        JpaSpecificationExecutor<Products> {
    /*@Query("select * from Products")
        List<Products> getName();*/
    Page<Products> findAll(Pageable pageable);

}