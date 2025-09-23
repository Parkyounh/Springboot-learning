package com.du.shoppingcart.controller;

import com.du.shoppingcart.service.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class ShoppingController {

    private final ShopService shopService;

    public ShoppingController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("products", shopService.getProducts());
        return "product_list";
    }

    @GetMapping("/cart")
    public String viewCart(Model model) {
        model.addAttribute("cartItems", shopService.getCartItems());
        return "cart";
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam Long productId, @RequestParam int quantity) {
        shopService.addToCart(productId, quantity);
        return "redirect:/";
    }
    @PostMapping("/cart/delete")
    public String shoppingCart(@RequestParam long cartItemId) {
        shopService.removeFromCart(cartItemId);
        return "redirect:/cart";
    }



}


