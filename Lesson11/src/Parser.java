import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.*;

public class Parser {
    Map<String, Integer> countWorlds(String[] words) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (u, v) -> {
                            throw new IllegalStateException(String.format("Duplicate key %s", u));
                        },
                        LinkedHashMap::new
                ));
    }

    Map<String, Integer> takeTenCountWorlds(String[] words) {
        return countWorlds(words).entrySet().stream()
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

    int countUniqWorlds(String[] words){
        int numOfUniqWords = 0;
        Map<String, Integer> wordCount = new HashMap<>();
        wordCount = countWorlds(words);
        for (Map.Entry<String, Integer> word : wordCount.entrySet()) {
            if(word.getValue() == 1){
                numOfUniqWords++;
            }
        }
        return numOfUniqWords;
    }
}
