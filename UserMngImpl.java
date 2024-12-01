package com.example.drakulaapp;
import java.time.LocalDate;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserMngImpl implements UserManager {

    private List<UserAcct> users;
    private static final String DATA_DIRECTORY = "data";
    private static final String DATA_FILE = "users_data.ser";

    public UserMngImpl() {
        this.users = loadUsers();
    }

    private void saveUsers() {
        // Ensure the directory exists
        File directory = new File(DATA_DIRECTORY);
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("Directory created: " + directory.getAbsolutePath());
            } else {
                System.err.println("Failed to create directory: " + directory.getAbsolutePath());
                return; // Exit if the directory couldn't be created
            }
        }

        // Save the user data
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(users);
            System.out.println("Users successfully saved to " + DATA_FILE);
        } catch (IOException e) {
            System.err.println("Error saving users: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private List<UserAcct> loadUsers() {
        // Ensure the directory exists before attempting to load
        File directory = new File(DATA_DIRECTORY);
        if (!directory.exists()) {
            directory.mkdirs(); // Create the directory if it doesn't exist
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            return (List<UserAcct>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("No existing users found or error loading users: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public UserAcct createUser(String name, LocalDate birthDate, int heightFeet, int heightInches, int weight) {
        UserAcct newUser = new UserAcct(name, birthDate, heightFeet, heightInches, weight);
        users.add(newUser);
        saveUsers();
        return newUser;
    }

    @Override
    public boolean userExists(String name) {
		/*for(UserAcct user : users) {
			if(user.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}*/
        return users.stream().anyMatch(user -> user.getName().equalsIgnoreCase(name));
    }

    @Override
    public UserAcct getUser(String name) {
		/*for(UserAcct user : users) {
			if(user.getName().equalsIgnoreCase(name)) {
				return user;
			}
		}*/
        return users.stream()
                .filter(user -> user.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<UserAcct> getAllUsers(){
        return users;
    }

}

