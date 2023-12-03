package dev.asjordi.solutions.ch05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    // id
    // username
    // location
    public static boolean validateAlphanumeric(String input){
        String alphanumericPattern = "^[a-zA-Z0-9]+$";

        Pattern pattern = Pattern.compile(alphanumericPattern);
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }

    public static boolean validateEmail(String email){
        String emailPattern = "^[a-zA-Z0-9_]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$";

        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public static boolean validateAge(String number){
        try {
            Integer n = Integer.parseInt(number);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public static boolean validateLocation(String location){
        return location != null && !location.isEmpty();
    }

}
