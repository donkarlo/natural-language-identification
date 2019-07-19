package com.nlp.naturalLanguageIdentification;

import java.util.ArrayList;

/**
 * Stores the scores by which a text belongs to a list of corpus
 * @author Mohammad Rahmani
 */
public class TextLangsScoresBank {

    /**
     * The text itself
     */
    private Text text;
    /**
     * An array the lang-scores
     */
    private ArrayList<LangScoreBankUnit> langsScores = new ArrayList<LangScoreBankUnit>();

    public TextLangsScoresBank(Text text) {
        this.text = text;
    }

    /**
     * Add a nes lang-score
     * @param langScoreBankUnit
     * @return 
     */
    public TextLangsScoresBank addLangScore(LangScoreBankUnit langScoreBankUnit) {
        this.langsScores.add(langScoreBankUnit);
        return this;
    }
    
    /**
     * Add a lang-score from scratch, no need to define new LangScoreBankUnit in client code. A shortcut.
     * @param lang
     * @param score
     * @return 
     */
    public TextLangsScoresBank addLangScore(Lang lang,double score) {
        LangScoreBankUnit langScoreBankUnit = new LangScoreBankUnit(lang, score);
        this.langsScores.add(langScoreBankUnit);
        return this;
    }

    public ArrayList<LangScoreBankUnit> getLangsScores() {
        return langsScores;
    }
    
    /**
     * Sort the lang-scores Descendently
     */
    public void sortScoresDescendently(){
        this.langsScores.sort((LangScoreBankUnit o1, LangScoreBankUnit o2) -> {
            return Double.compare(o2.getScore(),o1.getScore());
        });
    }
    
}


