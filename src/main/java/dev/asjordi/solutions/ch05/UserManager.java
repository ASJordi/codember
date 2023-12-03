package dev.asjordi.solutions.ch05;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class UserManager {
    private List<User> validUsers;
    private List<User> invalidUsers;
    private final File file = new File("C:/code/java/codember/src/main/java/dev/asjordi/solutions/ch05/database.txt");

    public UserManager() {
        this.validUsers = new LinkedList<>();
        this.invalidUsers = new LinkedList<>();
        loadUsers();
    }

    private void loadUsers(){
        try (Reader r = new FileReader(file);
        BufferedReader br = new BufferedReader(r)) {
            String line = null;
            do {
                line = br.readLine();
                if (line != null){
                    String[] data = line.split(",");
                    String id = (data.length >= 1) ? data[0] : "";
                    String username = (data.length >= 2) ? data[1] : "";
                    String email = (data.length >= 3) ? data[2] : "";
                    String age = (data.length >= 4) ? data[3] : "";
                    String location = (data.length >= 5) ? data[4] : "";
                    User user;

                    if (data.length == 5) {
                        user = processUserWithLength5(id, username, email, age, location);
                    } else if (data.length == 4) {
                        user = processUserWithLength4(id, username, email, age);
                    } else if (data.length == 3) {
                        user = processUserWithLength3(id, username, email);
                    } else return;

                    if (user != null) this.validUsers.add(user);
                    else this.invalidUsers.add(new User(username));
                }
            } while (line != null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private User processUserWithLength5(String id, String username, String email, String age, String location){
        if (validateUserWithLength5(id, username, email, age, location)) return new User(id, username, email, Integer.parseInt(age), location);
        return null;
    }

    private User processUserWithLength4(String id, String username, String email, String age){
        if (validateUserWithLength4(id, username, email, age)) return new User(id, username, email, Integer.parseInt(age));
        return null;
    }

    private User processUserWithLength3(String id, String username, String email){
        if (validateUserWithLength3(id, username, email)) return new User(id, username, email);
        return null;
    }

    public boolean validateUserWithLength5(String id, String username, String email, String age, String location){
        return Utils.validateAlphanumeric(id) && Utils.validateAlphanumeric(username) && Utils.validateEmail(email) && Utils.validateAge(age) && Utils.validateLocation(location);
    }

    public boolean validateUserWithLength4(String id, String username, String email, String age){
        return Utils.validateAlphanumeric(id) && Utils.validateAlphanumeric(username) && Utils.validateEmail(email) && Utils.validateAge(age);
    }

    public boolean validateUserWithLength3(String id, String username, String email){
        return Utils.validateAlphanumeric(id) && Utils.validateAlphanumeric(username) && Utils.validateEmail(email);
    }

    public String getHiddenMessage(){
        StringBuilder message = new StringBuilder();

        for (User user : this.invalidUsers) message.append(user.getUsername().charAt(0));

        return message.toString().toLowerCase();
    }

    public int getTotalValidUsers() {
        return this.validUsers.size();
    }

    public int getTotalInvalidUsers() {
        return this.invalidUsers.size();
    }

}
