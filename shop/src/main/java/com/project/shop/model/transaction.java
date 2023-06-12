package com.project.shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection = "transaction")
public class transaction {
    @Id
    private String tid;
    private String ordertype;
    private String itemname;
    private int quantity;

   /* public transaction(String ordertype, String itemname, int quantity) {
        this.ordertype = ordertype;
        this.itemname = itemname;
        this.quantity = quantity;
    }

    public transaction() {
    }

    public static String getId() {
        return id;
    }
    public static String getOrdertype() {
        return ordertype;
    }

    public static void setId(String id) {
        transaction.id = id;
    }

    public void setOrdertype(String ordertype) {
        this.ordertype = ordertype;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public static void setQuantity(int quantity) {
        transaction.quantity = quantity;
    }

    public String getItemname() {
        return itemname;
    }

    public static int getQuantity() {
        return quantity;*/

}
