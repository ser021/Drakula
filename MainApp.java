package Codes;

import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		UserManager userMng = new UserMngImpl();
		AcctManager acctManager = new AcctManager(userMng);
		
		System.out.println("Welcome to Drakula");
		System.out.print("Do you have an account? (yes/no): ");
		String ans = scanner.next();
		scanner.nextLine();
		
		UserAcct user = null;
		String name = "";
		
		if(ans.equalsIgnoreCase("yes")) {
			System.out.print("Please enter your name: ");
			name = scanner.next();
			
			if(userMng.userExists(name)) {
				user = userMng.getUser(name);
				System.out.println("Welcome back, " + user.getName() + "!");
			}
			else {
				System.out.println("User not found. Please create an account...");
				user = acctManager.createAccount();
				System.out.println(user);
			}
		}
		else if(ans.equalsIgnoreCase("no")){
			//AcctManager acctManager = new AcctManager();
			user = acctManager.createAccount();
		}
		else {
			System.out.println("Sorry, I don't know what you mean.\nPlease type 'yes' or 'no': ");
		}
		
		if (user != null) {
	        PeriodTracker tracker = user.getTracker();
	        User ui = new Console(tracker);
	        ui.displayMenu();
	    } else {
	        System.out.println("No valid user was created or logged in. Exiting the application.");
	    }
		
		scanner.close();

	}

}
