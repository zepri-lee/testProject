package studio.thinkground.service;

import studio.thinkground.data.dto.ProductDto;

public interface ProductService {

  ProductDto saveProduct(String productId, String productName, int productPrice, int productStock);

  ProductDto getProduct(String productId);
}
