package mx.uv.fiee.iinf.paradigmas.io;

import java.util.Locale;

public final class CsvSupport {
    private static final String HEADER = "id,fullName,groupName,city,age,average,scholarship";

    private CsvSupport() {
    }

    public static String header() {
        return HEADER;
    }

    public static String toCsvRow(Student student) {
        return String.join(",",
                String.valueOf(student.id()),
                escape(student.fullName()),
                escape(student.groupName()),
                escape(student.city()),
                String.valueOf(student.age()),
                String.format(Locale.US, "%.2f", student.average()),
                String.valueOf(student.scholarship()));
    }

    public static String escape(String value) {
        if (value == null) {
            return "";
        }

        boolean needsQuotes = value.contains(",") || value.contains("\"") || value.contains("\n") || value.contains("\r");
        String escapedValue = value.replace("\"", "\"\"");
        return needsQuotes ? '"' + escapedValue + '"' : escapedValue;
    }
}

