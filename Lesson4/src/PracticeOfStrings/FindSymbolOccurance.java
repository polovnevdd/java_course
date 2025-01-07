package PracticeOfStrings;

import java.util.Scanner;

public class FindSymbolOccurance {
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
        String line = sc.nextLine();
        char symbol = sc.nextLine().charAt(0);
        System.out.println(findSymbolOccurance(line, symbol));
    }
}
