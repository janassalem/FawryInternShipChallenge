// Main.java (Test Runner)
public class Main {
    public static void main(String[] args) {
        Product cheese = new ExpiringShippableProduct("Cheese", 100, 5, false, 0.2);
        Product biscuits = new ExpiringShippableProduct("Biscuits", 150, 2, false, 0.7);
        Product tv = new NonExpiringShippableProduct("TV", 1000, 3, 5.0);
        Product scratchCard = new NonShippableProduct("ScratchCard", 50, 10, false) {
            @Override
            public double getWeight() {
                return 0;
            }
        };

        Customer customer = new Customer("Jana Salem", 4000);
        Cart cart = new Cart();

        cart.add(cheese, 2);
        cart.add(tv, 3);
        cart.add(biscuits, 1);

        cart.add(scratchCard, 1);

        Checkout.process(customer, cart);
    }
}
