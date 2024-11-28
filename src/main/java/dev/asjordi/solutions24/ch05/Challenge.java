package dev.asjordi.solutions24.ch05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Challenge {

    public static void main(String[] args) {
        List<Integer> numbers = readLines().stream().map(Integer::parseInt).collect(Collectors.toList());
        List<String> validNumbers = new LinkedList<>();
        numbers.sort(Comparator.naturalOrder());

        for (int n : numbers) {
            int sumDigits = sumDigits(String.valueOf(n));
            if (isPrime(n) && isPrime(sumDigits)) {
                validNumbers.add(String.valueOf(n));
            }
        }

        System.out.println("submit " + validNumbers.size() + "-" + validNumbers.get(2));
    }

    public static int sumDigits(String n) {
        return n.chars().map(Character::getNumericValue).sum();
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i <= Math.sqrt(n); i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0) return false;

        return true;
    }

    public static List<String> readLines() {
        String file = "src/main/java/dev/asjordi/solutions24/ch05/data.txt";
        try {
            return Files.readAllLines(Paths.get(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
