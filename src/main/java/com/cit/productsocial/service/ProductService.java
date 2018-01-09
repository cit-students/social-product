package com.cit.productsocial.service;

import com.cit.productsocial.model.PagingObject;
import com.cit.productsocial.model.ProductForm;
import com.cit.productsocial.domain.Products;
import com.cit.productsocial.domain.Products_;
import com.cit.productsocial.model.ProductModel;
import com.cit.productsocial.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }




    public PagingObject<ProductModel> getAllProducts(Pageable pageable, String name, String desc) {
        log.info("Paging : " + pageable);
        if (pageable.getPageSize() > 500) throw new RuntimeException("Page size too big");

        PagingObject<ProductModel> rs = new PagingObject<>();
        Page<Products> productPage;
        if (StringUtils.hasText(name) || StringUtils.hasText(desc)) {
            productPage = productRepository.findAll((root, query, cb) -> {
                List<javax.persistence.criteria.Predicate> predicates = new ArrayList<>();
                if (StringUtils.hasText(name)) {
                    predicates.add(cb.like(root.get(Products_.name), "%" + name + "%"));
                }
                if (StringUtils.hasText(desc)) {
                    predicates.add(cb.like(root.get(Products_.desc), "%" + desc + "%"));
                }

                return cb.or(predicates.toArray(new javax.persistence.criteria.Predicate[predicates.size()]));

            }, pageable);
        } else {
            productPage = productRepository.findAll(pageable);
        }


        rs.setTotal(productPage.getTotalElements());
        rs.setTotalPage(productPage.getTotalPages());
        rs.setData(productPage.getContent().stream().map(Products::toModel).collect(Collectors.toList()));

        return rs;
    }

    public Products create(ProductForm form) {
        log.error("Create from : " + form);
        Products s = new Products();
        s.setName(form.getName());
        s.setDesc(form.getDesc());
        return productRepository.save(s);
    }




    public void delete(long id) {
        Products st = productRepository.findOne(id);
        productRepository.delete(st);
    }






    public ProductModel getProducts(Long id) {
        return productRepository.getOne(id).toModel();
    }
}
