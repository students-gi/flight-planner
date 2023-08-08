package io.codelex.flightplanner.utils;

public class StringFormatter {
    private StringFormatter() {
    }

    // https://www.baeldung.com/java-string-title-case
    public static String toTitleCase(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }

        StringBuilder converted = new StringBuilder();

        boolean convertNext = true;
        for (char ch : text.toCharArray()) {
            if (Character.isSpaceChar(ch)) {
                convertNext = true;
            } else if (convertNext) {
                ch = Character.toTitleCase(ch);
                convertNext = false;
            } else {
                ch = Character.toLowerCase(ch);
            }
            converted.append(ch);
        }

        return converted.toString();
    }
}
