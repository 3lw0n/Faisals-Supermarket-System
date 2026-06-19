import java.util.Scanner;

public class FinalProject {
    static float totallOrder = 0.0f;

    public static void searchItem(String listItems[], Scanner input) {
        boolean foundIt = false;
        System.out.println("Enter The Item ");
        String inputSearch = input.next();
        for (int a = 0; a < listItems.length; a++) {
            if (listItems[a].equalsIgnoreCase(inputSearch)) {
                System.out.println("The item found it!");
                foundIt = true;
                break;
            }
        }
        if (!foundIt) {
            System.out.println("The item  not found it!");
        }
    }

    public static void average(float pricess[]) {
        float sum = 0;
        for (int a = 0; a < pricess.length; a++) {
            sum += pricess[a];
        }
        System.out.println("Average Items = " + sum / pricess.length);
    }

    public static void filter(String listItems[], float pricess[], Scanner input) {
        System.out.println("Enter maximum price limit ");
        float inputFilter = input.nextFloat();
        for (int a = 0; a < listItems.length; a++) {
            if (inputFilter > pricess[a]) {
                System.out.println("Name = " + listItems[a] + " | " + "price = " + pricess[a]);
            }
        }
    }

    public static void print() {
        float discount = 0.0f;
        float finalBill = totallOrder;

        if (totallOrder >= 20 && totallOrder < 30) {
            discount = 0.05f * totallOrder;
            finalBill = totallOrder - discount;
            System.out.println("Congratulations! You have received a 5% discount.");
        } else if (totallOrder >= 30) {
            discount = 0.15f * totallOrder;
            finalBill = totallOrder - discount;
            System.out.println("Congratulations! You have received a 15% discount.");
        }
        System.out.println("ORIGINAL BILL: " + totallOrder + " | Total Discount: " + discount);
        System.out.println("TOTAL FINAL BILL: " + finalBill);
    }

    public static void main(String Args[]) {
        Scanner input = new Scanner(System.in);

        String listItems[] = {"apple", "Banana", "Tomato", "Potato", "Milk", "Eggs", "Yogurt", "Butter", "CheddarCheese", "WhiteBread", "Pasta", "Rice", "Sugar", "Salt", "Coffee", "Tea", "OliveOil", "Flour", "Onion", "Garlic", "Cucumber", "Carrot", "Chicken", "Beef", "Fish", "Orange", "Water", "Juice", "Biscuits", "Honey"};
        float pricess[] = {1.75f, 1.05f, 0.95f, 0.65f, 1.60f, 5.20f, 0.55f, 3.80f, 3.20f, 0.40f, 1.35f, 2.45f, 1.20f, 0.35f, 4.50f, 2.10f, 6.80f, 0.85f, 0.75f, 0.50f, 0.90f, 1.10f, 7.50f, 12.00f, 9.30f, 1.50f, 0.25f, 1.80f, 1.15f, 5.60f};
        int stock[] = {50, 80, 60, 100, 40, 15, 50, 20, 25, 30, 45, 40, 70, 120, 35, 60, 25, 80, 90, 110, 75, 65, 30, 20, 15, 85, 200, 50, 95, 20};
        System.out.println("=========================================");
        System.out.println("      Welcome to Faisal's Supermarket    ");
        System.out.println("=========================================");
        while (true) {
            System.out.println("Enter  ' Exit ' to close system ");
            System.out.println("Enter ' Continue ' to resum ");
            String MenuInput = input.next();

            if (MenuInput.equalsIgnoreCase("Exit"))
                break;
            if (MenuInput.equalsIgnoreCase("Continue")) {
                while (true) {
                    System.out.println("-----------------------------------------");
                    System.out.println("Menu  Item");
                    System.out.println("To find item ' Search  ' ");
                    System.out.println("To filter items by price Enter 'Filter' ");
                    System.out.println("To add item  enter ' Add ' ");
                    System.out.println("To calculate enter ' Print ' ");
                    System.out.println("To find the average of items Enter 'average' ");
                    System.out.println("To close app 'Exit' ");
                    System.out.println("-----------------------------------------");
                    String menuItem = input.next();

                    if (menuItem.equalsIgnoreCase("ADD")) {
                        System.out.println("Write the item you wanna add it !");
                        String itemInput = input.next();
                        for (int a = 0; a < listItems.length; a++) {
                            if (listItems[a].equalsIgnoreCase(itemInput)) {
                                System.out.println("Price " + pricess[a] + " Quantity " + stock[a]);
                                System.out.println("Enter Qunatity ");
                                try {
                                    int quantityInput = input.nextInt();
                                    if (quantityInput <= 0) {
                                        throw new InvalidQuantity("The Quantity must be greater than 0 ");
                                    }
                                    if (quantityInput > stock[a]) {
                                        throw new InvalidQuantity("The quantity must be less than or equal to the available stock.");
                                    }

                                    float item = pricess[a] * quantityInput;
                                    System.out.println("Subtotal: " + item);
                                    totallOrder += item;
                                    stock[a] -= quantityInput;
                                } catch (InvalidQuantity e) {
                                    System.out.println("InvalidQuantity ," + e.getMessage());
                                }
                            }
                        }
                    } else if (menuItem.equalsIgnoreCase("PRINT")) {
                        print();
                    } else if (menuItem.equalsIgnoreCase("SEARCH")) {
                        searchItem(listItems, input);
                    } else if (menuItem.equalsIgnoreCase("AVERAGE")) {
                        average(pricess);
                    } else if (menuItem.equalsIgnoreCase("FILTER")) {
                        filter(listItems, pricess, input);
                    } else if (menuItem.equalsIgnoreCase("EXIT"))
                        System.exit(0);  
                    else
                        System.out.println("Enter Correct Option (Add / Print / Search / Average / Filter / Exit ) !");
                }
            }
        }
    }
}