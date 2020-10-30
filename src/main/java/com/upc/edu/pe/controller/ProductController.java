package com.upc.edu.pe.controller;


import com.upc.edu.pe.models.Pet;
import com.upc.edu.pe.models.Product;
import com.upc.edu.pe.resource.PetResource;
import com.upc.edu.pe.resource.ProductResource;
import com.upc.edu.pe.resource.save.SaveProductResource;
import com.upc.edu.pe.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/business/{businessId}/providers/{providerId}/products-type/{productTypeId}/products")
public class ProductController {
    @Autowired
    ModelMapper mapper;
    @Autowired
    ProductService productService;

  /*  @GetMapping
    public ResponseEntity<List<ProductResource>> getAllProducts(@PathVariable(name = "productTypeId")Long productTypeId,
                                                            Pageable pageable)
    {
        Page<Product> productPage=productService.getAllByProviderJoinTypeProductId(productTypeId,pageable);
        List<ProductResource> resources=productPage.getContent().stream().map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources,pageable,resources.size());
    }*/
   @GetMapping
    public ResponseEntity<List<ProductResource>> getAllProductsByProviderIdAndProductTypeId(
            @PathVariable(name = "providerId") Long providerId,
            @PathVariable(name="productTypeId")Long productTypeId){
        List<Product> products =productService.getAllProductsByProviderIdAndProductTypeId(providerId, productTypeId);
        List<ProductResource>  resources=products.stream().map(this::convertToResource).collect(Collectors.toList());
        return ResponseEntity.ok(resources);
    }

    @PostMapping
    public ProductResource registerProduct(@PathVariable(name = "businessId") Long businessId,
                                           @PathVariable(name = "providerId") Long providerId,
                                           @PathVariable(name = "productTypeId") Long productTypeId,
                                           @Valid @RequestBody SaveProductResource resource){
        return convertToResource(productService.createProduct(businessId,providerId, productTypeId,convertToEntity(resource)));
    }

   /* @GetMapping
    public ResponseEntity<List<ProductResource>> (@PathVariable("providerId") Long providerId,
                                                    @PathVariable("productTypeId")Long productTypeId){

    }*/

    private ProductResource convertToResource(Product entity) {
        return mapper.map(entity, ProductResource.class);
    }
    private Product convertToEntity(SaveProductResource resource) {
        return mapper.map(resource, Product.class);
    }
}
