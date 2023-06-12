package com.project.shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class product {
@Id
    private String id;
    private String pname;
    private String category;
    private String price;
    private int quantity;

    public static int size() {
        int n =product.size();
        return n;
    }



}
