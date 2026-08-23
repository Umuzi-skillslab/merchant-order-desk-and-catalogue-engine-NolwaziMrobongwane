# PayNest Merchant Order Desk and Catalogue Engine

## Project Description

PayNest is a simple Java application for managing customers, products and orders.

The application allows a customer to place an order containing one or more products. Each product is represented by an OrderItem, which stores the product and quantity purchased.

The application calculates individual item totals and the overall order total and can print a formatted receipt.

## Project Structure

The application uses a simple object-oriented design:

- `Customer` stores customer information.
- `Product` stores catalogue product information.
- `OrderItem` represents a product and its quantity in an order.
- `Order` represents a customer's order and calculates the order total.
- `OrderService` provides order-related service operations.
- `ReceiptPrinter` is responsible for displaying the receipt.
- `PayNestApplication` contains the application's entry point.

## Business Rules

1. Customer IDs must be positive.
2. Customer names cannot be empty.
3. Customer email addresses cannot be empty.
4. Product IDs must be positive.
5. Product names cannot be empty.
6. Product prices cannot be negative.
7. An Order requires a customer.
8. Order IDs must be positive.
9. Product quantities must be greater than zero.
10. A product cannot be null when adding an item to an order.
11. An empty order has a total of R0.00.
12. Money is represented using `BigDecimal` to avoid floating-point calculation problems.
13. South African Rand currency formatting is used for receipts.

## Design Decisions

### BigDecimal for Money

`BigDecimal` is used instead of `double` for monetary values because financial calculations require accurate decimal arithmetic.

### Encapsulation

The fields in the domain classes are private and accessed through methods.

The order item collection is exposed as an unmodifiable list so that external code cannot directly modify the internal collection.

### Separation of Responsibilities

The domain classes are responsible for representing and calculating business data.

`ReceiptPrinter` is responsible for presentation of the receipt rather than placing console output inside the domain model.

This separation makes the application easier to maintain and extend.

### Extending the Catalogue

Products are represented as separate objects rather than being hard-coded into the Order class.

This means additional products can be added to the catalogue without changing the Order structure.

## How to Build

From the project root, run:

```bash
mvn clean test