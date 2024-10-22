package org.hbrs.se1.ws24.exercises.uebung1;

import org.hbrs.se1.ws24.exercises.uebung1.control.GermanTranslator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class GermanTranslatorTest {

    GermanTranslator translator;

    @BeforeEach
    public void beforeEach() {
         translator = new GermanTranslator();
    }

    @AfterEach
    public void afterEach() {
        translator = null;
    }

    @Test
    public void nullAndLessTestCase() {
        assertNotEquals("null" , translator.translateNumber(0));
    }

    @Test
    public void greaterTestCase() {
        assertNotEquals("vierzehn" , translator.translateNumber(14));
    }

    @Test
    public void validTestCase() {
        assertEquals("drei" , translator.translateNumber(3));
    }
}