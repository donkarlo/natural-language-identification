package com.nlp.naturalLanguageIdentification;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * This class chooses randomly n given sentences from a corpus different from
 * the one with which the system measures the likelihood.
 *
 * Not only should randomly select sentences but also should choose random size
 * of each language. This class supports both single word or sentences.
 *
 * @author Mohammad Rahmani
 */
public class EvaluateRandomTextSamples {

    /**
     * number of samples
     */
    private int sampleSize;
    /**
     * Available sample methods. You want sentences or words
     */
    private final static String[] AV_SAMPLE_TYPES = {"SENTENCE", "WORD"};

    private ArrayList<LangText> randomSampleLangsTexts = new ArrayList<LangText>();
    private ArrayList<LangTextPredictedLang> predictedLangsForRandomSampleLangsTexts = new ArrayList<LangTextPredictedLang>();

    private LangsFreqs langsFreqs = new LangsFreqs();

    /**
     *
     * @param nSample number of the samples
     */
    public EvaluateRandomTextSamples(int nSample) {
        this.sampleSize = nSample;
    }

    /**
     * Texts can be both words or sentences
     *
     * @return
     */
    public ArrayList<LangText> getRandomSampleLangsTexts() {
        for (int sentenceCounter = 1; sentenceCounter <= this.sampleSize; sentenceCounter++) {
            Lang randomLang = this.getARandomAvailableLang();
            try {
                LangText ltext = this.getRandomTextFromTestCorpusByLang(randomLang);
                this.randomSampleLangsTexts.add(ltext);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return this.randomSampleLangsTexts;
    }

    public ArrayList<LangTextPredictedLang> getPredictedLangsForSampleLangsTextsByNgramModel(LangCorpora langCorpora, int n) {
        int counter = 0;
        for (LangText langText : this.getRandomSampleLangsTexts()) {
            Text text = langText.getText();
            Lang predictedLang = new Lang(text.getMostProbableLangByNgram(langCorpora, n).getAlph2Id());
            LangTextPredictedLang langTextPredictedLang = new LangTextPredictedLang(langText, predictedLang);
            this.predictedLangsForRandomSampleLangsTexts.add(langTextPredictedLang);
        }
        return this.predictedLangsForRandomSampleLangsTexts;
    }

    /**
     *
     * @return
     */
    public LangsFreqs getLangsFreqsByNgram(LangCorpora langCorpora, int n) {
        for (LangTextPredictedLang langTextPredictedLang : this.getPredictedLangsForSampleLangsTextsByNgramModel(langCorpora, n)) {
            this.langsFreqs.addTotalFreqOfALangBy1(langTextPredictedLang.getLang());
            if (langTextPredictedLang.getPredictedLang().getAlph2Id() == langTextPredictedLang.getLang().getAlph2Id()) {
                this.langsFreqs.addCorrectPredictionFreqOfALangBy1(langTextPredictedLang.getLang());
            } else {
                this.langsFreqs.addWrongPredictionFreqOfALangBy1(langTextPredictedLang.getLang());
            }
        }
        return this.langsFreqs;
    }

    /**
     * A random available lang
     *
     * @return
     */
    private Lang getARandomAvailableLang() {
        ArrayList<Lang> availablelangs = LangCorporaFactorySingletone.getAvailableLangs();
        Random rand = new Random();
        Lang randomLang = availablelangs.get(rand.nextInt(availablelangs.size()));
        return randomLang;
    }

    /**
     *
     * @param lang
     * @return
     * @throws FileNotFoundException
     */
    private LangText getRandomTextFromTestCorpusByLang(Lang lang) throws FileNotFoundException {
        String pathToTestLangCorpus = LangCorporaFactorySingletone.getPathToCorporaTestSentencesDir() + lang.getAlph2Id() + ".txt";
        File f = new File(pathToTestLangCorpus);
        String result = null;
        Random rand = new Random();
        int n = 0;
        for (Scanner sc = new Scanner(f); sc.hasNext();) {
            ++n;
            String line = sc.nextLine();
            if (rand.nextInt(n) == 0) {
                result = line;
            }
        }
        LangText ltext = new LangText(result, lang);
        return ltext;
    }

}
