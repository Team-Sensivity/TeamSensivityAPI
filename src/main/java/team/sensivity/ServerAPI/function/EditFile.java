package team.sensivity.ServerAPI.function;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class EditFile {
    public static List<String> readFile(String file) throws IOException {
        Path filePath = Path.of(file);
        String s = Files.readString(filePath); //lest einen File als String ein
        List<String> lines = Files.readAllLines(filePath); //Gibt mir einen Stream der einzelnen Zeilen des Files.
        return lines;
    }

    public static void saveFile(List<String> s, String path) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        for (String s1: s) {
            writer.write(s1);
            writer.newLine();
        }
        writer.close();
    }
}
