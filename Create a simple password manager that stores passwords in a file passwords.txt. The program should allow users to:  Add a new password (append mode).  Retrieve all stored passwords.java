import java.io.*;
import java.util.Scanner;

public class PasswordManager {
    private static final String FILE_NAME = "passwords.txt";
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nPassword Manager");
            System.out.println("1. Add new password");
            System.out.println("2. Retrieve all stored passwords");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    addPassword(scanner);
                    break;
                case 2:
                    retrievePasswords();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
    
    private static void addPassword(Scanner scanner) {
        System.out.print("Enter account name: ");
        String account = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(account + " : " + password);
            writer.newLine();
            System.out.println("Password saved successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
    
    private static void retrievePasswords() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\nStored Passwords:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
