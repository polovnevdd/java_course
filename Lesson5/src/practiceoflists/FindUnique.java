package practiceoflists;

import java.util.ArrayList;
import java.util.List;

public class FindUnique {
    public static List<Integer> findUnique(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        for (int num : list) {
            if (!newList.contains(num)) {
                newList.add(num);
            }
        }
        return newList;
    }

    public static void main(String[] args) {
        List<Integer> numList = List.of(1, 2, 3, 2, 1, 4, 2, 6, 3, 7);
        System.out.println(findUnique(numList));
    }
}
