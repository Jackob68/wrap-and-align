import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class LinePrinter {
    private int width;
    private PrintStream output;
    private Aligner aligner;
    private List<String> words;

    public LinePrinter(PrintStream out, int w, Aligner align) {
        output = out;
        width = w;
        aligner = align;
        words = new ArrayList<>();
    }

    public void addWord(String word) {
        words.add(word);
    }

    public void flush() {
        int lengthSoFar = -1;
        List<String> line = new ArrayList<>();
        
        for (String word : words) {
            if (lengthSoFar + 1 + word.length() > width) {
                output.println(aligner.format(line));
                line.clear();
                lengthSoFar = -1;
            } else {
                lengthSoFar++;
            }
            line.add(word);
            lengthSoFar += word.length();
        }
        
        if (!line.isEmpty()) {
            output.println(aligner.format(line));
        }
    }

}
