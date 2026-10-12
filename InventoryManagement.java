import java.util.Scanner;
import java.util.ArrayList;

class Product {
    int id;
    String name;
    double price;
    int quantity;

    Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    void displayProduct() {
        System.out.println(id + " | " + name + " | Rs. " + price
                + " | Stock: " + quantity);
    }

    boolean sellProduct(int amount) {
        if (amount <= 0) {
            return false;
        }

        if (amount > quantity) {
            return false;
        }

        quantity -= amount;
        return true;
    }
}

class Bill {
    void generateBill(Product product, int quantity) {
        double subtotal = product.price * quantity;
        double discount = subtotal >= 5000 ? subtotal * 0.10 : 0;
        double taxableAmount = subtotal - discount;
        double gst = taxableAmount * 0.18;
        double total = taxableAmount + gst;

        System.out.println("\n--- Sales Invoice ---");
        System.out.println("Product: " + product.name);
        System.out.println("Quantity: " + quantity);
        System.out.printf("Price: Rs. %.2f\n", product.price);
        System.out.printf("Subtotal: Rs. %.2f\n", subtotal);
        System.out.printf("Discount: Rs. %.2f\n", discount);
        System.out.printf("GST (18%%): Rs. %.2f\n", gst);
        System.out.printf("Final Amount: Rs. %.2f\n", total);
    }
}

public class InventoryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();
        Bill bill = new Bill();
        int choice;

        do {
            System.out.println("\n--- Inventory Management System ---");
            System.out.println("1. Add Product");
            System.out.println("2. Display Inventory");
            System.out.println("3. Sell Product");
            System.out.println("4. Exit");
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    boolean exists = false;

                    for (Product p : products) {
                        if (p.id == id) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        System.out.println("Product ID already exists.");
                        break;
                    }

                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();

                    if (price <= 0 || quantity < 0) {
                        System.out.println("Invalid price or quantity.");
                        break;
                    }

                    products.add(new Product(id, name, price, quantity));
                    System.out.println("Product Added Successfully.");
                    break;

                case 2:
                    if (products.isEmpty()) {
                        System.out.println("No products available.");
                    } else {
                        for (Product p : products) {
                            p.displayProduct();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Product ID: ");
                    int productId = sc.nextInt();

                    Product selected = null;

                    for (Product p : products) {
                        if (p.id == productId) {
                            selected = p;
                            break;
                        }
                    }

                    if (selected == null) {
                        System.out.println("Product Not Found.");
                        break;
                    }

                    System.out.print("Enter Quantity to Sell: ");
                    int amount = sc.nextInt();

                    if (selected.sellProduct(amount)) {
                        bill.generateBill(selected, amount);
                        System.out.println("Remaining Stock: "
                                + selected.quantity);
                    } else {
                        System.out.println("Invalid quantity or insufficient stock.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting Inventory Management.");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }
        } while (choice != 4);

        sc.close();
    }
}