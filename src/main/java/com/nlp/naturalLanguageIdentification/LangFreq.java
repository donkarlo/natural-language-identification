package com.nlp.naturalLanguageIdentification;

/**
 *
 * @author Mohammad Rahmani
 */
public class LangFreq {

    private Lang lang;
    private int totalFreq;
    private int correctPredictionFreq;
    private int wrongPredictionFreq;

    public LangFreq(Lang lang) {
        this(lang, 0);
    }

    /**
     *
     * @param lang
     * @param totalFreq
     */
    public LangFreq(Lang lang, int totalFreq) {
        this.lang = lang;
        this.totalFreq = totalFreq;
    }

    /**
     *
     * @param lang
     * @param totalFreq
     * @param correctPredictionFreq
     */
    public LangFreq(Lang lang, int totalFreq, int correctPredictionFreq) {
        this(lang, totalFreq);
        this.correctPredictionFreq = correctPredictionFreq;
    }

    public LangFreq(Lang lang, int totalFreq, int correctPredictionFreq, int wrongPredictionFreq) {
        this(lang, totalFreq, correctPredictionFreq);
        this.correctPredictionFreq = correctPredictionFreq;
    }

    public Lang getLang() {
        return this.lang;
    }

    public int getTotalFreq() {
        return totalFreq;
    }

    public void setTotalFreq(int totalFreq) {
        this.totalFreq = totalFreq;
    }

    public void setCorrectPredictionFreq(int correctPredictionFreq) {
        this.correctPredictionFreq = correctPredictionFreq;
    }

    public void setWrongPredictionFreq(int wrongPredictionFreq) {
        this.wrongPredictionFreq = wrongPredictionFreq;
    }

    public int getCorrectPredictionFreq() {
        return correctPredictionFreq;
    }

    public int getWrongPredictionFreq() {
        return wrongPredictionFreq;
    }

    public double getCorrectRate() {
        return ((double) this.correctPredictionFreq) / this.totalFreq;
    }
    
    public double getWrongRate() {
        return ((double) this.wrongPredictionFreq) / this.totalFreq;
    }

}
