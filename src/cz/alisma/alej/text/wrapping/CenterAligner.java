import java.util.List;

public class CenterAligner implements Aligner {

    @Override
    public String format(List<String> words, int width) {
        String result = String.join(" ", words);
            int space = (width - result.length()) / 2; //rozdeli mezery jak na zacatek radku tak na konec, presne pul na pul
            if (space > 0) {
            String extraSpace = String.format("%"+space+"s", "");
            result = extraSpace + result;
        }
        return result;
    }

}
