package com.nlp.naturalLanguageIdentification;

import java.util.Scanner;

/**
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

        do {
            System.out.println("Enter the text for language test: ");
            Text text = new Text(scanner.nextLine());
            System.out.println("Enter the number of characters in Ngram: ");
            int n = Integer.parseInt(scanner.nextLine());
            text.printNgramLangScoresDescendently(LangCorporaFactorySingletone.getInst(), n);
            System.out.println("Another test?(y/n)");
            String goOn = scanner.nextLine();
            if ("y".equals(goOn)) {
                good = true;
            } else {
                good = false;
            }
        } while (good);

    }
}
