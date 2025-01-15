package practiceoflists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindOccurrence {
    public static void findOccurrence(List<String> list) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String animal : list) {
            if (map.containsKey(animal)) {
                map.put(animal, map.get(animal) + 1);
            } else {
                map.put(animal, 1);
            }
        }
        //System.out.println(map);
        List<WordOccurrence> results = new ArrayList<>();
        for (String result : map.keySet()) {
            results.add(new WordOccurrence(result, map.get(result)));
        }
        System.out.println(results);
    }

    public static void main(String[] args) {
        List<String> list = List.of("cat", "dog", "frog", "dog", "cow", "cat", "pig", "frog", "cat", "rabbit", "dog", "cow", "pig");
        findOccurrence(list);
    }
}
