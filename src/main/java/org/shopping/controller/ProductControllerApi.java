package org.shopping.controller;

import lombok.RequiredArgsConstructor;
import org.shopping.model.ProductResponse;
import org.shopping.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductControllerApi {

    private final ProductService productService;



    @GetMapping("/list")
    public List<ProductResponse> listItems(@RequestParam(required = false) String productId) {
        if(productId==null || productId.isEmpty()){
            return productService.getAllProducts();
        }else {
            return productService.findProductById(Long.parseLong(productId));
        }

    }

    @PostMapping("/add")
    public String addItems(@RequestBody ProductResponse product) {
        return productService.addProduct(product);
    }

    @GetMapping("/delete")
    public String deleteItems(@RequestParam String productId) throws Exception {
        return productService.deleteProductById(Long.parseLong(productId));
    }
}
