package com.nlp.naturalLanguageIdentification;

/**
 * To be used in cases such as the score by which a piece of text belongs to a corpus, so far it is used in TextLangScoresBank class
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
