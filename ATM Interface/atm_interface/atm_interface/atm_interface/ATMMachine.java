import java.util.Scanner;

class ATM {
    float balance;
    int pin = 5674;

    public void checkPin() {
        System.out.println("Enter your PIN:");
        Scanner sc = new Scanner(System.in);
        int enteredPin = sc.nextInt();
        if (enteredPin == pin) {
            menu();
        } else {
            System.out.println("Invalid PIN");
        }
    }

    public void menu() {
        int choice = 0;
        try (Scanner sc = new Scanner(System.in)) {
            while (choice != 4) {
                System.out.println("Enter your choice:");
                System.out.println("1. Check Account Balance");
                System.out.println("2. Withdraw Money");
                System.out.println("3. Deposit Money");
                System.out.println("4. Exit");
                choice = sc.nextInt();
                
                switch (choice) {
                    case 1 -> checkBalance();
                    case 2 -> withdraw();
                    case 3 -> deposit();
                    case 4 -> System.out.println("Thank you for using our ATM.");
                    default -> System.out.println("Invalid choice");
                }
            }
        }
    }

    public void checkBalance() {
        System.out.println("Balance: " + balance);
    }

    public void withdraw() {
        System.out.println("Enter the withdrawal amount:");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        if (amount > balance) {
            System.out.println("Insufficient balance");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful");
        }
    }

    public void deposit() {
        System.out.println("Enter the deposit amount:");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        balance += amount;
        System.out.println("Deposit successful");
    }
    public class ATMMachine {
        public static void main(String[] args) {
            ATM atm = new ATM();
            atm.checkPin();
        }
    }
    
}

