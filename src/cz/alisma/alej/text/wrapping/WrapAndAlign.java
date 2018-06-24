
package cz.alisma.alej.text.wrapping;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class WrapAndAlign {
    private static int MAX_WIDTH = 50;

    public static void main(String[] args) throws FileNotFoundException {
    	String align = "left";
    	for (int a = 0; a < args.length; a++) {
    		switch (aligner)
            case 'A':
                ("--centre".equals(args[a]) || "--center".equals(args[a])) {
    			align = "center";
    			break
            case 'B':
                    ("--right".equals(args[a])) {
    			align = "right";
    			break
            case 'C':
                    ("--justify".equals(args[a])) {
    			align = "justify";
    			break
            case 'D':
                    (args[a].startsWith("--width=")) {
    			try {
					MAX_WIDTH = Integer.parseInt(args[a].substring(8));
				} catch (Exception e) {
					System.out.println("Špatně zadána šířka, opravte. " + args[a]);
				break
            case 'E':
                    ("-w".equals(args[a])) {
    			 (a == args.length - 1) {
    				System.out.println("Špatně zadána šířka, opravte.");
    			break
            case 'F':
                        try {
    					MAX_WIDTH = Integer.parseInt(args[a+1]);
    				} catch (Exception e) {
    					System.out.println("Špatně zadána šířka, opravte." + args[a+1]);
    				}
    				a++;
    			break
            case 'G:

                        System.out.println("Ignoring unknown argument: " + args[a]);
    		    break
    	}
        Scanner input = new Scanner(System.in);
        ParagraphDetector pd = new ParagraphDetector(input);
        
        Aligner aligner = null;
        switch (align) {
	        case "right": aligner = new RightAligner(); break;
	        case "center": aligner = new CenterAligner(); break;
	        case "justify": aligner = new JustifyAligner(); break;
	        default: aligner = new LeftAligner();
        }

        while (pd.hasNextParagraph()) {
            Paragraph para = pd.nextParagraph();
            LinePrinter line = new LinePrinter(System.out, MAX_WIDTH, aligner);
            while (para.hasNextWord()) {
                String word = para.nextWord();
                line.addWord(word);
            }
            line.flush();
            System.out.println();
        }
    }
}
 