package com.nlp.naturalLanguageIdentification;

/**
 * A LangCorpus holds information on its source and the dominant language in
 * which it is written
 *
 * @author Mohammad Rahmani
 */
public class LangCorpus extends Corpus {

    /**
     * The dominant language of the corpus
     */
    protected Lang lang;

    /**
     *
     * @param lang
     * @param corpusSource
     */
    public LangCorpus(Lang lang, CorpusSource corpusSource) {
        super(corpusSource);
        this.lang = lang;
    }

    /**
     *
     * @return
     */
    public Lang getLang() {
        return this.lang;
    }

}
