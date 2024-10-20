package Codes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserMngImpl implements UserManager {
	
	private List<UserAcct> users;
	
	public UserMngImpl() {
		this.users = new ArrayList<>();
	}
	
	@Override
	public UserAcct createUser(String name, LocalDate birthDate, int heightFeet, int heightInches, int weight) {
		UserAcct newUser = new UserAcct(name, birthDate, heightFeet, heightInches, weight);
		users.add(newUser);
		return newUser;
	}
	
	@Override
	public boolean userExists(String name) {
		for(UserAcct user : users) {
			if(user.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public UserAcct getUser(String name) {
		for(UserAcct user : users) {
			if(user.getName().equalsIgnoreCase(name)) {
				return user;
			}
		}
		return null;
	}
	
	@Override
	public List<UserAcct> getAllUsers(){
		return users;
	}

}
