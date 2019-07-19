package com.nlp.naturalLanguageIdentification;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A LangCorpus holds information on its source and the dominant language in which it is written
 *
 * @author Mohammad Rahmani
 */
public class LangCorpus extends Text {

    /**
     * The dominant language of the corpus
     */
    private Lang lang;
    /**
     * The source of the language
     */
    private CorpusSource corpusSource;

    /**
     * 
     * @param lang
     * @param corpusSource 
     */
    public LangCorpus(Lang lang, CorpusSource corpusSource) {
        super("");
        this.lang = lang;
        this.corpusSource = corpusSource;
    }

    /**
     * 
     * @return 
     */
    public Lang getLang() {
        return this.lang;
    }

    /**
     * Get the string representing the text to which the corpus is pointing
     * @return 
     */
    public String getStringText() {
        try {
            return this.corpusSource.getText().getStringText();
        } catch (IOException ex) {
            Logger.getLogger(LangCorpus.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
