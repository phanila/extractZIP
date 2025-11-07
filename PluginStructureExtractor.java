import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.zip.*;

public class PluginStructureExtractor {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Usage: java PluginStructureExtractor <input.jar/zip> <output.txt>");
            return;
        }

        String inputPath = args[0];
        String outputPath = args[1];

        Set<String> entries = new TreeSet<>();

        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(inputPath))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (!entry.isDirectory()) {
                    entries.add(entry.getName());
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found: " + inputPath);
            return;
        }

        Files.write(Paths.get(outputPath), entries);
        System.out.println("Extracted " + entries.size() + " entries to " + outputPath);
    }
}
