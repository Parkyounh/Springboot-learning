package com.du.shoppingcart.service.impl;

import com.du.shoppingcart.dao.CartMapper;
import com.du.shoppingcart.dao.ProductsMapper;
import com.du.shoppingcart.domain.CartItem;
import com.du.shoppingcart.domain.Products;
import com.du.shoppingcart.service.ShopService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService{

    private final CartMapper cartMapper;
    private final ProductsMapper productsMapper;

    public ShopServiceImpl(CartMapper cartMapper, ProductsMapper productsMapper) {
        this.cartMapper = cartMapper;
        this.productsMapper = productsMapper;
    }

    @Override
    public List<Products> getProducts() {
        return productsMapper.getProducts();
    }

    @Override
    public List<CartItem> getCartItems() {
        return cartMapper.findAll();
    }

    @Override
    public void addToCart(Long productId, int quantity) {
        CartItem cartItem = new CartItem();
        cartItem.setProductId(productId);
        cartItem.setQuantity(quantity);

        cartMapper.insert(cartItem);
    }

    @Override
    public void removeFromCart(Long cartItemId) {
        cartMapper.delete(cartItemId);
    }
}
