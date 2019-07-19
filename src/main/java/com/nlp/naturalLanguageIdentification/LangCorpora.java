package com.nlp.naturalLanguageIdentification;

import java.util.ArrayList;

/**
 * To deal with and array of LangCorpus
 * @author Mohammad Rahmani
 */
public class LangCorpora {

    /**
     * The array of existing corpus
     */
    private ArrayList<LangCorpus> corpusArray = new ArrayList<LangCorpus>();

    /**
     * Add a new corpus to existing corpus
     * @param corpus 
     */
    public void addCorpus(LangCorpus corpus) {
        this.corpusArray.add(corpus);
    }

    /**
     * Get the list of existing corpus
     * @return 
     */
    public ArrayList<LangCorpus> getLangCorpusArray() {
        return this.corpusArray;
    }
}
