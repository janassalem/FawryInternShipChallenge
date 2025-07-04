import  java.util.*;
public class Cart {
    private  List<CartItem> items = new ArrayList<>();

    public void add(Product product, int quantity){
        if(quantity > product.getQuantity()){
            throw new IllegalArgumentException("Not enough stock for " + product.getName());
        }
        items.add(new CartItem(product,quantity));
    }
    public List<CartItem> getItems(){
        return items ;
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }
}
