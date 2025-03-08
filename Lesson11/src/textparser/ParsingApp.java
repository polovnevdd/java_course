package textparser;

import textparser.utils.Parser;
import textparser.utils.SerializeUtils;

public class ParsingApp {
    public static void main(String[] args) {
        new ParsingApp().start();
    }

    private void start() {
        //Scanner scanner = new Scanner(System.in);
        //System.out.println("Введите название книги: ");
        //String bookName = scanner.nextLine();
        //List<Map.Entry<String,Integer>> (String[] words)sortedWords = new ArrayList<>();
        Parser parser = new Parser();
        SerializeUtils serializeUtils = new SerializeUtils();
        String worlds[] = serializeUtils.readFile().toLowerCase().split("\\W+");
        System.out.println(parser.countUniqueWorlds(worlds));
        serializeUtils.writeStatistics(parser.takeTenCountWorlds(worlds),parser.countUniqueWorlds(worlds));
    }
}
