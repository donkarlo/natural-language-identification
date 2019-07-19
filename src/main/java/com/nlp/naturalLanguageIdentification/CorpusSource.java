package com.nlp.naturalLanguageIdentification;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Holding information on corpus source(file,database) and offers solutions on how to grab it as a variable to the system. 
 * @author Mohammad Rahmani
 */
public class CorpusSource {

    /**
     * Available ID_TYPES
     */
    private static final String[] AV_ID_TYPES = {"FILE_PATH", "INPUT","RDBMS"};
    
    /**
     * An option among what AV_ID_TYPES offers to indicate what is the nature of the source
     */
    private String idType;
    /**
     * File path, in case idType is FILE_PATH, in other cases it might appear as a JSON string e.g. to present connection data to connect a database
     */
    private String detail;

    /**
     * The in-app text, retrieved from the solution offered by idType
     */
    private Text text;

    /**
     * 
     * @param idType
     * @param detail 
     */
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

    /**
     * 
     * @return 
     */
    public String getDetail() {
        return detail;
    }

    /**
     * To retrieve the text from the source.
     * @return
     * @throws IOException 
     */
    public Text getText() throws IOException {
        /**
         * if the source points to a file on the hosting system
         */
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
