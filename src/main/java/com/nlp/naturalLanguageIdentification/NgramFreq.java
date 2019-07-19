package com.nlp.naturalLanguageIdentification;

/**
 * To represent the frequency of an ngram in a piece of text
 * @author Mohammad Rahmani
 */
public class NgramFreq {

    /**
     * The ngram string itself
     */
    private String ngram;
    
    /**
     * The frequence
     */
    private int freq = 0;

    /**
     * Use when no frequency is yet determined to start by 0 as the initial value for the frequency
     * @param ngram 
     */
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

    /**
     * Increase the current frequency by 1
     * @return 
     */
    public boolean increaseFreqBy1() {
        this.freq++;
        return true;
    }
}
