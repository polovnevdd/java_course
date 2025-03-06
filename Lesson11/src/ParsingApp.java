import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParsingApp {
    public static void main(String[] args) {
        new ParsingApp().start();
    }

    private void start() {
        //Scanner scanner = new Scanner(System.in);
        //System.out.println("Введите название книги: ");
        //String bookName = scanner.nextLine();
        //List<Map.Entry<String,Integer>> sortedWords = new ArrayList<>();
        Parser parser = new Parser();
        SerializeUtils serializeUtils = new SerializeUtils();
        String worlds[] = serializeUtils.readFile().split("\\W+");
        System.out.println(parser.countWorlds(worlds));
    }
}
