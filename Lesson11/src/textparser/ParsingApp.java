package textparser;

import textparser.utils.Parser;
import textparser.utils.SerializeUtils;

import java.util.Map;
import java.util.Scanner;

public class ParsingApp {
    public static void main(String[] args) {
        new ParsingApp().run();
    }

    private void run() {
        System.out.println("Введите название книги: ");
        try (Scanner scanner = new Scanner(System.in)) {
            String bookName = scanner.nextLine();
            SerializeUtils serializeUtils = new SerializeUtils();
            String readFile = serializeUtils.readFile(bookName);
            if (readFile != null) {
                String worlds[] = readFile.toLowerCase().split("\\W+");
                Parser parser = new Parser();
                Map<String, Integer> stringIntegerMap = parser.takeTenCountWorlds(worlds);
                int countUniqueWorlds = parser.countUniqueWorlds(worlds);
                serializeUtils.writeStatistics(stringIntegerMap, countUniqueWorlds, bookName);
            }
        }
    }
}
