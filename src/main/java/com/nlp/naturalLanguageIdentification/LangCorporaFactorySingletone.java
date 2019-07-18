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
     * it contains files with names such as $lang2alph.txt
     */
    private String pathToCorporaDir;
    /**
     * Cash to ...
     */
    private String pathToCashedNgramFreqsDir;

    private ArrayList<Lang> availableLangs;

    private LangCorpora langCorpora;

    /**
     * private constructor
     */
    private LangCorporaFactorySingletone() {
    }

    private static void hardCodedSetting() {

        if (LangCorporaFactorySingletone.inst == null) {
            LangCorporaFactorySingletone.inst = new LangCorporaFactorySingletone();
            LangCorporaFactorySingletone.inst.langCorpora = new LangCorpora();
            LangCorporaFactorySingletone.inst.availableLangs = new ArrayList<Lang>();

            LangCorporaFactorySingletone.inst.pathToCorporaDir = "data/corpora/";
            //add available langs from here

            LangCorporaFactorySingletone.inst.availableLangs.add(new Lang("en","English","English"));
            LangCorporaFactorySingletone.inst.availableLangs.add(new Lang("fr","French","français"));
            LangCorporaFactorySingletone.inst.availableLangs.add(new Lang("de","German","Deutsche"));
            
            for (Lang lang : LangCorporaFactorySingletone.inst.availableLangs) {
                LangCorpus corpus = new LangCorpus(lang, new CorpusSource("FILE_PATH", LangCorporaFactorySingletone.inst.pathToCorporaDir + lang.getAlph2Id() + ".txt"));
                LangCorporaFactorySingletone.inst.langCorpora.addCorpus(corpus);
            }
        }
    }

    final public static LangCorpora getInst() {
        LangCorporaFactorySingletone.hardCodedSetting();
        return LangCorporaFactorySingletone.inst.langCorpora;
    }
}
