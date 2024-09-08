package Simple_Banking_system;
import java.util.ArrayList;

abstract class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Dish class inheriting from MenuItem
class Dish extends MenuItem {
    private String cuisineType;

    public Dish(String name, double price, String cuisineType) {
        super(name, price);
        this.cuisineType = cuisineType;
    }

    public String getCuisineType() {
        return cuisineType;
    }
}

// Drink class inheriting from MenuItem
class Drink extends MenuItem {
    private boolean isAlcoholic;

    public Drink(String name, double price, boolean isAlcoholic) {
        super(name, price);
        this.isAlcoholic = isAlcoholic;
    }

    public boolean isAlcoholic() {
        return isAlcoholic;
    }
}

// Menu class to hold Menu Items
class Menu {
    private ArrayList<MenuItem> items;

    public Menu() {
        items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void showMenu() {
        for (MenuItem item : items) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
    }

    public MenuItem getItem(int index) {
        return items.get(index);
    }
}

// Order class encapsulating order details
class Order {
    private ArrayList<MenuItem> orderItems;
    private double totalPrice;

    public Order() {
        orderItems = new ArrayList<>();
        totalPrice = 0.0;
    }

    public void addToOrder(MenuItem menuItem) {
        orderItems.add(menuItem);
        totalPrice += menuItem.getPrice();
    }

    public double calculateBill(BillingStrategy billingStrategy) {
        return billingStrategy.getBill(totalPrice);
    }
}

// Interface for different billing strategies (polymorphism)
interface BillingStrategy {
    double getBill(double totalPrice);
}

// Regular billing strategy
class RegularBilling implements BillingStrategy {
    @Override
    public double getBill(double totalPrice) {
        return totalPrice;
    }
}

// Discount billing strategy (e.g., 10% discount)
class DiscountBilling implements BillingStrategy {
    @Override
    public double getBill(double totalPrice) {
        return totalPrice * 0.9;
    }
}

// Tax billing strategy (e.g., 5% tax)
class TaxBilling implements BillingStrategy {
    @Override
    public double getBill(double totalPrice) {
        return totalPrice * 1.05;
    }
}

// Restaurant class
class Restaurant {
    private String name;
    private Menu menu;
    private ArrayList<Order> orders;

    public Restaurant(String name) {
        this.name = name;
        this.menu = new Menu();
        this.orders = new ArrayList<>();
    }

    public Menu getMenu() {
        return menu;
    }

    public void takeOrder(Order order) {
        orders.add(order);
    }

    public double generateBill(Order order, BillingStrategy billingStrategy) {
        return order.calculateBill(billingStrategy);
    }
}

// Main class to execute the program
public class SBS {
    public static void main(String[] args) {
        // Create a restaurant
        Restaurant restaurant = new Restaurant("Koushik's Diner");
        Menu menu = restaurant.getMenu();

        // Add items to the menu
        menu.addItem(new Dish("Pasta", 12.99, "Italian"));
        menu.addItem(new Drink("Coke", 2.99, false));

        // Show the menu
        menu.showMenu();

        // Create an order
        Order order = new Order();
        order.addToOrder(menu.getItem(0)); // Pasta
        order.addToOrder(menu.getItem(1)); // Coke

        // Restaurant takes the order
        restaurant.takeOrder(order);

        // Generate bill using different billing strategies
        double regularBill = restaurant.generateBill(order, new RegularBilling());
        System.out.println("Total Bill (Regular): $" + regularBill);

        double discountBill = restaurant.generateBill(order, new DiscountBilling());
        System.out.println("Total Bill (Discount): $" + discountBill);

        double taxBill = restaurant.generateBill(order, new TaxBilling());
        System.out.println("Total Bill (With Tax): $" + taxBill);
    }
}
