package com.du.shoppingcart.service;

import com.du.shoppingcart.domain.CartItem;
import com.du.shoppingcart.domain.Products;

import java.util.List;

public interface ShopService {
    List<Products> getProducts();
    List<CartItem> getCartItems();

    void addToCart(Long productId, int quantity);
    void removeFromCart(Long cartItemId);
}
