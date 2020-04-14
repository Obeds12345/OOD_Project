import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Tools {
    public static Path getPathForIsoFile() throws URISyntaxException {
        return Paths.get(ClassLoader.getSystemResource("ISO.txt").toURI());
    }
}
