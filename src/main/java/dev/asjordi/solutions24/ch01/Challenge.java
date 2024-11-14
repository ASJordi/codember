package dev.asjordi.solutions24.ch01;

import java.util.Arrays;

public class Challenge {

    public static void main(String[] args) {
        System.out.println(getCombination("URURD", 0, 0, 0));
        System.out.println(getCombination("UUURUUU", 1, 1, 1, 1));
        System.out.println(getCombination("LULULULD", 9, 9, 9, 9));
        System.out.println(getCombination("URDURUDRUDLLLLUUDDUDUDUDLLRRRR", 5, 2, 8, 9, 3, 4, 7, 1, 2, 8, 3, 4));
    }

    public static String getCombination(String movements, int... numbers) {
        int i = 0;

        for (int j = 0; j < movements.length(); j++) {
            switch (movements.charAt(j)) {
                case 'R' -> {
                    if (i == numbers.length - 1) i = 0;
                    else i++;
                }
                case 'L' -> {
                    if (i == 0) i = numbers.length - 1;
                    else i--;
                }
                case 'U' -> {
                    if (numbers[i] == 9) numbers[i] = 0;
                    else numbers[i]++;
                }
                case 'D' -> {
                    if (numbers[i] == 0) numbers[i] = 9;
                    else numbers[i]--;
                }
                default -> throw new IllegalArgumentException("Invalid movement");
            }
        }

        StringBuilder sb = new StringBuilder();
        Arrays.stream(numbers).forEach(sb::append);

        return sb.toString();
    }

}
