package PracticeOfStrings;

import java.util.Scanner;

public class StringReverse {
    public static String stringReverse(String line) {
        int len = line.length();
        char[] array = new char[len];
        int arrayId = 0;
        for (int i = len - 1; i > -1; i--) {
            array[arrayId] = line.charAt(i);
            arrayId++;
        }
        return String.valueOf(array);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        System.out.println(stringReverse(line));
    }
}
