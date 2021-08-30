/*
 * GroceryBilljava
 * @author Letitia Fickling
 * @since 3/9/20
 * This class inputs grocery items and their costs and generates a bill detailing the items, their costs, any sale pricing, and total ammounts
 */
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class GroceryBill {

    private static Scanner scanner = new Scanner(System.in);
    public int numberOfGroceries;
    public double totalPreTaxCost;
    public double amountSaved;
    public static List<GroceryItem> items = new ArrayList<>();

    //constructor imputs string @newITemName double@newItemPrice boolean @isThisOnSale
    public GroceryBill () {
        numberOfGroceries = 0;
        totalPreTaxCost = 0;
        double newItemPrice;
        boolean anotherItem = true;
        while (anotherItem) {
            System.out.print("Enter the name of an item: ");
            String newItemName = scanner.next();
            System.out.print("Enter the cost of the item: $");
            newItemPrice = scanner.nextDouble();
            System.out.print("Is the item on sale? (y/n): ");
            String isThisOnSale = scanner.next();
            boolean itemOnSale;
            if (isThisOnSale.equals("y")) {
                itemOnSale = true;
            }
            else {
                itemOnSale = false;
            }
            GroceryItem newItem = new GroceryItem(newItemName, newItemPrice, itemOnSale);
            addGroceryItem(newItem);
            numberOfGroceries++; //increases grocery item count
            if (itemOnSale) { //adds up total cost whether an item is on sale or not
                double newSalePrice = newItemPrice * 0.80;
                double newAmountSaved = newItemPrice * 0.20;
                totalPreTaxCost += newSalePrice;
                amountSaved += newAmountSaved;
            }
            else {
                totalPreTaxCost += newItemPrice;
            }
            System.out.print("\nDo you have more items? (y/n): ");
            String moreItems = scanner.next();
            System.out.println(" ");
            if (moreItems.equals("n")) {
                anotherItem = false;
            }
        }
    }

    //subclass GroceryItem
    public class GroceryItem {
        String itemName;
        double itemPrice;
        boolean isItOnSale;

        public GroceryItem(String itemName, double itemPrice, boolean isItOnSale) {
            this.itemName = itemName;
            this.itemPrice = itemPrice;
            this.isItOnSale = isItOnSale;
        }
    }

    public void addGroceryItem(GroceryItem item) {
        items.add(item);
    }
    public static void clearItemsList() {
        items.clear();
    }

    //prints the report
    public void printReport() {
        Iterator itr=items.iterator(); //iterator for items arraylist
        System.out.println("\n\nGrocery Bill \n\nPurchases");
        while(itr.hasNext()){ //goes through all the items in the arraylist items
            GroceryItem itm =(GroceryItem)itr.next();
            if (itm.isItOnSale) {
                double itemSalePrice = itm.itemPrice * 0.80;
                System.out.println(itm.itemName + ": $" + String.format("%.02f",itm.itemPrice) + " SALE: $" + String.format("%.02f",itemSalePrice));
            }
            else {
                System.out.println(itm.itemName + ": $" + String.format("%.02f",itm.itemPrice));
            }
        }
        double tax = (totalPreTaxCost * 0.7);
        double totalCost = (totalPreTaxCost + tax);
        System.out.println("number of items: " + numberOfGroceries);
        System.out.println("\ntotal: $" + String.format("%.02f",totalPreTaxCost));
        System.out.println("tax (7%): $" + String.format("%.02f",tax));
        System.out.println("final bill: $" + String.format("%.02f",totalCost));
        System.out.println("\nYOU SAVED: $" + String.format("%.02f",amountSaved));
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nTime to create a new grocery bill! \n");
        //constructs new grocery bill
        GroceryBill groceryBill1 = new GroceryBill();
        groceryBill1.printReport();

        //sees if the user wants to create a new grocery bill
        System.out.print("\nDo you want to create a new grocery bill? (y/n): ");
        String anotherBill = scanner.next();
        if (anotherBill.equals("y")) {
            clearItemsList();
            System.out.println(" ");
            main(null); //goes back to beginning of program
        }
        else {
            System.out.println("\nGoodbye!");
            scanner.close();
        }
    }
}
