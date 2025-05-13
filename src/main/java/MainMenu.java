import java.io.*;
import java.util.Scanner;

public class MainMenu {
    static Scanner scanner = new Scanner(System.in);
    static String fileName = "src/main/resources/transactions.csv";

    public static void main(String[] args) throws IOException {
        homeScreen();
    }

    public static void homeScreen() throws IOException {
        boolean continueApp = true;
        while (continueApp) {
            System.out.println("Hello, please select from the following options:\n----------------\nD) Add Deposit\nP) Make Payment(Debit)\nL) Ledger\nX) Exit\n");
            String user_choice = scanner.next().toLowerCase();
            switch (user_choice) {
                case "d":
                    Ledger.makeDeposit(fileName);
                    break;
                case "p":
                    Ledger.makePayment(fileName);
                    break;
                case "l":
                    Ledger.ledgerMenuScreen();
                    break;
                case "x":
                    System.out.println("Exiting...");
                    continueApp = false;
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        }
    }
}




