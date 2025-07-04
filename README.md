# Fawry Quantum Internship Challenge – E-Commerce System

This is a Java-based mini e-commerce system built for the **Fawry Rise Full Stack Internship Challenge**. It handles product definition, cart logic, checkout operations, and shipping logic with well-structured OOP design.

---

##  Features

-  Product catalog with:
    - Name, price, and quantity
    - Expiry support (e.g. Cheese, Biscuits)
    - Shipping requirement and weight (e.g. TV, Cheese)
-  Customer with wallet/balance
-  Cart functionality
    - Quantity control
    - Stock validation
-  Checkout system:
    - Subtotal, shipping fees, total amount
    - Balance check
    - Expiry and stock validation
-  Shipping service:
    - Ships only `Shippable` items
    - Computes total package weight
    - Prints shipping receipt

---

##  System Design

### Key Classes & Interfaces:

- `Product` (abstract)
    - `ExpiringShippableProduct`
    - `NonExpiringShippableProduct`
    - `NonShippableProduct`

- `Shippable` (interface)
    - Enforces `getName()` and `getWeight()`

- `Cart`, `CartItem`
- `Customer`
- `Checkout` (static class)
- `ShippingService` (utility)

### Relationships:

- Products implement or extend behavior depending on expiry and shipping needs.
- `Checkout` identifies expired/out-of-stock items and checks balance.
- If items require shipping, they are collected and passed to `ShippingService`.

---

##  How to Run

1. Open project in **IntelliJ IDEA** or any Java IDE.
2. Make sure you're using **Java 17+** (tested with Java 21 / 24).
3. Run `Main.java`.


---

##  Sample Test Case "included in the Main"

```java
Product cheese = new ExpiringShippableProduct("Cheese", 100, 5, false, 0.2);
Product biscuits = new ExpiringShippableProduct("Biscuits", 150, 2, false, 0.7);
Product tv = new NonExpiringShippableProduct("TV", 1000, 3, 5.0);
Product scratchCard = new NonShippableProduct("ScratchCard", 50, 10, false);

Customer customer = new Customer("John", 1000);
Cart cart = new Cart();

cart.add(cheese, 2);
cart.add(biscuits, 1);
cart.add(scratchCard, 1);

Checkout.process(customer, cart);


