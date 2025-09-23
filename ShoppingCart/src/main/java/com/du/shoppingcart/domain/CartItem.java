package com.du.shoppingcart.domain;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    private long id;
    private long productId;
    private int quantity;
    private Products product;
}
