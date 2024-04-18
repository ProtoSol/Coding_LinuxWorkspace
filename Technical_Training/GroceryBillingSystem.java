import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GroceryBillingSystem {
    public static void main(String[] args) {
        Map<String, Double> groceryItems = new HashMap<>();
        groceryItems.put("Apple", 0.50);
        groceryItems.put("Banana", 0.25);
        groceryItems.put("Orange", 0.30);
        groceryItems.put("Peach", 0.75);
        groceryItems.put("Pear", 0.60);
        groceryItems.put("Grapes", 1.00);
        groceryItems.put("Watermelon", 1.50);
        groceryItems.put("Pineapple", 1.25);
        groceryItems.put("Mango", 1.00);
        groceryItems.put("Avocado", 0.75);
        groceryItems.put("Tomato", 0.50);
        groceryItems.put("Cucumber", 0.75);
        groceryItems.put("Lettuce", 1.00);
        groceryItems.put("Onion", 0.50);
        groceryItems.put("Potato", 0.75);
        groceryItems.put("Bread", 1.50);
        groceryItems.put("Milk", 2.00);
        groceryItems.put("Eggs", 2.50);
        groceryItems.put("Butter", 2.00);
        groceryItems.put("Cheese", 3.00);

        Scanner scanner = new Scanner(System.in);

        String[] purchasedItems = new String[20];
        int purchasedItemCount = 0;

        System.out.println("Enter the names of the items you have purchased (type 'done' to finish):");
        String input;
        do {
            System.out.print("Item: ");
            input = scanner.nextLine();
            if (!input.equalsIgnoreCase("done")) {
                if (groceryItems.containsKey(input)) {
                    purchasedItems[purchasedItemCount++] = input;
                } else {
                    System.out.println("Error: Item '" + input + "' not found in the store.");
                }
            }
        } while (!input.equalsIgnoreCase("done"));

        double totalBill = 0;
        for (int i = 0; i < purchasedItemCount; i++) {
            double price = groceryItems.get(purchasedItems[i]);
            totalBill += price;
        }

        System.out.println("\nYour bill:");
        for (int i = 0; i < purchasedItemCount; i++) {
            System.out.println(purchasedItems[i] + ": $" + groceryItems.get(purchasedItems[i]));
        }
        System.out.println("Total: $" + totalBill);
    }
}
