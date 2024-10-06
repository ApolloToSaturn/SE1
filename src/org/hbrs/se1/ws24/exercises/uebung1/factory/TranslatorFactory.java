package org.hbrs.se1.ws24.exercises.uebung1.factory;


import org.hbrs.se1.ws24.exercises.uebung1.control.GermanTranslator;
import org.hbrs.se1.ws24.exercises.uebung1.control.Translator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TranslatorFactory {

    public static Translator createTranslator() {
        GermanTranslator translator = new GermanTranslator();
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("LLL/yyyy");
        translator.setDate(date.format(dateTimeFormatter));
        translator.printInfo();
        return translator;
    }
}
