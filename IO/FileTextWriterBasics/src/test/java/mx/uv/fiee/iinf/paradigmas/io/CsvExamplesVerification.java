package mx.uv.fiee.iinf.paradigmas.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class CsvExamplesVerification {
    public static void main(String[] args) throws IOException {
        int rows = 6;
        Path outputDirectory = Path.of("build", "verification-generated-csv");

        List<Student> students = StudentFactory.createStudents(rows);
        Map<String, Path> generatedFiles = CsvExamples.generateAll(outputDirectory, students);

        assertCondition(generatedFiles.size() == 4, "Four CSV examples should be generated.");

        for (Path csvFile : generatedFiles.values()) {
            assertCondition(Files.exists(csvFile), "The file should exist: " + csvFile);
            List<String> lines = Files.readAllLines(csvFile, StandardCharsets.UTF_8);
            assertCondition(lines.size() == rows + 1, "Unexpected number of lines in: " + csvFile);
            assertCondition(CsvSupport.header().equals(lines.get(0)), "Header mismatch in: " + csvFile);
            assertCondition(containsText(lines, "\"María, del Carmen\""),
                    "A comma-containing value should be escaped in: " + csvFile);
            assertCondition(containsText(lines, "\"Luis \"\"Lucho\"\" García\""),
                    "A quote-containing value should be escaped in: " + csvFile);
        }

        System.out.println("Verification successful: all CSV examples were generated correctly.");
    }

    private static void assertCondition(boolean condition, String message) {
        if (!condition) {
            throw new IllegalStateException(message);
        }
    }

    private static boolean containsText(List<String> lines, String expectedText) {
        for (String line : lines) {
            if (line.contains(expectedText)) {
                return true;
            }
        }
        return false;
    }
}

