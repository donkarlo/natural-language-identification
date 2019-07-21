package com.nlp.naturalLanguageIdentification;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mohammad
 */
public class Corpus extends Text {

    /**
     * The source of the language
     */
    protected CorpusSource corpusSource;

    public Corpus(CorpusSource corpusSource) {
        super("");
        this.corpusSource = corpusSource;
    }

    /**
     * Get the string representing the text to which the corpus is pointing
     *
     * @return
     */
    @Override
    public String getStringText() {
        try {
            return this.corpusSource.getText().getStringText();
        } catch (IOException ex) {
            Logger.getLogger(LangCorpus.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
