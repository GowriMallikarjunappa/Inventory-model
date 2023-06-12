package com.project.shop.controller;

import com.project.shop.model.transaction;
import com.project.shop.service.transactionservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class transactioncontroller {
        @Autowired
        transactionservice tservice;
        @GetMapping("/alldetailsoforders")
        public List<transaction> findAllOrders(){

                return tservice.getAllOrders();
                }
        @GetMapping("/{id}")
        public transaction findOrderById(@PathVariable String id){

                return tservice.getOrderById(id);
        }

        @PostMapping("/addorders")
        public transaction addOrder(@RequestBody transaction transact)
        {
                        return tservice.addOrder(transact);
                }
        @PostMapping("/leftover")
        public transaction transactionquantity(@RequestBody transaction transact){
                return tservice.transactionquantity(transact);
        }
        }

