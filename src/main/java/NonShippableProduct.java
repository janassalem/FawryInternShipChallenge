public abstract class NonShippableProduct extends Product implements Shippable {
    private boolean expired;

    public NonShippableProduct(String name, double price, int quantity, boolean expired) {
        super(name, price, quantity);
        this.expired = expired;
    }

    @Override
    public boolean isExpired() {
        return expired;
    }

    @Override
    public boolean requiresShipping() {
        return false;
    }


}