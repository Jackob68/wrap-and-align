package cz.alisma.alej.text.wrapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParagraphDetector {
    private Scanner input;
    private Paragraph nextPara;

    public ParagraphDetector(Scanner inp) {
        input = inp;
    }

    public boolean hasNextParagraph() {
        String line = "";
        while (input.hasNextLine()) {
            line = input.nextLine();
            if (!line.isEmpty()) {
                break;
            }
        }
        if (line.isEmpty()) {
            return false;
        }

        List<String> lines = new ArrayList<>();
        lines.add(line);

        while (input.hasNextLine()) {
            line = input.nextLine();
            if (line.isEmpty()) {
                break;
            }
            lines.add(line);
        }

        nextPara = new Paragraph(lines);
        return true;
    }
    
    public Paragraph nextParagraph() {
        return nextPara;
    }
}
