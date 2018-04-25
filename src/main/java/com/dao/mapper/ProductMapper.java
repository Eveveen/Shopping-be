package com.dao.mapper;

import org.springframework.stereotype.Repository;

import com.entity.Product;

@Repository
public interface ProductMapper {

	public int addProduct(Product product);
}
