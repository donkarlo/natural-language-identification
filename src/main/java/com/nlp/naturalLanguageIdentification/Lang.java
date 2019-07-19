package com.nlp.naturalLanguageIdentification;

/**
 * A language 2-alphabet code, it's local and English name
 * @author Mohammad Rahmani
 */
public class Lang {
    /**
     * 2-alphabet code such as en, fr, ...
     */
    private String alph2Id;
    /**
     * English name such as French, German, ...
     */
    private String enName;
    
    /**
     * The local name such as Francais, Deutch,...
     */
    private String localName;

    /**
     * 
     * @param alph2Id 
     */
    public Lang(String alph2Id) {
        this.alph2Id = alph2Id;
    }

    /**
     * 
     * @param alph2Id
     * @param enName
     * @param localName 
     */
    public Lang(String alph2Id, String enName, String localName) {
        this.alph2Id = alph2Id;
        this.enName = enName;
        this.localName = localName;
    }

    /**
     * 
     * @return 
     */
    public String getAlph2Id() {
        return alph2Id;
    }

    /**
     * 
     * @return 
     */
    public String getEnName() {
        return enName;
    }

    /**
     * 
     * @return 
     */
    public String getLocalName() {
        return localName;
    }
    
    
}
