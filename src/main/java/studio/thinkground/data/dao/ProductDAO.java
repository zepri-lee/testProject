package studio.thinkground.data.dao;

import studio.thinkground.data.entity.Product;

public interface ProductDAO {

  Product saveProduct(Product product);

  Product getProduct(String productId);
}
