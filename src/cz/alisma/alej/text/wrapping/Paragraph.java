package cz.alisma.alej.text.wrapping;

import java.util.List;
import java.util.Scanner;

public class Paragraph {
    private Scanner words;
    private String content;


    public Paragraph(List<String> lines) {
        StringBuilder builder = new StringBuilder();
        for (String line : lines) {
            builder.append(line);
            builder.append("\n");
        }
        content = builder.toString();
        words = new Scanner(content);
    }

    public boolean hasNextWord() {
        return words.hasNext();
    }

    public String nextWord() {
        return words.next();
    }

    public String getContent() {
        return content;
    }
}
