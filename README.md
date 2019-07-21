# About Natural Language Identification application
 * This application is supposed to predict the best language from which a piece of text is derived. At the moment, it just supports character-level ngram predictions formed upon summation of frequency of successive ngrams of input text, against a small corpora of 3 languages (which is extensible as is later explained in README.md). Both text and numbers of characters in ngrams are supposed to be determined from command line at each execution of the program. Additionally it is capable of randomly picking sentences from different languages and run an evaluation test to present the results on accuracy of the model.  
 * At the moment, all is written in vanilla JAVA with no external library. The initial motivation for the project was to carry out an assignment by an institute which asked me not to use any library. Yet, in future, I am planning, to extend it to use Stanford CoreNLP for tasks such as tokenization. Although, so far, turned out to be excellent(check sample input at the end), yet, I don't encourage using it in serious application at this version. 
 * The method it uses at the moment, is to some extent similar to the following paper, bit is different in the sense that my solution build character-level ngrams of input size to determine the language or run the evaluation instead of a word-level solution. 
 > Vinsensius Berlian Vega and Stéphane Bressan. Continuous-Learning Weighted-Trigram Approach for Indonesian Language Distinction: A Preliminary Study. In Proceedings of 19th International Conference on Computer Processing of Oriental Languages (ICCPOL 2001), Seoul, Korea, 2001a. Oriental Languages Computer Society.

# Dependencies, compilation and running (installation commands are for Debian-based OS)
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
 * From here, to get a sorted list of languages from which a single piece of text is derived, input 's', otherwise, input e to evaluate the model on randomly picked sentences from files containing 10K news sentences of the available languages. 

 * For single text test, you will be first asked for a sentence to input, then for the lenth of the characters to build all the available character-level ngrams in the input. The output, presents the list of languages sorted by the most probable one for the given text to the least. A sample run is as follows:
```
	$ Please, type 's' to check single texts' language and 'e' to evaluate the model by checking it against randomly picked sentences from test corpora:
	> s
	$ Please type the text for language test: 
	> I wonder in what language this sentence is written.
	$ Please type the number of characters in ngram: 
	> 3
	$ English: 0.08593647027810729
	Deutsche: 0.060573135950020375
	français: 0.046464646464646465
	Another test?(y/n)
```
 * For the evaluation, you will be asked first to pick a sample size (at this time, please don't pick a sample size greater than 1000 if you can't wait for more than a couple of minutes), then you will be asked to pick for the number of characters in the ngram. Ultimately, you will be presented the numbers of sentences picked from each language and how many correct and wrong predictions the system made followed by their rate. A sample run is as follows:
 ```
	$ Please, type 's' to check single texts' language and 'e' to evaluate the model by checking it against randomly picked sentences from test corpora:
	> e
	$ Please type the size of the sample. Try a number below 1000 and please wait for 5 minutes.
	> 1000
	$ Please type the number of characters in ngram: 
	> 3
	$ Lang:  français, #samples: 351, #correct: 345, correct rate: 0.9829059829059829, #wrong: 6, wrong rate: 0.017094017094017096
	Lang:  Deutsche, #samples: 360, #correct: 360, correct rate: 1.0, #wrong: 0, wrong rate: 0.0
	Lang:  English, #samples: 289, #correct: 285, correct rate: 0.986159169550173, #wrong: 4, wrong rate: 0.01384083044982699
```  

# Corpora
 * At the moment the application, supports three languages: English, French and German, which are very short stories of around 7500 character. To manually add more languages, simply add a corpus to "data/corpora/training" with a file name which follows the following pattern "$xx.txt" ($xx must be replaced with 2 alphabet code of the language, such as en.txt, fr.txt, etc.). Then, in "src/main/java/com/nlp/naturalLanguageIdentification/LangCorporaFactorySingletone.java", in hardCodedSetting method, add the language which complies the pattern with the rest. That is, add a line of code such as: 
```
    LangCorporaFactorySingletone.inst.availableLangs.add(new Lang("es","Spanish","Español"));
``` 
* For evaluation, change directory to "data/corpora/test/sentences" and follow the same instructions to add a new language as mentioned for training. Currently 10k news sentences corpora of the aforementioned languages are used to pick random sentences of random sizes for evaluation. The current corpora are taken from 'Leipzig Corpora Collection' of 'Leipzig University' which is explained in detail in: 
> Dirk Goldhahn, Thomas Eckart, and Uwe Quasthoff. Building large monolingual
dictionaries at the leipzig corpora collection: From 100 to 200 languages. In
Proceedings of the Eighth International Conference on Language Resources
and Evaluation, LREC 2012, Istanbul, Turkey, May 23-25, 2012, pages 759–
765, 2012.

# Todo
 * Replace punctuations.
 * Improve the performance of the evaluation.
 * Extending the evaluation to single words.  