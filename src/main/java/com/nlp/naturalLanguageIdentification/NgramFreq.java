package com.nlp.naturalLanguageIdentification;

/**
 *
 * @author Mohammad Rahmani
 */
public class NgramFreq {

    private String ngram;
    private int freq = 0;

    public NgramFreq(String ngram) {
        this(ngram, 0);
    }

    public NgramFreq(String ngram, int freq) {
        this.ngram = ngram;
        this.freq = freq;
    }

    public String getNgram() {
        return ngram;
    }

    public int getFreq() {
        return freq;
    }

    public boolean increaseFreqBy1() {
        this.freq++;
        return true;
    }
}
