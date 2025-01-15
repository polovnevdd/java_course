package practiceoflists;

import java.util.List;

public class CountOccurrence {
    public static int countOccurrence(List<String> words, String mainWord) {
        int count = 0;
        for (String word : words) {
            if (word.equals(mainWord)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<String> myList = List.of("apple", "banana", "orange", "apple", "grape", "banana", "apple");
        String word = "apple";
        System.out.println("Слово '" + word + "' встречается " + countOccurrence(myList, word) + " раз");
    }
}
