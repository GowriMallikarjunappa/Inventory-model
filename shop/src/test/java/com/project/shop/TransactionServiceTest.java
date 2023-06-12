package com.project.shop;

import com.project.shop.model.product;
import com.project.shop.model.transaction;
import com.project.shop.repository.transactionrepository;
import com.project.shop.service.transactionservice;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.project.shop.repository.shoprepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TransactionServiceTest {
	@InjectMocks
	private transactionservice transactionService;

	@Mock
	private transactionrepository transactionRepository;

	@Mock
	public shoprepository shopRepository;


	@Test
	public void testGetTid() {
		transaction transaction = new transaction();
		transaction.setTid("123");
		assertEquals("123", transaction.getTid());
	}
	@Test
	public void testSetTid() {
		transaction transaction = new transaction();
		transaction.setTid("123");
		assertEquals("123", transaction.getTid());
	}

	@Test
	public void testGetOrdertype() {
		transaction transaction = new transaction();
		transaction.setOrdertype("purchase");
		assertEquals("purchase", transaction.getOrdertype());
	}

	@Test
	public void testSetOrdertype() {
		transaction transaction = new transaction();
		transaction.setOrdertype("purchase");
		assertEquals("purchase", transaction.getOrdertype());
	}

	@Test
	public void testGetItemname() {
		transaction transaction = new transaction();
		transaction.setItemname("Product 1");
		assertEquals("Product 1", transaction.getItemname());
	}

	@Test
	public void testSetItemname() {
		transaction transaction = new transaction();
		transaction.setItemname("Product 1");
		assertEquals("Product 1", transaction.getItemname());
	}

	@Test
	public void testGetQuantity() {
		transaction transaction = new transaction();
		transaction.setQuantity(10);
		assertEquals(10, transaction.getQuantity());
	}

	@Test
	public void testSetQuantity() {
		transaction transaction = new transaction();
		transaction.setQuantity(10);
		assertEquals(10, transaction.getQuantity());
	}

	@Test
	public void testGetAllOrders() {
		// Mocking the repository method
		List<transaction> mockOrders = new ArrayList<>();
		when(transactionRepository.findAll()).thenReturn(mockOrders);

		// Call the service method
		List<transaction> result = transactionService.getAllOrders();

		// Assert the result
		assertEquals(mockOrders, result);
	}

	@Test
	public void testGetOrderById() {
		transaction mockOrder = new transaction();
		when(transactionRepository.findById("1")).thenReturn(Optional.of(mockOrder));
		transaction result = transactionService.getOrderById("1");
		assertEquals(mockOrder, result);
	}
	@Test
	public void testAddOrder() {
		transaction mockOrder = new transaction();
		when(transactionRepository.save(mockOrder)).thenReturn(mockOrder);
		transaction result = transactionService.addOrder(mockOrder);
		assertEquals(mockOrder, result);
	}
	@Test
	public void testTransactionQuantity_Purchase() {
		transaction mockTransaction = new transaction();
		mockTransaction.setItemname("Product 1");
		mockTransaction.setOrdertype("purchase");
		mockTransaction.setQuantity(10);
		product mockProduct = new product();
		mockProduct.setPname("Product 1");
		mockProduct.setQuantity(5);
		when(shopRepository.findBypname("Product 1")).thenReturn(Optional.of(mockProduct));
		transaction result = transactionService.transactionquantity(mockTransaction);
		assertEquals(15, mockProduct.getQuantity());
	}

	@Test
	public void testTransactionQuantity_Sale() {
		transaction mockTransaction = new transaction();
		mockTransaction.setItemname("Product 2");
		mockTransaction.setOrdertype("sale");
		mockTransaction.setQuantity(3);
		product mockProduct = new product();
		mockProduct.setPname("Product 2");
		mockProduct.setQuantity(5);
		when(shopRepository.findBypname("Product 2")).thenReturn(Optional.of(mockProduct));
		transaction result = transactionService.transactionquantity(mockTransaction);
		assertEquals(2, mockProduct.getQuantity());
	}
}


