package com.project.shop;


import com.project.shop.controller.shopcontroller;
import com.project.shop.service.shopservice;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import com.project.shop.model.transaction;
import com.project.shop.repository.shoprepository;
import com.project.shop.repository.transactionrepository;
import com.project.shop.model.product;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.springframework.data.mongodb.core.aggregation.ConditionalOperators.Switch.CaseOperator.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class  productTests {
    private product product;

    @InjectMocks
    private shopcontroller productController;

    @Mock
    private shopservice productService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        product = new product();
    }

    @Test
    public void testGetId() {
        String expectedId = "1";
        product.setId(expectedId);
        String actualId = product.getId();
        assertEquals(expectedId, actualId);
    }

    @Test
    public void testSetId() {
        String expectedId = "2";
        product.setId(expectedId);
        String actualId = product.getId();
        assertEquals(expectedId, actualId);
    }

    @Test
    public void testGetPname() {
        String expectedPname = "Product Name";
        product.setPname(expectedPname);
        String actualPname = product.getPname();
        assertEquals(expectedPname, actualPname);
    }

    @Test
    public void testSetPname() {
        String expectedPname = "New Product Name";
        product.setPname(expectedPname);
        String actualPname = product.getPname();
        assertEquals(expectedPname, actualPname);
    }

    @Test
    public void testGetCategory() {
        String expectedCategory = "Category";
        product.setCategory(expectedCategory);
        String actualCategory = product.getCategory();
        assertEquals(expectedCategory, actualCategory);
    }

    @Test
    public void testSetCategory() {
        String expectedCategory = "New Category";
        product.setCategory(expectedCategory);
        String actualCategory = product.getCategory();
        assertEquals(expectedCategory, actualCategory);
    }

    @Test
    public void testGetPrice() {
        String expectedPrice = "10.0";
        product.setPrice(expectedPrice);
        String actualPrice = product.getPrice();
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void testSetPrice() {
        String expectedPrice = "20.0";
        product.setPrice(expectedPrice);
        String actualPrice = product.getPrice();
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void testGetQuantity() {
        int expectedQuantity = 1;
        product.setQuantity(expectedQuantity);
        int actualQuantity = product.getQuantity();
        assertEquals(expectedQuantity, actualQuantity);
    }

    @Test
    public void testSetQuantity() {
        int expectedQuantity = 2;
        product.setQuantity(expectedQuantity);
        int actualQuantity = product.getQuantity();
        assertEquals(expectedQuantity, actualQuantity);
    }

  @Test
        public void testGetProducts() throws Exception {
            // Mocking the service method
            product product1 = new product();
            product1.setPname("Product 1");
            product product2 = new product();
            product2.setPname("Product 2");
            List<product> mockProducts = Arrays.asList(product1, product2);
      OngoingStubbing<?> tOngoingStubbing = Mockito.when(productService.findAllproducts())
              .thenReturn(mockProducts);

  }

    @Test
    public void testGetProductById() throws Exception {
        // Mocking the service method
        product mockProduct = new product();

        mockMvc.perform(MockMvcRequestBuilders.get("/product/{id}", "123"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.id").exists());
    }
    @Test
    public void testFindProductByName() throws Exception {
        // Mocking the service method
        product mockProduct = new product();
        Optional<product> optionalProduct = Optional.of(mockProduct);


        // Perform the GET request
        ResultActions testProduct = mockMvc.perform(MockMvcRequestBuilders.get("/name/{pname}", "Test Product"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath(".id").exists());
    }



    }

