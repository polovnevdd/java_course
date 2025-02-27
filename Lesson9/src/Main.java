import arrayvaluecalculator.ArrayValueCalculator;

public class Main {
    public static void main(String[] args) {
        String[][] array1 = {{"1", "2", "3", "4"}, {"5", "6", "7","8"}, {"1", "2", "3", "4"}, {"5", "6", "7", "8"}};
        String[][] array2 = {{"1", "2", "3",}, {"5", "6", "7","8"}, {"1", "3", "4"}, {"5", "6", "7", "8"}};
        String[][] array3 = {{"1", "u", "3", "4"}, {"k", "6", "7","8"}, {"o", "2", "3", "4"}, {"5", "6", "7", "8"}};
        System.out.println(ArrayValueCalculator.doCalc(array1));

    }
}
