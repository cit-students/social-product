package com.cit.productsocial.controller;

import com.cit.productsocial.domain.Products;
import com.cit.productsocial.model.PagingObject;
import com.cit.productsocial.model.ProductForm;
import com.cit.productsocial.model.ProductModel;
import com.cit.productsocial.service.ProductService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = AbstractController.API_URL + "/products")
public class ProductController {

  private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public PagingObject<ProductModel> getAllProducts(Pageable pageable,
                                                     @RequestParam(required = false, defaultValue = "") String name,
                                                     @RequestParam(required = false, defaultValue = "") String desc) {
        return productService.getAllProducts(pageable, name, desc);
    }
    @GetMapping("/{id}")
    public ProductModel getStudent(@PathVariable Long id) {
        return productService.getProducts(id);
    }

    @PostMapping
    public Products create(@RequestBody ProductForm form) {
        return productService.create(form);
    }



    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        productService.delete(id);
    }

}
