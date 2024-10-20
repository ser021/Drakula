package Codes;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Console implements User {
	
	private PeriodTracker tracker;
	private Scanner scanner;
	
	public Console(PeriodTracker tracker) {
		this.tracker = tracker;
		this.scanner = new Scanner(System.in);
	}
	
	@Override
	public void displayMenu() {
		int choice;
		do {
			System.out.println("\nDrakula Menu");
			System.out.println("1. Add Start Date");
			System.out.println("2. Add End Date");
			System.out.println("3. Show Average Cycle Length");
			System.out.println("4. Period Prediction");
			System.out.println("5. Period History");
			System.out.println("6. Exit");
			System.out.println("Choose an option: ");
			choice = scanner.nextInt();
			
			switch (choice) {		
			case 1 -> addPeriod();
			case 2 -> addPeriodEnd();
            case 3 -> showAvgCycleLength();
            case 4 -> showNextPeriodPredic();
            case 5 -> showPeriodHist();
            case 6 -> System.out.println("Exiting Drakula");
            default -> System.out.println("Invalid option, please try again.");
			}
		} while (choice != 6);
	}
	
	@Override
	public void addPeriod() {
		System.out.print("Enter start date (YYYY-MM-DD): ");
		String startDateInput = scanner.next();
		LocalDate startDate = LocalDate.parse(startDateInput);
		tracker.addPeriodStart(startDate);
		System.out.println("Start date added");
	}
	
	public void addPeriodEnd() {
		System.out.print("Enter end date (YYYY-MM-DD): ");
		String endDateInput = scanner.next();
		LocalDate endDate = LocalDate.parse(endDateInput);
		tracker.addPeriodEnd(endDate);
		System.out.println("End date added");
	}
	
	@Override
	public void showAvgCycleLength() {
		double avgCycle = tracker.getAvgCycleLength();
		if(avgCycle ==0) {
			System.out.println("Not enough data to calculate your average cycle length");
		}
		else {
			System.out.println("Average cycle length is " + avgCycle + " days");
		}
		
	}
	
	@Override
	public void showPeriodHist() {
		List<String> history = tracker.getPeriodHistory();
		
		if(history.isEmpty()) {
			System.out.println("No cycle history");
		}
		else {
			System.out.println("Period History: ");
			for(String period : history) {
				System.out.println(period);
			}
		}
	}

	@Override
	public void showNextPeriodPredic() {
		LocalDate nextPeriod = tracker.predictNextPeriod();
		if(nextPeriod != null) {
			System.out.println("Next period is predicted to start on: " + nextPeriod);
		}
		else {
			System.out.println("Not enough data to predict your next cycle");
		}
		
	}

}
