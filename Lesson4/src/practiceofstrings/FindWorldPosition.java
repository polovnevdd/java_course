package practiceofstrings;

import java.util.Scanner;

public class FindWorldPosition {
    public static int findWorldPosition(String source, String target){
        return source.indexOf(target);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите первую строку:");
        String source = sc.nextLine();
        System.out.println("Введите вторую строку:");
        String target = sc.nextLine();
        System.out.println(findWorldPosition(source, target));
    }
}
