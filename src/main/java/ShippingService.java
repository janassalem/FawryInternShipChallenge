import  java.util.List;


public class ShippingService {
    public static  void ship(List<Shippable> items){
        System.out.println("** Shipment notice **");
        double totalWeight =0.0;
        for( Shippable item : items ){
            double w = item.getWeight();
            System.out.printf("1x %s\t\t%.0fg%n", item.getName(), w * 1000);
            totalWeight += w;
        }
        System.out.printf("Total package weight %.1fkg%n%n", totalWeight);
    }
}
