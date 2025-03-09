package textparser.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class SerializeUtils {
    public String readFile(String bookName) {
        try {
            File bookPath = new File("Lesson11/resources/" + bookName + ".txt");
            if (!Files.exists(bookPath.toPath())) {
                System.out.println("Книга не знайдена у директорії src/");
                return null;
            }
            return Files.readString(bookPath.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void writeStatistics(Map<String, Integer> listOfWords, int uniqueWords, String bookname) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("Lesson11/resources/" + bookname + "_statistic.txt"))) {
            for (Map.Entry<String, Integer> entry : listOfWords.entrySet()) {
                writer.write(entry.getKey() + " -> " + entry.getValue());
                writer.newLine();
            }
            writer.newLine();
            writer.newLine();
            writer.write("Unique Words: " + uniqueWords);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
