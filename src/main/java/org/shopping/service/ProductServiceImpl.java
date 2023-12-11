package org.shopping.service;

import lombok.RequiredArgsConstructor;
import org.shopping.model.ProductResponse;
import org.shopping.model.Product;
import org.shopping.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public List<ProductResponse> getAllProducts() {
       List<Product> products = productRepository.findAll();
       List<ProductResponse> responseList = new ArrayList<>();
       if(!CollectionUtils.isEmpty(products)){
           responseList =  products.stream().map(ProductResponse::new)
                   .collect(Collectors.toList());
       }
       return responseList;
    }

    @Override
    public List<ProductResponse> findProductById(long productId) {
        List<ProductResponse> responseList = new ArrayList<>();
        Product product = productRepository.findById(productId)
                .orElseThrow();
        if(product !=null){
            responseList.add(new ProductResponse(product));
            return responseList;
        }
        return null;
    }

    @Override
    public String addProduct( ProductResponse product) {
        Product productObj = new Product()
                .setProductName(product.getProductName())
                .setQuantity(product.getQuantity())
                .setPrice(product.getPrice());
        productObj =productRepository.save(productObj);

        if(productObj !=null){
            return "Product Added Successfully";
        }else{
            return "Product Not Added Successfully";
        }

    }

    @Override
    public String deleteProductById(long productId) throws Exception {
        if(productId == 0)
            throw new Exception("Product cannot be null");

        productRepository.deleteById(productId);
        return "Product deleted successfully";
    }
}
