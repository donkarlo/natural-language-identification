package com.nlp.naturalLanguageIdenttification;

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
        System.out.println("Enter your the text for language test: ");
        Scanner inputText = new Scanner(System.in);
        Text text = new Text(inputText.nextLine());
        
        System.out.println("Enter the number of characters for Ngram ");
        Scanner inputN = new Scanner(System.in);
        int n = Integer.parseInt(inputN.nextLine());
        
        text.printNgramLangScoresDescendently(LangCorporaFactorySingletone.getInst(), n);

    }
}
