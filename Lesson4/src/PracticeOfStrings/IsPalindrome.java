package PracticeOfStrings;

import java.util.Scanner;

public class IsPalindrome {
    public static boolean isPalindrome(String line) {
        int len = line.length();
        char[] array = line.toCharArray();
        for (int i = 0; i < len; i++) {
            if (array[i] != array[len - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        System.out.println(isPalindrome(line));
    }
}

