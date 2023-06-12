package com.project.shop.service;

import com.project.shop.model.product;
import com.project.shop.repository.shoprepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class shopservice {
    @Autowired
    private shoprepository repository;
     public product addproduct(product pro){
         pro.setId(UUID.randomUUID().toString().split("-")[0]);
    return repository.save(pro);
     }
     public List<product> findAllproducts(){
      return  repository.findAll();
     }
    public product  getprodbyid(String id){
         return repository.findById(id).get();

    }
    public Optional<product> getproductbyname(String pname)
    {
       return repository.findBypname(pname);

    }

    public product updateproduct(String id,product prodrequest){
        // for(int i=0;i<product.size();i++) {
            // product p= product.get(i);
        // if(existingprod.equals(product.getId()).get()) {
        /*product existingprod = repository.findById(prodrequest.getId()).get();
        String s=existingprod.getId();
        if(s.equals(id)){
        existingprod.setPrice(prodrequest.getPrice());
         existingprod.setCategory(prodrequest.getCategory()*/
        Optional<product> optional=repository.findById(id);
        product pro =optional.get();
        pro.setQuantity(prodrequest.getQuantity());
     return repository.save(pro);
     }
    public String deleteprod(String id)
    {
        repository.deleteById(id);
        return " producted deleted";
    }
}
