package practiceofstrings;

import java.util.Scanner;

public class FindSymbolOccurrence {
    public static int findSymbolOccurance(String line, char symbol) {
        int len = line.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (line.charAt(i) == symbol) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String line = sc.nextLine();
        System.out.println("Введите символ: ");
        char symbol = sc.nextLine().charAt(0);
        System.out.println(findSymbolOccurance(line, symbol));
    }
}
