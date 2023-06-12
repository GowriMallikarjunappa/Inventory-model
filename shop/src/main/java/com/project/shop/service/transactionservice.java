package com.project.shop.service;

import com.project.shop.model.transaction;
import com.project.shop.repository.shoprepository;
import com.project.shop.repository.transactionrepository;
import com.project.shop.model.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class transactionservice {
    @Autowired
    private transactionrepository repository;

    @Autowired
    private shoprepository srepository;

    private product prod;
    //ArrayList<product> prodList = srepository.getPname();

    public List<transaction> getAllOrders() {

        return repository.findAll();
    }

    public transaction getOrderById(String id) {
        return repository.findById(id).get();
    }

    public transaction addOrder(transaction transact) {
        transact.setTid(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(transact);
    }

//    public transaction transactionquantity(transaction transact, String name) {
//        //String tid = transact.getTid();
//        int transactionquantity = transact.getQuantity();
//        String Ordertype = transact.getOrdertype();
//
//       // String pname = prod.getPname();
////        for(int i=0;i<product.size();i++)
//        String pname=prod.getPname();
//            if (pname.equals(name)) {
//                if (Ordertype.equals("purchase")) {
//                    prod.setQuantity(Integer.parseInt(String.valueOf(prod.getQuantity() + transactionquantity)));
//                    srepository.save(prod);
//                } else if (Ordertype.equals("sale")) {
//                    prod.setQuantity(prod.getQuantity() - transactionquantity);
//                    srepository.save(prod);
//                }
//
//            }
//        }
//        return repository.save(transact);
 //   }

      public transaction transactionquantity(transaction transact) {
        String orderName = transact.getItemname();
        String orderType = transact.getOrdertype();
        Integer quantity = transact.getQuantity();
        prod = srepository.findBypname(orderName).get();
          if(orderType.equals("purchase")){
              prod.setQuantity(Integer.parseInt(String.valueOf(prod.getQuantity()+quantity)));
              srepository.save(prod);
          }
          else if (orderType.equals("sale") && quantity < prod.getQuantity())
          {
              prod.setQuantity(prod.getQuantity()-quantity);
              srepository.save(prod);
          }
          return repository.save(transact);
      }


   /* public transaction transactionquantity(transaction transact,String ordertype ) {
        int transactionquantity = transact.getQuantity();
        if(ordertype.equals("purchase")){
            prod.setQuantity(Integer.parseInt(String.valueOf(prod.getQuantity()+transactionquantity)));
            srepository.save(prod);
        }
        else if (ordertype.equals("sale"))
        {
            prod.setQuantity(prod.getQuantity()-transactionquantity);
            srepository.save(prod);
        }
        return repository.save(transact);
    }*/

}