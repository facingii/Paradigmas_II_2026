package mx.uv.fiee.iinf.paradigmas.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class CsvExamples {

    private CsvExamples() {
    }

    public static Map<String, Path> generateAll(Path outputDirectory, List<Student> students) throws IOException {
        Files.createDirectories(outputDirectory);

        Map<String, Path> generatedFiles = new LinkedHashMap<>();

        Path fileOutputStreamFile = outputDirectory.resolve("students-file-output-stream.csv");
        writeWithFileOutputStream(fileOutputStreamFile, students);
        generatedFiles.put("1) FileOutputStream writing the whole CSV as UTF-8 bytes", fileOutputStreamFile);

        Path bufferedOutputStreamFile = outputDirectory.resolve("students-buffered-output-stream.csv");
        writeWithBufferedOutputStream(bufferedOutputStreamFile, students);
        generatedFiles.put("2) BufferedOutputStream writing one line at a time", bufferedOutputStreamFile);

        Path filesNewOutputStreamFile = outputDirectory.resolve("students-files-new-output-stream.csv");
        writeWithFilesNewOutputStream(filesNewOutputStreamFile, students);
        generatedFiles.put("3) Files.newOutputStream + OutputStreamWriter", filesNewOutputStreamFile);

        Path printStreamFile = outputDirectory.resolve("students-print-stream.csv");
        writeWithPrintStream(printStreamFile, students);
        generatedFiles.put("4) PrintStream formatting text on top of an OutputStream", printStreamFile);

        return Collections.unmodifiableMap(new LinkedHashMap<>(generatedFiles));
    }

    public static void writeWithFileOutputStream(Path file, List<Student> students) throws IOException {
        ensureParentDirectory(file);

        StringBuilder csv = new StringBuilder();
        appendCsvContent(csv, students);

        try (OutputStream outputStream = new FileOutputStream(file.toFile())) {
            outputStream.write(csv.toString().getBytes(StandardCharsets.UTF_8));
        }
    }

    public static void writeWithBufferedOutputStream(Path file, List<Student> students) throws IOException {
        ensureParentDirectory(file);

        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file.toFile()))) {
            writeLine(outputStream, CsvSupport.header());
            for (Student student : students) {
                writeLine(outputStream, CsvSupport.toCsvRow(student));
            }
        }
    }

    public static void writeWithFilesNewOutputStream(Path file, List<Student> students) throws IOException {
        ensureParentDirectory(file);

        try (OutputStream outputStream = Files.newOutputStream(
                file,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING,
                StandardOpenOption.WRITE);
             Writer writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8)) {
            writer.write(CsvSupport.header());
            writer.write(System.lineSeparator());
            for (Student student : students) {
                writer.write(CsvSupport.toCsvRow(student));
                writer.write(System.lineSeparator());
            }
        }
    }

    public static void writeWithPrintStream(Path file, List<Student> students) throws IOException {
        ensureParentDirectory(file);

        try (OutputStream outputStream = new FileOutputStream(file.toFile());
             PrintStream printStream = new PrintStream(outputStream, false, StandardCharsets.UTF_8)) {
            printStream.println(CsvSupport.header());
            for (Student student : students) {
                printStream.println(CsvSupport.toCsvRow(student));
            }
        }
    }

    private static void appendCsvContent(StringBuilder csv, List<Student> students) {
        csv.append(CsvSupport.header()).append(System.lineSeparator());
        for (Student student : students) {
            csv.append(CsvSupport.toCsvRow(student)).append(System.lineSeparator());
        }
    }

    private static void writeLine(OutputStream outputStream, String line) throws IOException {
        outputStream.write(line.getBytes(StandardCharsets.UTF_8));
        outputStream.write(System.lineSeparator().getBytes(StandardCharsets.UTF_8));
    }

    private static void ensureParentDirectory(Path file) throws IOException {
        Path parent = file.toAbsolutePath().getParent();
        if (parent != null) {
            Files.createDirectories(parent);
        }
    }
}



