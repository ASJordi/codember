package dev.asjordi.solutions24.ch04;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Challenge {

    public static void main(String[] args) throws URISyntaxException, IOException {
        String fileContent = readLines().get(0);
        List<int[]> data = parseData(fileContent);
        List<Integer> safeNodes = findSafeNodes(data);
        System.out.println(String.join(",",
                safeNodes.stream().map(String::valueOf).collect(Collectors.toList())));
    }

    private static List<int[]> parseData(String fileContent) {
        fileContent = fileContent.trim().replace("[", "").replace("]", "");
        String[] pairs = fileContent.split("},\\s*\\{");
        List<int[]> data = new ArrayList<>();
        for (String pair : pairs) {
            pair = pair.replace("{", "").replace("}", "");
            String[] numbers = pair.split(",");
            data.add(new int[]{Integer.parseInt(numbers[0].trim()), Integer.parseInt(numbers[1].trim())});
        }
        return data;
    }

    private static List<Integer> findSafeNodes(List<int[]> data) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : data) {
            int a = edge[0];
            int b = edge[1];

            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        List<List<Integer>> components = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for (Integer node : graph.keySet()) {
            if (!visited.contains(node)) {
                List<Integer> component = new ArrayList<>();
                dfs(node, graph, visited, component);
                components.add(component);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for (List<Integer> component : components) {
            if (component.size() < 3) {
                safeNodes.addAll(component);
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }

    private static void dfs(Integer node, Map<Integer, List<Integer>> graph, Set<Integer> visited, List<Integer> component) {
        component.add(node);
        visited.add(node);

        for (Integer neighbor : graph.getOrDefault(node, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, graph, visited, component);
            }
        }
    }


    public static List<String> readLines() {
        String file = "src/main/java/dev/asjordi/solutions24/ch04/network.txt";
        try {
            return Files.readAllLines(Paths.get(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
