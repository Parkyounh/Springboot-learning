package com.du.shoppingcart.dao;

import com.du.shoppingcart.domain.Products;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductsMapper {

    @Select("select * from products")
    public List<Products> getProducts();

    @Select("select * from products where id = #{id}")
    public Products getProduct(long id);
}
