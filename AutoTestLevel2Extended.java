
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

// Class to represent individual items in the shopping basket
class Item {
    String name;
    double price;
    int quantity;
    double discount;

    // Constructor for an item with default quantity and discount
    Item(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 1; // Default quantity is 1
        this.discount = 0; // Default discount is 0
    }

    // Constructor for an item with specified quantity and discount
    Item(String name, double price, int quantity, double discount) {
        this.name = name;
        this.price = price;
        this.quantity = quantity > 0 ? quantity : 1; // Ensure quantity is at least 1
        this.discount = (discount >= 0 && discount <= 1) ? discount : 0; // Ensure discount is between 0 and 1
    }

    // Calculate the cost of the item, considering quantity and discount
    double calculateItemCost() {
        double discountedPrice = price * (1 - discount);
        return discountedPrice * quantity;
    }

    // String representation of the item
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#0.00");
        StringBuilder sb = new StringBuilder("Item: " + name + ", price: " + df.format(price) + " pounds");
        if (quantity > 1) {
            sb.append(", quantity: ").append(quantity);
        }
        if (discount > 0) {
            sb.append(", discount: ").append((int) (discount * 100)).append("%");
        }
        return sb.toString();
    }
}

// Class to represent a shopping basket
 class Basket {
    private int basketID;
    private double voucher;
    private List<Item> items;

    // Constructor for a basket with a given ID (Level 1)
    Basket(int basketID) {
        this.basketID = basketID;
        this.voucher = 0; // Default voucher is 0
        this.items = new ArrayList<>(); // Initialize the list of items
    }

    // Constructor for a basket with a given ID and voucher (Level 3)
    Basket(int basketID, double voucher) {
        this.basketID = basketID;
        this.voucher = (voucher >= 0 && voucher <= 1) ? voucher : 0; // Ensure voucher is between 0 and 1
        this.items = new ArrayList<>(); // Initialize the list of items
    }

    // Add an item to the basket with default quantity and discount (Level 1)
    public void addItem(String name, double price) {
        Item item = new Item(name, price);
        addItemToBasket(item);
    }

    // Add an item to the basket with specified quantity and discount (Level 3)
    public void addItem(String name, double price, int quantity, double discount) {
        Item newItem = new Item(name, price, quantity, discount);
        addItemToBasket(newItem);
    }

    // Helper method to add an item to the basket or update its quantity and discount (Level 3)
    private void addItemToBasket(Item newItem) {
        boolean itemExists = false;
        for (Item existingItem : items) {
            if (existingItem.name.equalsIgnoreCase(newItem.name) && existingItem.price == newItem.price) {
                existingItem.quantity += newItem.quantity;
                if (newItem.discount > existingItem.discount) {
                    existingItem.discount = newItem.discount;
                }
                itemExists = true;
                break;
            }
        }
        if (!itemExists) {
            items.add(newItem);
        }
    }

    // Find and return a string representation of an item in the basket (Level 2)
    public String findAnItem(String name, double price) {
        for (Item item : items) {
            if (item.name.equalsIgnoreCase(name) && item.price == price) {
                return item.toString();
            }
        }
        return null;
    }

    // Find and return the string representation of the cheapest item in the basket (Level 2)
    public String cheapestItem() {
        if (items.isEmpty()) {
            return null;
        }
        Item cheapest = items.get(0);
        for (Item item : items) {
            if (item.price < cheapest.price) {
                cheapest = item;
            }
        }
        return cheapest.toString();
    }

    // Find and return the string representation of the most expensive item in the basket (Level 2)
    public String mostExpensiveItem() {
        if (items.isEmpty()) {
            return null;
        }
        Item mostExpensive = items.get(0);
        for (Item item : items) {
            if (item.price > mostExpensive.price) {
                mostExpensive = item;
            }
        }
        return mostExpensive.toString();
    }

    // Calculate and return the total cost of the items in the basket (Level 1)
    public double totalBasket() {
        double totalCost = 0;
        for (Item item : items) {
            totalCost += item.calculateItemCost();
        }
        return totalCost;
    }

    // String representation of the basket, including items, voucher, and total cost (Level 1 and Level 3)
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#0.00");
        StringBuilder sb = new StringBuilder("Basket " + basketID + " has the following items:\n");

        double totalCost = 0;

        for (Item item : items) {
            if (item.price > 0) {
                totalCost += item.calculateItemCost();
                sb.append(item.toString()).append("\n");
            }
        }

        if (voucher > 0 && totalCost > 0) {
            double voucherDiscount = totalCost * voucher;
            totalCost -= voucherDiscount;
            sb.append("Voucher applied: ").append((int) (voucher * 100)).append("%\n");
        }

        if (totalCost < 0) {
            totalCost = 0;
        }

        sb.append("Total cost: ").append(df.format(totalCost)).append(" pounds\n");

        return sb.toString();
    }
}

public class AutoTestLevel2Extended {
    public static void main(String[] args) {
        Basket basket1 = new Basket(1234);
        basket1.addItem("bread", 0.95);
        basket1.addItem("ham", 2.15);
        basket1.addItem("pear", 1.09);
        basket1.addItem("tomato", 0.78);
        basket1.addItem("cucumber", 0.75);
        basket1.addItem("milk", 1.05);
        basket1.addItem("muffin", 1.62);

        System.out.print(basket1.toString());
        System.out.println("========== test findAnItem =================");
        System.out.print(basket1.findAnItem("pear", 0.95));
        System.out.println();
        System.out.print(basket1.findAnItem("pear", 1.09));
        System.out.println();
        System.out.print(basket1.findAnItem("PEAR", 1.09));
        System.out.println();
		System.out.print(basket1.findAnItem("pear", 2.99));
        System.out.println();
        System.out.println("========== test cheapestItem ===============");
        System.out.print(basket1.cheapestItem());
        System.out.println();
        System.out.println("========== test mostExpensiveItem ==========");
        System.out.print(basket1.mostExpensiveItem());
        System.out.println();
        
        System.out.println();
        System.out.println("============================================");
        System.out.println();

        Basket basket2 = new Basket(36905);
		
		System.out.print(basket2.toString());
		System.out.println("========== test cheapestItem ===============");
        System.out.print(basket2.cheapestItem());
        System.out.println();
        System.out.println("========== test mostExpensiveItem ==========");
        System.out.println(basket2.mostExpensiveItem());
        System.out.println();
		
        basket2.addItem("red t-shirt", 14.9);
        basket2.addItem("black dress", 25.29);
        basket2.addItem("white skirt", 19.85);
        basket2.addItem("ivory coat", 78.99);
        basket2.addItem("black boots", 45.28);
        basket2.addItem("red scarf", 10.99);
        basket2.addItem("navy handbag", 22.22);

        System.out.print(basket2.toString());
        System.out.println("========== test findAnItem =================");
        System.out.print(basket2.findAnItem("white skirt", 14.95));
        System.out.println();
        System.out.print(basket2.findAnItem("white skirt", 19.85));
        System.out.println();
        System.out.print(basket2.findAnItem("White Skirt", 19.85));
        System.out.println();
        System.out.println("========== test cheapestItem ===============");
        System.out.print(basket2.cheapestItem());
        System.out.println();
        System.out.println("========== test mostExpensiveItem ==========");
        System.out.print(basket2.mostExpensiveItem());
        System.out.println();
    }
}
