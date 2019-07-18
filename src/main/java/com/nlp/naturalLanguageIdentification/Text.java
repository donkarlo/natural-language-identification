package com.nlp.naturalLanguageIdentification;

import java.util.ArrayList;

/**
 *
 * @author Mohammad Rahmani
 */
public class Text {

    protected String stringText;
    protected Lang guessedLang;

    public Text(String text) {
        this.stringText = text.toLowerCase().trim().replaceAll(" +", "_");;
    }

    public String getStringText() {
        return stringText;
    }

    public TextLangsScoresBank getNgramLangStores(LangCorpora lCorpora, int n) {
        TextLangsScoresBank textLangsScores = new TextLangsScoresBank(this);
        for (LangCorpus langcorpus : lCorpora.getLangCorpusArray()) {
            textLangsScores.addLangScore(langcorpus.getLang(), this.getNgramBelongingRate(langcorpus, n));
        }
        TextLangsScoresBank textLangsScoresSorted = new TextLangsScoresBank(this);
        
        return textLangsScores;
    }

    /**
     * 
     * @param lCorpora
     * @param n 
     */
    public void printNgramLangScoresDescendently(LangCorpora lCorpora, int n) {
        TextLangsScoresBank textLangsScores = this.getNgramLangStores(lCorpora, n);
        textLangsScores.sortScoresDescendently();
        for (LangScoreBankUnit lsbu : textLangsScores.getLangsScores()) {
            System.out.println(lsbu.getLang().getLocalName() + ": " + lsbu.getScore());
        }
    }
    
    

    /**
     *
     * @param n length of ngram
     * @return
     */
    public ArrayList<String> getNgrams(int n) {
        ArrayList<String> ngrams = new ArrayList<String>();
        for (int i = 0; i < this.stringText.length() - n + 1; i++) {
            ngrams.add(this.stringText.substring(i, i + n));
        }
        return ngrams;
    }

    /**
     * Gives Ngrams with frequencies of their Occurrences
     * @param n length of ngram
     * @return
     */
    public ArrayList<NgramFreq> getNgramFreqs(int n) {
        ArrayList<String> ngrams = this.getNgrams(n);
        ArrayList<NgramFreq> ngramFreqs = new ArrayList<NgramFreq>();
        for (String ngram : ngrams) {
            boolean alreadyAdded = false;
            for (int ngramFreqsCounter = 0; ngramFreqsCounter < ngramFreqs.size(); ngramFreqsCounter++) {
                if (ngram.equals(ngramFreqs.get(ngramFreqsCounter).getNgram())) {
                    ngramFreqs.get(ngramFreqsCounter).increaseFreqBy1();
                    alreadyAdded = true;
                    break;
                }
            }
            if (alreadyAdded == false) {
                NgramFreq newNgramFreq = new NgramFreq(ngram, 1);
                ngramFreqs.add(newNgramFreq);
            }
        }
        return ngramFreqs;
    }

    public int getLength() {
        return stringText.length();
    }

    public double getNgramBelongingRate(LangCorpus lCorpus, int n) {
        TextFromCorpusLiklihood likelihood = new TextFromCorpusLiklihood(this, lCorpus);
        return likelihood.getNgramLikelihood(n);
    }

    /**
     * Counts occurrences of a substring in a string
     * @param searchForStr
     * @return 
     */
    public int getSubStrCount(String searchForStr) {
        String toSearchStr = this.getStringText();
        if (toSearchStr.isEmpty() || toSearchStr == null || searchForStr.isEmpty() || searchForStr == null) {
            return 0;
        }
        int count = 0, subPrt = 0, subLength = searchForStr.length();
        for (char c : toSearchStr.toCharArray()) {
            if (searchForStr.charAt(subPrt) == c) {
                subPrt++;
                if (subPrt == subLength) {
                    count++;
                    subPrt = 0;
                }
            } else {
                if (c == searchForStr.charAt(0)) {
                    subPrt = 1;
                } else {
                    subPrt = 0;
                }
            }
        }
        return count;
    }
}
