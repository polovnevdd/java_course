package practiceoflists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CalcOccurrence {
    public static void calcOccurrence(List<String> list) {
        List<String> newList = new ArrayList<>();
        for (String animal : list) {
            int count = 0;
            if (!newList.contains(animal)) {
                newList.add(animal);
                System.out.print(animal + ": ");
                for (String element : list) {
                    if (element.equals(animal)) {
                        count++;
                    }
                }
                System.out.println(count);
            }
        }
    }

    public static void calcOccurrenceSecondVariant(List<String> list) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String animal : list) {
            if (map.containsKey(animal)) {
                map.put(animal, map.get(animal) + 1);
            } else {
                map.put(animal, 1);
            }
        }
        System.out.println(map);
    }

    public static void main(String[] args) {
        List<String> list = List.of("cat", "dog", "frog", "dog", "cow", "cat", "pig", "frog", "cat", "rabbit", "dog", "cow", "pig");
        //calcOccurrence(list);
        calcOccurrenceSecondVariant(list);
    }
}
