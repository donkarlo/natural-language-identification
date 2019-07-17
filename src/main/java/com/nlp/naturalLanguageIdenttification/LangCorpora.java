package com.nlp.naturalLanguageIdenttification;

import java.util.ArrayList;

/**
 *
 * @author Mohammad Rahmani
 */
public class LangCorpora {

    ArrayList<LangCorpus> corpusArray = new ArrayList<LangCorpus>();

    public void addCorpus(LangCorpus corpus) {
        this.corpusArray.add(corpus);
    }

    public ArrayList<LangCorpus> getLangCorpusArray() {
        return this.corpusArray;
    }
}
