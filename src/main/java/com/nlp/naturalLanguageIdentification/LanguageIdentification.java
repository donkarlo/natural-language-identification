package com.nlp.naturalLanguageIdentification;

import java.util.Scanner;

/**
 * The bootstrap file
 *
 * @author Mohammad Rahamni
 */
public class LanguageIdentification {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean good = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, input 's' for single sentence check and 'e' for random evalution of many sentences from test corpora.");
        String singleOrEval = scanner.nextLine();
        if ("s".equals(singleOrEval)) {
            do {
                System.out.println("Enter the text for language test: ");
                Text text = new Text(scanner.nextLine());
                System.out.println("Enter the number of characters in Ngram: ");
                int n = Integer.parseInt(scanner.nextLine());
                text.printNgramLangScoresDescendently(LangCorporaFactorySingletone.getLangCorpora(), n);
                System.out.println("Another test?(y/n)");
                String goOn = scanner.nextLine();
                if ("y".equals(goOn)) {
                    good = true;
                } else {
                    good = false;
                }
            } while (good);
        } else {
            System.out.println("Please eneter the sizae of the sample. Try a number below 200 and please wait for 5 minutes.");
            int sampleSize= Integer.parseInt(scanner.nextLine());
            EvaluateRandomTextSamples evaluateRandomTextSamples = new EvaluateRandomTextSamples(sampleSize);
            System.out.println("Enter the number of characters in Ngram: ");
            int ngramForEval = Integer.parseInt(scanner.nextLine());
            LangsFreqs langsFreqs = evaluateRandomTextSamples.getLangsFreqsByNgram(LangCorporaFactorySingletone.getLangCorpora(), ngramForEval);
            langsFreqs.printReport();
        }

    }
}
