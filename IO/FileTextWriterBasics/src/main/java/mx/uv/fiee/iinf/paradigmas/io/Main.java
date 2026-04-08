package mx.uv.fiee.iinf.paradigmas.io;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        int rows = 120;
        Path outputDirectory = Path.of("generated-csv");

        List<Student> students = StudentFactory.createStudents(rows);
        Map<String, Path> generatedFiles = CsvExamples.generateAll(outputDirectory, students);

        System.out.println("CSV examples created successfully:");
        for (Entry<String, Path> entry : generatedFiles.entrySet()) {
            System.out.printf("- %s -> %s%n", entry.getKey(), entry.getValue().toAbsolutePath());
        }
    }
}
