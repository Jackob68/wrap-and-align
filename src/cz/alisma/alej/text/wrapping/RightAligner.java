package cz.alisma.alej.text.wrapping;

import java.util.List;

//zarovnavání slov do prava => doplnění mezer před text
public class RightAligner implements Aligner {

    @Override
    public String format(List<String> words, int width) {
        String result = String.join(" ", words);
        return String.format("%"+width+"s", result);
    }

}
