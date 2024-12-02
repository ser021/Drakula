package Codes;

import java.time.LocalDate;
import java.io.Serializable;

public class UserAcct implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
    private LocalDate birthDate;
    private int heightFeet;
    private int heightInches;
    private int weight;
    
    private transient PeriodTracker tracker;
    
    public PeriodTracker getTracker() {
    	if (tracker == null) {
    		tracker = new PTImpl();
    	}
    	return tracker;
    }

    public UserAcct(String name, LocalDate birthDate, int heightFeet, int heightInches, int weight) {
        this.name = name;
        this.birthDate = birthDate;
        this.heightFeet = heightFeet;
        this.heightInches = heightInches;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getHeightFeet() {
        return heightFeet;
    }

    public int getHeightInches() {
        return heightInches;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', birthDate=" + birthDate + 
               ", height=" + heightFeet + "ft " + heightInches + "in, weight=" + weight + " lbs}";
    }

}
