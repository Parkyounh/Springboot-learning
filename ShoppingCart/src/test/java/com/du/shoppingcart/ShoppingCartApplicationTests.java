package com.du.shoppingcart;

import com.du.shoppingcart.dao.ProductsMapper;
import com.du.shoppingcart.domain.Products;
import com.du.shoppingcart.service.impl.ShopServiceImpl;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ShoppingCartApplicationTests {

    @Autowired
    ProductsMapper productsMapper;

    @Test
    void contextLoads() {
        List<Products> list = productsMapper.getProducts();
        for (Products p : list) {
            System.out.println(p);
        }
        Products product = productsMapper.getProduct(1);
        System.out.println(product);



    }

}
