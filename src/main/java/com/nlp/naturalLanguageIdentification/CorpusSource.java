package com.nlp.naturalLanguageIdentification;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Mohammad Rahmani
 */
public class CorpusSource {

    /**
     * Available ID_TYPES
     */
    private static final String[] AV_ID_TYPES = {"FILE_PATH", "INPUT"};
    private String idType;
    /**
     * File path in case idType is FILE_PATH
     */
    private String detail;

    private Text text;

    public CorpusSource(String idType, String detail) {

        boolean avIdTypeExists = false;
        for (String avIdType : CorpusSource.AV_ID_TYPES) {
            if (idType == avIdType) {
                avIdTypeExists = true;
                this.idType = idType;
                this.detail = detail;
                break;
            }
        }
        if (avIdTypeExists == false) {
            System.out.println("No known source type found");
        }
    }

    public String getDetail() {
        return detail;
    }

    public Text getText() throws IOException {
        if (this.idType == "FILE_PATH") {
            BufferedReader reader = new BufferedReader(new FileReader(this.detail));
            String line = null;
            StringBuilder stringBuilder = new StringBuilder();
            String ls = System.getProperty("line.separator");

            try {
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                    stringBuilder.append(ls);
                }
                this.text = new Text(stringBuilder.toString());
                return this.text;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                reader.close();
            }
        }
        return null;
    }

}
