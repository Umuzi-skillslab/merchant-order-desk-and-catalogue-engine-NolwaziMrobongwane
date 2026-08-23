package com.paynestsystem.test.java.com.paynestsystem.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class OrderTest {

@Test
void shouldCalculateOrderItemTotal() {

Product laptop = new Product(
1,
"Laptop",
new BigDecimal("12000.00")
);

OrderItem item = new OrderItem(laptop, 2);

assertEquals(
new BigDecimal("24000.00"),
item.calculateTotal()
);
}

@Test
void shouldCalculateGrandTotal() {

Customer customer = new Customer(
1,
"Nolwazi",
"nolwazi.mrobongwane@umuzi.org"
);

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

Order order = new Order(1001, customer);

order.addItem(laptop, 1);
order.addItem(mouse, 2);

assertEquals(
new BigDecimal("12500.00"),
order.calculateTotal()
);
}

@Test
void shouldReturnZeroForEmptyOrder() {

Customer customer = new Customer(
1,
"Nolwazi",
"nolwazi.mrobongwane@umuzi.org"
);

Order order = new Order(1001, customer);

assertEquals(
BigDecimal.ZERO,
order.calculateTotal()
);
}

@Test
void shouldRejectZeroQuantity() {

Product laptop = new Product(
1,
"Laptop",
new BigDecimal("12000.00")
);

assertThrows(
IllegalArgumentException.class,
() -> new OrderItem(laptop, 0)
);
}

@Test
void shouldRejectNegativeQuantity() {

Product laptop = new Product(
1,
"Laptop",
new BigDecimal("12000.00")
);

assertThrows(
IllegalArgumentException.class,
() -> new OrderItem(laptop, -1)
);
}

@Test
void shouldRejectNullProduct() {

assertThrows(
IllegalArgumentException.class,
() -> new OrderItem(null, 1)
);
}

@Test
void shouldRejectNullCustomer() {

assertThrows(
IllegalArgumentException.class,
() -> new Order(1001, null)
);
}
}