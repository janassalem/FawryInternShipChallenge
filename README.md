# Fawry Quantum Internship Challenge – E-Commerce System

This is a Java-based mini e-commerce system built for the **Fawry Rise Full Stack Internship Challenge**. It handles product definition, cart logic, checkout operations, and shipping logic with well-structured OOP design based on clean inheritance and interface segregation.

---

##  Features

-  Product catalog with:
    - Name, price, and quantity
    - **Expiry support** via `Expirable` interface (e.g. Cheese, Biscuits)
    - **Shipping requirement and weight** via `Shippable` interface (e.g. TV, Cheese)
-  Customer with wallet/balance
-  Cart functionality:
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

###  Key Classes & Interfaces:

#### Abstract Class:
- `Product`
    - Common fields: `name`, `price`, `quantity`
    - Abstract method: `requiresShipping()`

#### Interfaces:
- `Shippable`
    - `getName()`, `getWeight()`
- `Expirable`
    - `isExpired()`

#### Implementing Product Variants:
- `ExpiringShippableProduct`  
  → implements both `Shippable` & `Expirable`
- `NonExpiringShippableProduct`  
  → implements only `Shippable`
- `NonShippableProduct`  
  → optionally implements `Expirable`

#### Other Core Classes:
- `Cart`, `CartItem` – holds products & quantities
- `Customer` – holds balance
- `Checkout` – handles all validations, totals, and payments
- `ShippingService` – processes shipping for `Shippable` items

---

##  Relationships & Logic Flow

- Products may implement:
    - `Shippable` → if they require delivery
    - `Expirable` → if they can expire
- `Checkout.process(...)`:
    - Validates quantity, expiry, balance
    - Deducts stock and customer balance
    - Invokes `ShippingService` if needed
- `ShippingService`:
    - Accepts `List<Shippable>`
    - Displays item weights and total package weight

---

##  How to Run

1. Open the project in **IntelliJ IDEA** or any Java IDE.
2. Ensure Java 17+ is installed (**tested with Java 21 & 24**).
3. Run the `Main.java` file directly.

---

##  Sample Test Case (included in `Main.java`)

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
```

##  Sample OutPut

```java

** Shipment notice **
1x Cheese        200g
1x Cheese        200g
1x Biscuits      700g
Total package weight 1.1kg

** Checkout receipt **
2x Cheese        200
1x Biscuits      150
1x ScratchCard   50
----------------------
Subtotal         400
Shipping         30
Amount           430
Balance left     570
```