package com.nlp.naturalLanguageIdentification;

import java.util.*;

/**
 * To build Corpora
 *  @todo cash mechanism 
 *
 * @author Mohammad Rahmani
 */
public class LangCorporaFactorySingletone {

    private static LangCorporaFactorySingletone inst;
    /**
     * it contains files with names such as $lang2alph.txt for training
     */
    private String pathToCorporaTrainingDir;
    
    /**
     * it contains files with names such as $lang2alph.txt for benchmark testing
     */
    private String pathToCorporaTestSentencesDir;

    /**
     * List of languages for which training corpus exists
     */
    private ArrayList<Lang> availableLangs;

    /**
     * The training corpora
     */
    private LangCorpora langCorpora;

    /**
     * private constructor
     */
    private LangCorporaFactorySingletone() {
    }

    /**
     * The settings which should be removed to a text or database in future
     * @todo move to a database in future
     */
    private static void hardCodedSetting() {

        if (LangCorporaFactorySingletone.inst == null) {
            LangCorporaFactorySingletone.inst = new LangCorporaFactorySingletone();
            LangCorporaFactorySingletone.inst.langCorpora = new LangCorpora();
            LangCorporaFactorySingletone.inst.availableLangs = new ArrayList<Lang>();

            LangCorporaFactorySingletone.inst.pathToCorporaTrainingDir = "data/corpora/training/";
            LangCorporaFactorySingletone.inst.pathToCorporaTestSentencesDir = "data/corpora/test/sentences/";
            //add available langs from here

            LangCorporaFactorySingletone.inst.availableLangs.add(new Lang("en","English","English"));
            LangCorporaFactorySingletone.inst.availableLangs.add(new Lang("fr","French","français"));
            LangCorporaFactorySingletone.inst.availableLangs.add(new Lang("de","German","Deutsche"));
            
            for (Lang lang : LangCorporaFactorySingletone.inst.availableLangs) {
                LangCorpus corpus = new LangCorpus(lang, new CorpusSource("FILE_PATH", LangCorporaFactorySingletone.inst.pathToCorporaTrainingDir + lang.getAlph2Id() + ".txt"));
                LangCorporaFactorySingletone.inst.langCorpora.addCorpus(corpus);
            }
        }
    }

    /**
     * Get a new Instance of the settings
     * @return 
     */
    final public static LangCorporaFactorySingletone getInst() {
        LangCorporaFactorySingletone.hardCodedSetting();
        return LangCorporaFactorySingletone.inst;
    }
    
    final public static LangCorpora getLangCorpora() {
        return LangCorporaFactorySingletone.getInst().langCorpora;
    }
    
    public final static ArrayList<Lang> getAvailableLangs(){
        return LangCorporaFactorySingletone.getInst().availableLangs;
    }
    
    public final static String getPathToCorporaTestSentencesDir(){
        return LangCorporaFactorySingletone.getInst().pathToCorporaTestSentencesDir;
    }
}
