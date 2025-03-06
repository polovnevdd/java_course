import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class SerializeUtils {
    public String readFile() {
        try {
            File bookPath = new File("Lesson11/resources/test_book.txt");
            return Files.readString(bookPath.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
