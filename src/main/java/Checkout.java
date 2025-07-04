// Checkout.java
import java.util.*;

public class Checkout {
    public static void process(Customer customer, Cart cart) {
        if (cart.isEmpty()) throw new RuntimeException("Your cart is empty!");

        List<CartItem> items = cart.getItems();
        double subtotal = 0.0;
        List<Shippable> shippableItems = new ArrayList<>();

        for (CartItem item : items) {
            if (item.product.isExpired()) {
                throw new RuntimeException(item.product.getName() + " has expired!");
            }
            if (item.quantity > item.product.getQuantity()) {
                throw new RuntimeException("Insufficient stock for " + item.product.getName());
            }

            subtotal += item.getTotalPrice();
            if (item.product.requiresShipping() && item.product instanceof Shippable) {
                for (int i = 0; i < item.quantity; i++) {
                    shippableItems.add((Shippable) item.product);
                }
            }
        }

        double shipping = shippableItems.isEmpty() ? 0.0 : 30.0;
        double total = subtotal + shipping;

        if (!customer.canAfford(total)) {
            throw new RuntimeException("Insufficient balance! Please Check Your Wallet and Try Again");
        }

        for (CartItem item : items) {
            item.product.reduceQuantity(item.quantity);
        }

        customer.deduct(total);

        if (!shippableItems.isEmpty()) {
            ShippingService.ship(shippableItems);
        }

        System.out.println("** Checkout receipt **");
        for (CartItem item : items) {
            System.out.printf("%dx %s\t\t%.0f%n", item.quantity, item.product.getName(), item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal\t%.0f%n", subtotal);
        System.out.printf("Shipping\t%.0f%n", shipping);
        System.out.printf("Amount\t\t%.0f%n", total);
        System.out.printf("Balance left\t%.0f%n", customer.balance);
    }
}
