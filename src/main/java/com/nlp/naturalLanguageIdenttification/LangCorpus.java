package com.nlp.naturalLanguageIdenttification;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Just for a corpus, composed of one source, such as a file path.
 *
 * @author Mohammad Rahmani
 */
public class LangCorpus extends Text {

    private Lang lang;
    private CorpusSource corpusSource;
    private ArrayList<NgramFreq> ngramFreqs;

    public LangCorpus(Lang lang, CorpusSource corpusSource) {
        super("");
        this.lang = lang;
        this.corpusSource = corpusSource;
    }

    public Lang getLang() {
        return lang;
    }

    public String getStringText() {
        try {
            return this.corpusSource.getText().getStringText();
        } catch (IOException ex) {
            Logger.getLogger(LangCorpus.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
