package practiceofstrings;

import java.util.Scanner;

public class StringReverse {
    public static String stringReverse(String line) {
        int len = line.length();
        char[] array = new char[len];
        for (int i = len - 1; i > -1; i--) {
            array[len - 1 - i] = line.charAt(i);
        }
        return String.valueOf(array);
    }

    public static String stringReverseSecondVariant(String line) {
        char[] array = line.toCharArray();
        int leftId = 0;
        int rightID = line.length() - 1;
        char box;
        while (leftId < rightID) {
            box = array[leftId];
            array[leftId] = array[rightID];
            array[rightID] = box;
            leftId++;
            rightID--;
        }
        return String.valueOf(array);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String line = sc.nextLine();
        System.out.println(stringReverseSecondVariant(line));
    }
}
