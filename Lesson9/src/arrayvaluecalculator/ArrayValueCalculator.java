package arrayvaluecalculator;

public class ArrayValueCalculator {
    public static int doCalc(String[][] array) {
        int sum = 0;
        if (array.length != 4) {
            throw new ArraySizeException("Массив должен быть размером 4x4");
        }
        for (int i = 0; i < 4; i++) {
            if (array[i].length != 4) {
                throw new ArraySizeException("Массив должен быть размером 4x4");
            }
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException("Неверный формат в [" + i + "] [" + j + "]");
                }
            }
        }
        return sum;
    }
}
