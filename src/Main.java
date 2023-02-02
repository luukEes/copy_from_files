import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.StringBuilder;
public class Main {
    public static void readFromFile(String fileName) {
        Scanner scanner = new Scanner(fileName);
        try {
            Path pierwszyPlik = Paths.get(fileName);
            Path drugiPlik = Paths.get(fileName + ".html");
            List<String> outList = new ArrayList<>();
            if (Files.exists(pierwszyPlik)) {
                for (String line: Files.readAllLines(pierwszyPlik)) {
                    outList.add(line + ">");
                    Files.write(drugiPlik,outList);
                }
            }
            else {
                System.out.println("plik nie istnieje");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws Exception {
        readFromFile("read.txt");
    }
}
