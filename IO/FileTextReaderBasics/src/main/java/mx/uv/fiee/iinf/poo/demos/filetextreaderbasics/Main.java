package mx.uv.fiee.iinf.poo.demos.filetextreaderbasics;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {

    private static final Path FILE_PATH = Path.of ("data", "Kyoto_Restaurant_Info.csv");


    static void main () throws IOException {
        System.out.println ("=== 1. Files.readString (Java 11+) ===");
        readWithFilesReadString ();

        System.out.println ("=== 2. Files.readAllLines + String.join (Java 8+) ===");
        readWithFilesReadAllLines ();

        System.out.println ("=== 3. Files.readAllBytes (Java 7+) ===");
        readWithFilesReadAllBytes ();

        System.out.println ("=== 4. Files.newBufferedReader + var (Java 10+) ===");
        readWithFilesNewBufferedReader ();

        System.out.println ("=== 5. InputStream.transferTo (Java 9+) ===");
        readWithTransferTo ();

        System.out.println ("=== 6. InputStream.readAllBytes (Java 9+) ===");
        readWithInputStreamReadAllBytes ();

        System.out.println ("=== 7. Scanner with unnamed variable _ (Java 22+) ===");
        readWithScanner ();

        System.out.println ("=== 8. BufferedReader classic with try-with-resources ===");
        readWithTryWithResources ();
    }

    private static void readWithFilesReadString () throws IOException {
        var content = Files.readString (FILE_PATH);
        System.out.println (content);
    }

    private static void readWithFilesReadAllLines () throws IOException {
        var lines = Files.readAllLines (FILE_PATH, StandardCharsets.UTF_8);
        var content = String.join ("\n", lines);
        System.out.println (content);
    }

    private static void readWithFilesReadAllBytes () throws IOException {
        var bytes = Files.readAllBytes (FILE_PATH);
        var content = new String (bytes, StandardCharsets.UTF_8);
        System.out.println (content);
    }

    private static void readWithFilesNewBufferedReader () throws IOException {
        try (var br = Files.newBufferedReader (FILE_PATH, StandardCharsets.UTF_8)) {
            var builder = new StringBuilder ();
            for (String line; (line = br.readLine ()) != null; ) {
                builder.append (line).append ("\n");
            }
            System.out.println (builder);
        }
    }


    private static void readWithTransferTo () throws IOException {
        try (var is = Files.newInputStream (FILE_PATH);
             var baos = new ByteArrayOutputStream ()) {
            is.transferTo (baos);
            var content = baos.toString (StandardCharsets.UTF_8);
            System.out.println (content);
        }
    }

    private static void readWithInputStreamReadAllBytes () throws IOException {
        try (var is = Files.newInputStream (FILE_PATH)) {
            var bytes = is.readAllBytes ();
            var content = new String (bytes, StandardCharsets.UTF_8);
            System.out.println (content);
        }
    }

    private static void readWithScanner () throws IOException {
        try (var scanner = new Scanner (FILE_PATH, StandardCharsets.UTF_8)) {
            var builder = new StringBuilder ();
            while (scanner.hasNextLine ()) {
                var _ = builder.append (scanner.nextLine ()).append ("\n");
            }
            System.out.println (builder);
        }
    }

    private static void readWithTryWithResources () throws IOException {
        try (var br = new BufferedReader (new FileReader (FILE_PATH.toFile ()))) {
            var builder = new StringBuilder ();
            for (String line; (line = br.readLine ()) != null; ) {
                builder.append (line).append ("\n");
            }
            System.out.println (builder);
        }
    }

}
