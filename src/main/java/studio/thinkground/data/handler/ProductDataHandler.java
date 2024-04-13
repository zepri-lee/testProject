package studio.thinkground.data.handler;

import studio.thinkground.data.entity.Product;

public interface ProductDataHandler {

  Product saveProductEntity(
      String productId, String productName, int productPrice, int productStock);

  Product getProductEntity(String productId);
}
