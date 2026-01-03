import java.util.Scanner;

class ATM {
    private int pin = 1234;
    private double balance = 10000.00;

    public boolean verifyPin(int enteredPin) {
        return enteredPin == pin;
    }

    public void changePin(int oldPin, int newPin) {
        if (verifyPin(oldPin)) {
            pin = newPin;
            System.out.println("PIN changed successfully.");
        } else {
            System.out.println("Incorrect old PIN.");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: Rs. " + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Rs. " + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Rs. " + amount + " withdrawn successfully.");
        }
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM();

        System.out.println("===== Welcome to ATM =====");
        System.out.print("Enter your PIN: ");
        int enteredPin = sc.nextInt();

        if (!atm.verifyPin(enteredPin)) {
            System.out.println("Incorrect PIN. Access Denied.");
            return;
        }

        int choice;
        do {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Change PIN");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter deposit amount: Rs. ");
                    atm.deposit(sc.nextDouble());
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: Rs. ");
                    atm.withdraw(sc.nextDouble());
                    break;

                case 4:
                    System.out.print("Enter old PIN: ");
                    int oldPin = sc.nextInt();
                    System.out.print("Enter new PIN: ");
                    int newPin = sc.nextInt();

                    if (newPin >= 1000 && newPin <= 9999) {
                        atm.changePin(oldPin, newPin);
                    } else {
                        System.out.println("PIN must be exactly 4 digits.");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using the ATM.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
