package dev.asjordi.solutions.ch03;

public class SpyEncryption {

    public static void main(String[] args) {
        PasswordReader p = new PasswordReader();
        System.out.println(p.getNthInvalidPassword(42));
    }

}
