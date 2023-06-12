package com.project.shop.repository;
import com.project.shop.model.transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface transactionrepository extends MongoRepository<transaction,String> {

}
