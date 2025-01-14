package practiceoflists;

import java.util.ArrayList;
import java.util.List;

public class CalcOccurance {
    public static void calcOccurance(List<String> list) {
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

    public static void main(String[] args) {
        List<String> list = List.of("cat", "dog", "frog", "dog", "cow", "cat", "pig", "frog", "cat", "rabbit", "dog", "cow", "pig");
        calcOccurance(list);
    }
}
