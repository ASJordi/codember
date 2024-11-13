package dev.asjordi.solutions23.ch05;

public class User {

    private String id;
    private final String username;
    private String email;
    private int age;
    private String location;

    public User(String id, String username, String email, int age, String location) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.age = age;
        this.location = location;
    }

    public User(String id, String username, String email, int age) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.age = age;
    }

    public User(String id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public User(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", location='" + location + '\'' +
                '}';
    }
}

