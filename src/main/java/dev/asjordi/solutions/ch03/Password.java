package dev.asjordi.solutions.ch03;

public class Password {

    private final int min;
    private final int max;
    private final char key;
    private final String password;

    public Password(int min, int max, char key, String password) {
        this.min = min;
        this.max = max;
        this.key = key;
        this.password = password;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public char getKey() {
        return key;
    }

    public String getPassword() {
        return password;
    }

    public boolean isValid(){
        int count = 0;

        for (char c : this.password.toCharArray()) if (c == this.key) count++;

        return count >= this.min && count <= this.max;

    }

    @Override
    public String toString() {
        return "Password{" +
                "min=" + min +
                ", max=" + max +
                ", key=" + key +
                ", password='" + password + '\'' +
                '}';
    }
}
