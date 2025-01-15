package practiceoflists;

import java.util.ArrayList;
import java.util.List;

public class ToList {

    public static List<Integer> toList(int[] array) {
        List<Integer> list = new ArrayList<>() {
        };
        for (int num : array) {
            list.add(num);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] array = {10, 2, 29, 49, 11, 5, 17};
        System.out.println(toList(array));
    }
}
