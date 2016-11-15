package net.tlalka.java.hackerrank.interview;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DynamicTablesNoteTest {

    @Test
    public void testCorrectInput() {

        // given
        String[] input = "give me one grand today night".split(" ");
        String[] ransom = "give one grand today".split(" ");

        // when
        boolean result = HashTablesNote.isInputContainsText(input, ransom);

        // then
        assertTrue(result);
    }

    @Test
    public void testIncorrectInput() {

        // given
        String[] input = "give me one grand --- night".split(" ");
        String[] ransom = "give one grand today".split(" ");

        // when
        boolean result = HashTablesNote.isInputContainsText(input, ransom);

        // then
        assertFalse(result);
    }
}
