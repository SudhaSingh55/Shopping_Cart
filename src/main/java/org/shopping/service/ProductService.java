package org.shopping.service;

import org.shopping.model.Product;
import org.shopping.model.ProductResponse;

import java.util.List;

public interface ProductService {

    public List<ProductResponse> getAllProducts();
    public List<ProductResponse> findProductById(long productId);

    public String addProduct( ProductResponse product);

    public String deleteProductById(long productId) throws Exception;
}
