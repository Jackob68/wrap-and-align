package cz.alisma.alej.text.wrapping;

import java.util.List;

public class JustifyAligner implements Aligner {

    @Override
    public String format(List<String> words, int width) {
        if (words.size() < 2) {
            return String.join(" ", words);
        }

        int space = width;
        for (String word : words) {
            space -= word.length(); //diky tomuto zjistim kolik potrebuju mezer
        }

        int gapWidth = space / (words.size() - 1);
        int remainder = space % (words.size() - 1);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            result.append(words.get(i));
            if (i == words.size() - 1) {
                break;
            }

            if (remainder > 0) {
                result.append(String.format("%"+(gapWidth+1)+"s", ""));
                remainder--;
            } else {
                result.append(String.format("%"+gapWidth+"s", ""));
            }
        }
        return result.toString();
    }
}
