package dev.asjordi.solutions.ch03;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PasswordReader {

    private final File file = new File("C:/code/java/codember/src/main/java/dev/asjordi/solutions/ch03/data.txt");
    private final List<Password> passwordList;
    private List<Password> invalidList;
    private List<Password> validList;

    public PasswordReader() {
        this.passwordList = new LinkedList<>();
        this.invalidList = new LinkedList<>();
        this.validList = new LinkedList<>();
        loadData();
        loadValidPasswords();
        loadInvalidPasswords();
    }

    public String getNthInvalidPassword(int n){
        return this.invalidList.get(n - 1).getPassword();
    }

    public int getNumberOfValidPasswords(){
        return this.validList.size();
    }

    public int getNumberOfInvalidPasswords(){
        return this.invalidList.size();
    }

    private void loadValidPasswords(){
        for (Password p : this.passwordList) if (p.isValid()) this.validList.add(p);
    }

    private void loadInvalidPasswords(){
        for (Password p : this.passwordList) if (!p.isValid()) this.invalidList.add(p);
    }

    private void loadData() {
        try (Reader r = new FileReader(this.file);
             BufferedReader br = new BufferedReader(r)) {

            String line = null;

            do {
                line = br.readLine();
                if (line != null) {
                    String[] data = line.split(":");
                    char key = data[0].charAt(data[0].length() - 1);
                    String password = data[1];
                    String[] limits = data[0].substring(0, data[0].length() - 2).split("-");
                    int min = Integer.parseInt(limits[0]);
                    int max = Integer.parseInt(limits[1]);
                    Password p = new Password(min, max, key, password);
                    passwordList.add(p);
                }
            } while (line != null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
