package dev.asjordi.solutions24.ch02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Challenge {

    public static void main(String[] args) {
        var lines = readLines();
        int valid = 0;
        int invalid = 0;

        for (String line : lines) {
            if (isValid(line)) valid++;
            else invalid++;
        }

        System.out.println(valid + "true" + invalid + "false");

    }

    public static boolean isValid(String line) {
        if (!line.matches("^[a-z0-9]+$")) return false;

        boolean hasSeenLetter = false;
        char lastLetter = 'a';
        char lastDigit = '0';

        for (int i = 0; i < line.length(); i++) {
            char current = line.charAt(i);

            if (Character.isLetter(current)) {
                hasSeenLetter = true;
                if (current < lastLetter) return false;
                lastLetter = current;
            }
            else if (Character.isDigit(current)) {
                if (hasSeenLetter) return false;
                if (current < lastDigit) return false;
                lastDigit = current;
            }
        }

        return true;
    }

    public static List<String> readLines() {
        String file = "src/main/java/dev/asjordi/solutions24/ch02/log.txt";
        try {
            return Files.readAllLines(Paths.get(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
