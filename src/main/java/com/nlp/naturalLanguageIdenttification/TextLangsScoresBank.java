package com.nlp.naturalLanguageIdenttification;

import java.util.ArrayList;

/**
 *
 * @author Mohammad Rahmani
 */
public class TextLangsScoresBank {

    private Text text;
    private ArrayList<LangScoreBankUnit> langsScores = new ArrayList<LangScoreBankUnit>();

    public TextLangsScoresBank(Text text) {
        this.text = text;
    }

    public TextLangsScoresBank addLangScore(LangScoreBankUnit langScoreBankUnit) {
        this.langsScores.add(langScoreBankUnit);
        return this;
    }
    
    public TextLangsScoresBank addLangScore(Lang lang,double score) {
        LangScoreBankUnit langScoreBankUnit = new LangScoreBankUnit(lang, score);
        this.langsScores.add(langScoreBankUnit);
        return this;
    }

    public ArrayList<LangScoreBankUnit> getLangsScores() {
        return langsScores;
    }
    
    public void sortScoresDescendently(){
        this.langsScores.sort((LangScoreBankUnit o1, LangScoreBankUnit o2) -> {
            return Double.compare(o2.getScore(),o1.getScore());
        });
    }
    
}


