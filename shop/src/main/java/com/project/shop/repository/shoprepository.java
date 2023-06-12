package com.project.shop.repository;

import com.project.shop.model.product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface shoprepository extends MongoRepository<product,String> {


    Optional<product> findBypname(String pname);


}
