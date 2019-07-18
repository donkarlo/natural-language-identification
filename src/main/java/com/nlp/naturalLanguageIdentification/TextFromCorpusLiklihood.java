package com.nlp.naturalLanguageIdentification;

import java.util.ArrayList;

/**
 *
 * @author Mohammad Rahmani
 */
public class TextFromCorpusLiklihood {

    private Text text;
    private LangCorpus langCorpus;

    public TextFromCorpusLiklihood(Text text, LangCorpus langCorpus) {
        this.text = text;
        this.langCorpus = langCorpus;
    }

    /**
     *
     * @param n
     * @return
     */
    public double getNgramLikelihood(int n) {

        ArrayList<String> ngrams = this.text.getNgrams(n);
        int countInCorpus = 0;
        for (String ngram : ngrams) {
            countInCorpus += this.langCorpus.getSubStrCount(ngram);
        }
        double likelihood = ((double) countInCorpus) /this.langCorpus.getStringText().length() ;
        return likelihood;
    }
}
