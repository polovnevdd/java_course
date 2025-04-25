package textparser.utils;

import java.util.*;
import java.util.stream.*;

public class Parser {
    public Map<String, Integer> takeTenCountWorlds(String[] words) {
        return countWorlds(words).entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (u, v) -> {
                            throw new IllegalStateException(String.format("Duplicate key %s", u));
                        },
                        LinkedHashMap::new
                ));
    }

    public int countUniqueWorlds(String[] words) {
        Map<String, Integer> wordCount = countWorlds(words);
        return (int) wordCount.values().stream()
                .filter(n -> n == 1)
                .count();
    }

    private Map<String, Integer> countWorlds(String[] words) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            if (word.length() > 2) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        return wordCount;
    }
}
