package dev.asjordi.solutions23.ch01;

import java.util.LinkedHashMap;
import java.util.Map;

public class Challenge01 {

    public static String solution(String words){
        String[] wordsArr = words.toLowerCase().split(" ");
        Map<String, Integer> dict = new LinkedHashMap<>();
        StringBuilder result = new StringBuilder();

        for (String word : wordsArr){
            if (!dict.containsKey(word)) dict.put(word, 1);
            else dict.replace(word, dict.get(word) + 1);
        }

        for (Map.Entry<String, Integer> entry : dict.entrySet()){
            result.append(entry.getKey()).append(entry.getValue());
        }

        return result.toString();
    }

}
