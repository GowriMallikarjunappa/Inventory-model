package com.project.shop.controller;

import com.project.shop.model.product;
import com.project.shop.service.shopservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.AggregationExpression;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class shopcontroller {
    @Autowired
    private shopservice service;
@PostMapping("/addproduct")
@ResponseStatus(value = HttpStatus.CREATED)
    public product createproduct(@RequestBody product pro){
    return service.addproduct(pro);}
    @GetMapping("/allproducts")
    public List<product> getproducts(){
    return service.findAllproducts();
    }
    @GetMapping("/product/{id}")
    public product gettask(String id){
        return (product) service.getprodbyid(id);
    }
    @GetMapping("/name/{pname}")
    public AggregationExpression findproductbyname(@PathVariable String pname)
    {

        return service.getproductbyname(pname);
    }
    @PutMapping("/modifyproduct/{id}")
public product modifyproduct( @PathVariable String id,@RequestBody product prod)
    {

        return service.updateproduct(id, prod);
    }
    @DeleteMapping("/{id}")
    public String deleteproduct(@PathVariable String id)
    {
        return service.deleteprod(id);
    }
}
