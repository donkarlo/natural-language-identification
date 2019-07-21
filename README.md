# About Natural Language Identification application
 * This application is supposed to predict the best language from which a piece of text is derived. At the moment, it just supports character level ngram predictions formed upon sumation of frequency of successive ngrams of input text, against a small corpora of 3 languages (which is extendiable as is later explained in this README). Both text and numbers of characters in ngrams are supposed to be determined from command line at each execution of the program. 
 * At the moment, all is written in vanilla java with no external library. The initial motivation for the project was to carry out an assignment by an institute which asked me not to use any labrary. Yet, in future, I am planning, to extend it to use Stanford CoreNLP for tasks such as tokenization. Although, so far, I had never faced a false language prediction by this simple application to predict the base language, yet, I don't encourage using it in serious application at this version. 
 * The method it uses at the moment, is to some extent similar to the following paper, which is different in the sense that it uses trigram words. I modified it to trigram characters since, I wanted to use a very small corpus of around 700 words for each language: 
 > Vinsensius Berlian Vega and Stéphane Bressan. Continuous-Learning Weighted-Trigram Approach for Indonesian Language Distinction: A Preliminary Study. In Proceedings of 19th International Conference on Computer Processing of Oriental Languages (ICCPOL 2001), Seoul, Korea, 2001a. Oriental Languages Computer Society.

# Dependencies, compilation and running (installations commands are for debian based OS)
 * Java 1.8+
```
    $ sudo sudo apt-get install openjdk-8-jdk
```
 * install Maven:
```
    $ sudo apt-get install maven
```
 * clone the project from the git repository or simply copy it to a directory such as /path/to/project    
```
    $ git clone https://github.com/donkarlo/natural-language-identification
    $ cd /path/to/project/natural-language-identification
    $ mvn clean install
    $ mvn compile
    $ mvn clean package
    $ java -cp target/natural-language-identification-1.0-snapshot.jar com.nlp.naturalLanguageIdentification.LanguageIdentification
 ```
 * From here you will be asked for the piece of text for which you want to check the language followed by the number of characters in each ngrams. Then you will be presented a list of languages to which the text belongs ordered by the highest ranked one. 
 * At the moment the system supports three languages (English, French and German). To manually add more languages, simply add a corpus to "data/corpora/" with a file name which follows this pattern $xx.txt ($xx must be relaced with 2 alphabet code of the language, such as en.txt, fr.txt, etc.), then in src/main/java/com/nlp/naturalLanguageIdentification/LangCorporaFactorySingletone.java, in hardCodedSetting methos, add the language which complies the pattern with the rest. That is, add a line of code such as the following code. 
```
    LangCorporaFactorySingletone.inst.availableLangs.add(new Lang("es","Spanish","Español"));
``` 

# Todo
 * replace puntuations
 * Extend langCorpus and LangCorpora from LangText
