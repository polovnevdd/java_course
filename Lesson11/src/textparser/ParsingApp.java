package textparser;

import textparser.utils.Parser;
import textparser.utils.SerializeUtils;

import java.util.Scanner;

public class ParsingApp {
    public static void main(String[] args) {
        new ParsingApp().start();
    }

    private void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название книги: ");
        String bookName = scanner.nextLine();
        Parser parser = new Parser();
        SerializeUtils serializeUtils = new SerializeUtils();
        String worlds[] = serializeUtils.readFile(bookName).toLowerCase().split("\\W+");
        serializeUtils.writeStatistics(parser.takeTenCountWorlds(worlds), parser.countUniqueWorlds(worlds), bookName);
    }
}
