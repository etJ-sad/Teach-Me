package de.hsworms.inf3032.data.constant;

import java.util.Arrays;
import java.util.List;

public class GlobalContentConstant {

    public static final List<String> ENGLISH_TREE = Arrays.asList(
            "C++ Basics",
            "C++ Object Oriented",
            "Operating System",
            "Java Basics",
            "Java Advanced",
            "DSA Basics",
            "DSA Advanced",
            "Java 9"

    );

    public static final List<String> ENGLISH_INTERVIEW_TREE = Arrays.asList(
            "Java Interview Questions",
            "C++ Interview Questions",
            "Operating System Questions",
            "DSA Interview Questions"
    );


    public static final List<String> GERMAN_TREE = Arrays.asList(
            "Objektorientiertes Programmieren in Java",
            "Objektorientiertes Programmieren mit C++"
    );

    public static final List<String> GERMAN_INTERVIEW_TREE = Arrays.asList(
            "C++ Basics"

    );


    public static final List<String> RUSSIAN_TREE = Arrays.asList(
            "Russian 1",
            "Russian 2",
            "Russian 3"
    );

    public static final List<String> RUSSIAN_INTERVIEW_TREE = Arrays.asList(
            "C++ Basics"

    );


    // content file
    public static final String COMPUTER_SCINCE_CONTENT_FILE_EN = "json/content/Computer science/CS_EnglishContentFile.json";
    public static final String COMPUTER_SCINCE_CONTENT_FILE_RU = "json/content/Computer science/CS_RussianContentFile.json";
    public static final String COMPUTER_SCINCE_CONTENT_FILE_DE = "json/content/Computer science/CS_GermanContentFile.json";

    public static final String MATHS_CONTENT_FILE_EN = "json/content/Mobile Computing/MC_EnglishContentFile.json";
    public static final String MATHS_CONTENT_FILE_RU = "json/content/Mobile Computing/MC_RussianContentFile.json";
    public static final String MATHS_CONTENT_FILE_DE = "json/content/Mobile Computing/MC_GermanContentFile.json";

    public static final String LINGUISTICS_CONTENT_FILE_EN = "json/content/Linguistics/LI_EnglishContentFile.json";
    public static final String LINGUISTICS_CONTENT_FILE_RU = "json/content/Linguistics/LI_RussianContentFile.json";
    public static final String LINGUISTICS_CONTENT_FILE_DE = "json/content/Linguistics/LI_GermanContentFile.json";

    public static final String JSON_KEY_ITEMS = "items";
    public static final String JSON_KEY_TITLE = "title";
    public static final String JSON_KEY_CONTENT = "content";
    public static final String JSON_KEY_TAG_LINE = "tag_line";
    public static final String JSON_KEY_DETAILS = "details";

    public static final String JSON_KEY_QUESTIONNAIRY = "questionnaires";
    public static final String JSON_KEY_QUESTION = "question";
    public static final String JSON_KEY_CORRECT_ANS = "correct_answer";
    public static final String JSON_KEY_ANSWERS = "answers";

    public static final String TTS_LOCALE_EN = "en_US";
    public static final String TTS_LOCALE_RU = "ru_RU";
    public static final String TTS_LOCALE_DE = "de_DE";


}
