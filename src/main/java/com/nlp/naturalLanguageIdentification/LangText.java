package com.nlp.naturalLanguageIdentification;

/**
 *
 * @author Mohammad Rahmani
 */
public class LangText extends Text {

    private Lang lang;

    public LangText(String stringText, Lang lang) {
        super(stringText);
        this.lang = lang;
    }

    public LangText(Text text, Lang lang) {
        super(text.getStringText());
        this.lang = lang;
    }

    public Lang getLang() {
        return lang;
    }

    public Text getText() {
        Text text = new Text(this.getStringText());
        return text;
    }

}
