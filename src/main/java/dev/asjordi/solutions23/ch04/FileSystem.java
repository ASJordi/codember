package dev.asjordi.solutions23.ch04;

public class FileSystem {

    public static void main(String[] args) {
        UseSecretFile secretFile = new UseSecretFile();
        System.out.println(secretFile.getNthValidSecretFile(32));
    }

}
