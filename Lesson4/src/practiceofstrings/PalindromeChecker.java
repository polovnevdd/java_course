package practiceofstrings;

import java.util.Scanner;

public class PalindromeChecker {
    public static boolean palindromeChecker(String line) {
        int len = line.length();
        char[] array = line.toCharArray();
        for (int i = 0; i < len/2; i++) {
            if (array[i] != array[len - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String line = sc.nextLine();
        System.out.println(palindromeChecker(line));
    }
}

