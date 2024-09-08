
# Restaurant Management System


A Simple Restaurant Management System is a software application designed to streamline and automate various tasks in a restaurant, such as managing the menu, taking customer orders, and generating bills.


## Description
This Java code implements a Simple Restaurant Management System. The system allows for the creation of menu items, placing customer orders, and calculating bills using different billing strategies (regular, discounted, or with tax).

The system simulates basic restaurant operations like managing a menu, placing orders, and generating bills. It uses the Strategy Design Pattern to apply flexible billing options (regular, discount, or tax) and manages different types of menu items (dishes and drinks). This modular structure allows for easy expansion and customization of billing methods and menu management.
## Technology used
Language Used:
The code is written in Java, an object-oriented programming language known for its platform independence and wide use in enterprise-level applications.

Algorithms and Design Patterns Used:
Strategy Design Pattern:

The Strategy Design Pattern is the key design technique used in this program. The BillingStrategy interface and its implementations (RegularBilling, DiscountBilling, TaxBilling) allow the system to apply different strategies to calculate the final bill dynamically, without altering the core logic of the Order or Restaurant classes.
Array List Manipulation:

The program uses ArrayList to store both the menu items and the order items. Basic array operations like adding an element (addItem, addToOrder) and iterating through the list (showMenu) are employed.
Summation Algorithm:

The code includes a simple summation algorithm to compute the total price of an order. Every time an item is added to an order, its price is added to the running total (totalPrice += menuItem.getPrice()).
Polymorphism:

The MenuItem class is abstract, and its two subclasses (Dish and Drink) utilize polymorphism to provide flexibility in handling different types of menu items. Methods in the Menu and Order classes handle MenuItem objects without needing to know whether they are Dish or Drink.
Basic Arithmetic (Percentage Calculation):

For DiscountBilling, a 10% discount is calculated by multiplying the total price by 0.9 (totalPrice * 0.9).
For TaxBilling, a 5% tax is calculated by multiplying the total price by 1.05 (totalPrice * 1.05).

These algorithms and patterns make the system flexible, scalable, and easy to extend.







