package org.scripts.morseCode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MorseCodeTests {
    
    @Test
    void testMorseCodeConverter() {
        String text = "the quick brown fox jumped over the lazy dog";

        String morseCode = MorseCode.textToMorseCode(text);
        String revertBack = MorseCode.morseCodeToText(morseCode);
        System.out.println("original : " + text);
        System.out.println("converted: " + morseCode);
        System.out.println("reverted : " + revertBack);

        assertEquals(text, revertBack);
    }
}