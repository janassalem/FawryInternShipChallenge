public class Customer {
    public String name;
    public double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public  boolean canAfford(double amount){
        return balance >= amount;
    }

    public void deduct(double amount){
        balance -= amount;
    }

    public void add(double amount){
        balance += amount;
    }

    public String toString(){
        return name + " has a balance of " + balance;
    }

    public static void main(String[] args){
        Customer c = new Customer("John", 100);
        System.out.println(c);
        c.deduct(50);
        System.out.println(c);
        c.add(20);
        System.out.println(c);
    }

    // TODO: add a method that checks if a customer can afford an amount
    // TODO: add a method that deducts an amount from a customer's balance
    // TODO: add a method that adds an amount to a customer's balance
    // TODO: add a toString method that returns a string representation of a customer
    // TODO: add a main method that tests the above methods
    // TODO: add a method that checks if a customer

}
