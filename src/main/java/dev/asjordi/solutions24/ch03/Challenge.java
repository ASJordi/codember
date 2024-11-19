package dev.asjordi.solutions24.ch03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Challenge {

    public static void main(String[] args) {
        var lines = readLines();
        int sumLines = 0;

        for (String line : lines) sumLines += calculate(line);

        int lastLine = calculate(lines.get(lines.size() - 1));

        System.out.println("submit " + sumLines + "-" + lastLine);
    }

    public static int calculate(String line) {
        var list = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        int steps = 0;
        int current;
        int index = 0;

        if (list.get(0) < 0) return 1;

        while (true) {
            current = list.get(index);

            if (current == 0) {
                list.set(index, current + 1);
                steps++;
                continue;
            }

            list.set(index, current + 1);
            index += current;
            steps++;
            if (index >= list.size() || index < 0) break;
        }

        return steps;
    }

    public static List<String> readLines() {
        String file = "src/main/java/dev/asjordi/solutions24/ch03/trace.txt";
        try {
            return Files.readAllLines(Paths.get(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
