package practiceofstrings;

import java.util.Random;
import java.util.Scanner;


public class PoleChudes {
    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
                "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper",
                "pineapple", "pumpkin", "potato"};

        Random rand = new Random();
        String secretWord = words[rand.nextInt(words.length)];
        System.out.println("Введите ваше слово: ");

        Scanner sc = new Scanner(System.in);

        while (true) {
            String usersWord = sc.nextLine();
            if (secretWord.equals(usersWord)) {
                System.out.println("Ты угадал!");
                break;
            }
            for (int i = 0; i < 15; i++) {
                if (i < secretWord.length() && i < usersWord.length() && secretWord.charAt(i) == usersWord.charAt(i)) {
                    System.out.print(secretWord.charAt(i));
                } else {
                    System.out.print("#");
                }
            }
            System.out.println();
        }
    }
}
