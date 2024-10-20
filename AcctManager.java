package Codes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AcctManager {
	private UserManager userMng;
	private Scanner scanner;
	
	public AcctManager(UserManager userMng) {
		this.userMng = userMng;
		this.scanner = new Scanner(System.in);
	}
	
	public UserAcct createAccount() {
        System.out.println("\nLet's create an account for you");

        System.out.print("\nPlease enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Nice to meet you, " + name);

        String userInput;
        LocalDate birthDate;
        int feet, inches, weight;

        do {
            System.out.print("\nEnter Birth Day (YYYY-MM-DD): ");
            String birthDayInput = scanner.next();
            scanner.nextLine();

            birthDate = LocalDate.parse(birthDayInput, DateTimeFormatter.ISO_LOCAL_DATE);

            System.out.println("\nEnter height in feet and inches");
            System.out.print("Enter feet: ");
            feet = scanner.nextInt();
            System.out.print("Enter inches: ");
            inches = scanner.nextInt();
            scanner.nextLine();

            System.out.print("\nEnter your weight (lbs): ");
            weight = scanner.nextInt();
            scanner.nextLine();

            System.out.println("\nYour birth date is " + birthDate + 
                ", \nYou are " + feet + " feet and " + inches + " inches tall \nAnd weigh " + weight + 
                ". \nDoes this information look correct?");
            System.out.print("Enter 'yes' or 'no': ");
            userInput = scanner.nextLine().trim().toLowerCase();

        } while (!userInput.equals("yes"));

        System.out.println("\nWelcome to Drakula " + name + "! \nYour account has been created");
        return userMng.createUser(name, birthDate, feet, inches, weight);
    }


}
