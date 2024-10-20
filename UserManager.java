package Codes;

import java.time.LocalDate;
import java.util.List;

public interface UserManager {
	
	UserAcct createUser(String name, LocalDate birthDate, int heightFeet, int heightInches, int weight);
	boolean userExists(String name);
	UserAcct getUser(String name);
	List<UserAcct> getAllUsers();

}
