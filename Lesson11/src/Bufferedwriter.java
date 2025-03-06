import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Bufferedwriter {
    public static void main(String[] args) {
        try(BufferedWriter writer = Files.newBufferedWriter(Paths.get("Lesson11/resources/test.txt"))) {
            writer.write("line2");
            writer.newLine();
            writer.write("line3");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            File bookPath = new File("Lesson11/resources/test_book.txt");
            String content = Files.readString(bookPath.toPath());
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
