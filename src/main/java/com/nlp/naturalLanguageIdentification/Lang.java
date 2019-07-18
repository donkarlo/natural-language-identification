package com.nlp.naturalLanguageIdentification;

/**
 *
 * @author Mohammad Rahmani
 */
public class Lang {
    private String alph2Id;
    private String enName;
    private String localName;

    public Lang(String alph2Id) {
        this.alph2Id = alph2Id;
    }

    public Lang(String alph2Id, String enName, String localName) {
        this.alph2Id = alph2Id;
        this.enName = enName;
        this.localName = localName;
    }

    public String getAlph2Id() {
        return alph2Id;
    }

    public String getEnName() {
        return enName;
    }

    public String getLocalName() {
        return localName;
    }
    
    
}
