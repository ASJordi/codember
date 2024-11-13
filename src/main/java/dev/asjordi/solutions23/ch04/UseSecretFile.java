package dev.asjordi.solutions23.ch04;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class UseSecretFile {

    private final List<SecretFile> secretFiles;
    private List<SecretFile> validSecretFiles;
    private final File file = new File("C:/code/java/codember/src/main/java/dev/asjordi/solutions/ch04/data.txt");

    public UseSecretFile() {
        this.secretFiles = new LinkedList<>();
        this.validSecretFiles = new LinkedList<>();
        loadFiles();
        validateSecretFiles();
    }

    private void validateSecretFiles(){
        for (SecretFile f : this.secretFiles){
            if (f.validate()) this.validSecretFiles.add(f);
        }
    }

    private void loadFiles(){
        try (Reader r = new FileReader(this.file);
             BufferedReader br = new BufferedReader(r)) {
            String line = null;
            do {
                line = br.readLine();
                if (line != null) {
                    String[] data = line.split("[-]");
                    SecretFile secretFile = new SecretFile(data[0], data[1]);
                    this.secretFiles.add(secretFile);
                }
            } while (line != null);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public SecretFile getNthValidSecretFile(int index){
        return this.validSecretFiles.get(index);
    }

    public int getTotalFiles(){
        return this.secretFiles.size();
    }

    public int getTotalValidSecretFiles(){
        return this.validSecretFiles.size();
    }

}
