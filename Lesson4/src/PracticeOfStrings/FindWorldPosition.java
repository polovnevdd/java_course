package PracticeOfStrings;

import java.util.Scanner;

public class FindWorldPosition {
    public static int findWorldPosition(String source, String target){
        return source.indexOf(target);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String source = sc.nextLine();
        String target = sc.nextLine();
        System.out.println(findWorldPosition(source, target));
    }
}
