package dev.asjordi.solutions.ch04;

public class FileSystem {

    public static void main(String[] args) {
        UseSecretFile secretFile = new UseSecretFile();
        System.out.println(secretFile.getNthValidSecretFile(32));
    }

}
