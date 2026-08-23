package com.paynestsystem.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.paynestsystem.domain.Customer;
import com.paynestsystem.domain.Order;
import com.paynestsystem.domain.Product;

public class ReceiptPrinterTest {

 private final ByteArrayOutputStream output =
 new ByteArrayOutputStream();

 private final PrintStream originalOutput =
 System.out;

 @BeforeEach
 void setUp() {
 System.setOut(new PrintStream(output));
 }

 @AfterEach
 void tearDown() {
 System.setOut(originalOutput);
 }

 @Test
 void shouldPrintReceiptWithCorrectContent() {

 Product laptop = new Product(
 1,
 "Laptop",
 new BigDecimal("12000.00")
 );

 Product mouse = new Product(
 2,
 "Mouse",
 new BigDecimal("250.00")
 );

 Customer customer = new Customer(
 1,
 "Nolwazi",
 "nolwazi.mrobongwane@umuzi.org"
 );

 Order order = new Order(1001, customer);

 order.addItem(laptop, 1);
 order.addItem(mouse, 2);

 ReceiptPrinter receiptPrinter =
 new ReceiptPrinter();

 receiptPrinter.printReceipt(order);

 String receipt = output.toString();

 assertTrue(receipt.contains("Order #: 1001"));
 assertTrue(receipt.contains("Customer: Nolwazi"));
 assertTrue(receipt.contains("Laptop x 1 = R12,000.00"));
 assertTrue(receipt.contains("Mouse x 2 = R500.00"));
 assertTrue(receipt.contains("Total: R12,500.00"));
 }
}