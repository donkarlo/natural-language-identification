package com.nlp.naturalLanguageIdentification;

import java.util.ArrayList;

/**
 *
 * @author Mohammad Rahmani
 */
public class LangsFreqs {

    private ArrayList<LangFreq> langsFreqs = new ArrayList<LangFreq>();

    public LangsFreqs() {
    }

    public void addLangFreq(LangFreq langFreq) {
        this.langsFreqs.add(langFreq);
    }

    /**
     *
     * @param lang
     */
    public void addTotalFreqOfALangBy1(Lang lang) {
        boolean langFound = false;
        int langCounter = 0;
        for (LangFreq langFreq : this.langsFreqs) {
            if (lang.getAlph2Id() == langFreq.getLang().getAlph2Id()) {
                langFound = true;
                int totalFreq = this.langsFreqs.get(langCounter).getTotalFreq() + 1;
                this.langsFreqs.get(langCounter).setTotalFreq(totalFreq);
                break;
            }
            langCounter += 1;
        }
        if (!langFound) {
            LangFreq langFreq = new LangFreq(lang, 1, 0, 0);
            this.langsFreqs.add(langFreq);
        }
    }

    /**
     *
     * @param lang
     */
    public void addCorrectPredictionFreqOfALangBy1(Lang lang) {
        boolean langFound = false;
        int langCounter = 0;
        for (LangFreq langFreq : this.langsFreqs) {
            if (lang.getAlph2Id() == langFreq.getLang().getAlph2Id()) {
                langFound = true;
                int correctFreq = this.langsFreqs.get(langCounter).getCorrectPredictionFreq() + 1;
                this.langsFreqs.get(langCounter).setCorrectPredictionFreq(correctFreq);
                break;
            }
            langCounter += 1;
        }
        if (!langFound) {
            LangFreq langFreq = new LangFreq(lang, 1, 1, 0);
            this.langsFreqs.add(langFreq);
        }
    }

    /**
     *
     * @param lang
     */
    public void addWrongPredictionFreqOfALangBy1(Lang lang) {
        boolean langFound = false;
        int langCounter = 0;
        for (LangFreq langFreq : this.langsFreqs) {
            if (lang.getAlph2Id() == langFreq.getLang().getAlph2Id()) {
                langFound = true;
                int wrongFreq = this.langsFreqs.get(langCounter).getWrongPredictionFreq() + 1;
                this.langsFreqs.get(langCounter).setWrongPredictionFreq(wrongFreq);
                break;
            }
            langCounter += 1;
        }
        if (!langFound) {
            LangFreq langFreq = new LangFreq(lang, 1, 0, 1);
            this.langsFreqs.add(langFreq);
        }
    }

    public void printReport() {
        for (LangFreq langFreq : this.langsFreqs) {
            String printString = "Lang: " + " " + langFreq.getLang().getLocalName() + " ";
            printString += "# samples: " + langFreq.getTotalFreq() + " ";
            printString += "# correct: " + langFreq.getCorrectPredictionFreq() + " ";
            printString += "correct rate: " + langFreq.getCorrectRate() + " ";
            printString += "# wrong: " + langFreq.getWrongPredictionFreq() + " ";
            printString += "wrong rate: " + langFreq.getWrongRate() + " ";
            System.out.println(printString);
        }
    }

    public ArrayList<LangFreq> getLangsFreqs() {
        return langsFreqs;
    }
}
