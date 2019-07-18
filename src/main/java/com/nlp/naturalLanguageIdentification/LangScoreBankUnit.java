package com.nlp.naturalLanguageIdentification;

/**
 *
 * @author Mohammad Rahmani
 */
class LangScoreBankUnit {

    private Lang lang;
    private double score;

    /**
     *
     * @param lang
     * @param score
     */
    public LangScoreBankUnit(Lang lang, double score) {
        this.lang = lang;
        this.score = score;
    }

    public Lang getLang() {
        return lang;
    }

    public double getScore() {
        return score;
    }

}
