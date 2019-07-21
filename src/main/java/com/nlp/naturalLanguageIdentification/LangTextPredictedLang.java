package com.nlp.naturalLanguageIdentification;

/**
 *
 * @author Mohammad Rahmani
 */
public class LangTextPredictedLang extends LangText {
    
    private Lang predictedLang;
    
    public LangTextPredictedLang(String text, Lang lang, Lang predictedLang) {
        super(text, lang);
        this.predictedLang = predictedLang;
    }
    
    public LangTextPredictedLang(String text, Lang lang) {
        super(text, lang);
    }
    
    public LangTextPredictedLang(LangText ltext) {
        super(ltext.getStringText(), ltext.getLang());
    }

    public LangTextPredictedLang(LangText ltext, Lang predictedLang) {
        super(ltext.getStringText(), ltext.getLang());
        this.setPredictedLang(predictedLang);
    }
    
    public void setPredictedLang(Lang predictedLang) {
        this.predictedLang = predictedLang;
    }

    public Lang getPredictedLang() {
        return predictedLang;
    }
    
    
}
