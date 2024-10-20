package Codes;

import java.time.LocalDate;

public class UserAcct {
	
	private String name;
    private LocalDate birthDate;
    private int heightFeet;
    private int heightInches;
    private int weight;

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
