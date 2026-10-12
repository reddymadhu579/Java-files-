import java.util.Scanner;

class BankAccount {
    Scanner sc = new Scanner(System.in);

    long accountNumber;
    String customerName;
    double balance;

    void entry() {
        System.out.print("Enter Account Number: ");
        accountNumber = sc.nextLong();
        sc.nextLine();

        System.out.print("Enter Customer Name: ");
        customerName = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        balance = sc.nextDouble();

        if (balance < 0) {
            balance = 0;
            System.out.println("Invalid balance. Set to zero.");
        }

        System.out.println("Account Created Successfully!");
    }

    void deposit() {
        System.out.print("Enter Deposit Amount: ");
        double amount = sc.nextDouble();

        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Amount Deposited Successfully!");
        } else {
            System.out.println("Invalid Deposit Amount!");
        }
    }

    void withdraw() {
        System.out.print("Enter Withdrawal Amount: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid Withdrawal Amount!");
        } else if (amount <= balance) {
            balance = balance - amount;
            System.out.println("Withdrawal Successful!");
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    void returnBalance() {
        System.out.println("Account Holder: " + customerName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: Rs. " + balance);
    }

    void exit() {
        System.out.println("Thank you for using our Banking System!");
    }
}

public class BANK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount();

        account.entry();

        int choice;

        do {
            System.out.println("\n--- BANK MENU ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter Your Choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    account.deposit();
                    break;
                case 2:
                    account.withdraw();
                    break;
                case 3:
                    account.returnBalance();
                    break;
                case 4:
                    account.exit();
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 4);

        sc.close();
    }
}