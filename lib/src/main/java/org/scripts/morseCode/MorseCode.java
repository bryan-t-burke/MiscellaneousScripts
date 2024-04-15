package org.scripts.morseCode;

import java.util.HashMap;
import java.util.Map;

public class MorseCode {

    // key: letter/number, value: morse code representation
    private static Map<String, String> textToMorseCodeMappings;
    private static Map<String, String> morseCodeToTextMappings;

    static {
        textToMorseCodeMappings = new HashMap<String, String>();
        textToMorseCodeMappings.put("a", "._");
        textToMorseCodeMappings.put("b", "_...");
        textToMorseCodeMappings.put("c", "_._.");
        textToMorseCodeMappings.put("d", "_..");
        textToMorseCodeMappings.put("e", ".");
        textToMorseCodeMappings.put("f", ".._.");
        textToMorseCodeMappings.put("g", "__.");
        textToMorseCodeMappings.put("h", "....");
        textToMorseCodeMappings.put("i", "..");
        textToMorseCodeMappings.put("j", ".___");
        textToMorseCodeMappings.put("k", "_._");
        textToMorseCodeMappings.put("l", "._..");
        textToMorseCodeMappings.put("m", "__");
        textToMorseCodeMappings.put("n", "_.");
        textToMorseCodeMappings.put("o", "___");
        textToMorseCodeMappings.put("p", ".__.");
        textToMorseCodeMappings.put("q", "__._");
        textToMorseCodeMappings.put("r", "._.");
        textToMorseCodeMappings.put("s", "...");
        textToMorseCodeMappings.put("t", "_");
        textToMorseCodeMappings.put("u", ".._");
        textToMorseCodeMappings.put("v", "..._");
        textToMorseCodeMappings.put("w", ".__");
        textToMorseCodeMappings.put("x", "_.._");
        textToMorseCodeMappings.put("y", "_.__");
        textToMorseCodeMappings.put("z", "__..");

        textToMorseCodeMappings.put("0", "_____");
        textToMorseCodeMappings.put("1", ".____");
        textToMorseCodeMappings.put("2", "..___");
        textToMorseCodeMappings.put("3", "...__");
        textToMorseCodeMappings.put("4", "...._");
        textToMorseCodeMappings.put("5", ".....");
        textToMorseCodeMappings.put("6", "_....");
        textToMorseCodeMappings.put("7", "__...");
        textToMorseCodeMappings.put("8", "___..");
        textToMorseCodeMappings.put("9", "____.");

        morseCodeToTextMappings = new HashMap<String, String>();
        morseCodeToTextMappings.put("._",   "a");
        morseCodeToTextMappings.put("_...", "b");
        morseCodeToTextMappings.put("_._.", "c");
        morseCodeToTextMappings.put("_..",  "d");
        morseCodeToTextMappings.put(".",    "e");
        morseCodeToTextMappings.put(".._.", "f");
        morseCodeToTextMappings.put("__.",  "g");
        morseCodeToTextMappings.put("....", "h");
        morseCodeToTextMappings.put("..",   "i");
        morseCodeToTextMappings.put(".___", "j");
        morseCodeToTextMappings.put("_._",  "k");
        morseCodeToTextMappings.put("._..", "l");
        morseCodeToTextMappings.put("__",   "m");
        morseCodeToTextMappings.put("_.",   "n");
        morseCodeToTextMappings.put("___",  "o");
        morseCodeToTextMappings.put(".__.", "p");
        morseCodeToTextMappings.put("__._", "q");
        morseCodeToTextMappings.put("._.",  "r");
        morseCodeToTextMappings.put("...",  "s");
        morseCodeToTextMappings.put("_",    "t");
        morseCodeToTextMappings.put(".._",  "u");
        morseCodeToTextMappings.put("..._", "v");
        morseCodeToTextMappings.put(".__",  "w");
        morseCodeToTextMappings.put("_.._", "x");
        morseCodeToTextMappings.put("_.__", "y");
        morseCodeToTextMappings.put("__..", "z");

        morseCodeToTextMappings.put("_____", "0");
        morseCodeToTextMappings.put(".____", "1");
        morseCodeToTextMappings.put("..___", "2");
        morseCodeToTextMappings.put("...__", "3");
        morseCodeToTextMappings.put("...._", "4");
        morseCodeToTextMappings.put(".....", "5");
        morseCodeToTextMappings.put("_....", "6");
        morseCodeToTextMappings.put("__...", "7");
        morseCodeToTextMappings.put("___..", "8");
        morseCodeToTextMappings.put("____.", "9");
    }

    public static String morseCodeToText(String morseCode) {
        // expect 2 spaces between words and 1 space between letters
        // output sets 1 space between words and no spaces between letters
        StringBuilder sb = new StringBuilder();
        String[] words = morseCode.split("  ");
        for (int i = 0; i < words.length; ++i) {
            String[] letters = words[i].split(" ");
            for (int j = 0; j < letters.length; ++j) {
                sb.append(morseCodeToTextMappings.get(letters[j]));
            }
            sb.append(" ");
        }
        // remove the extra space at the end
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static String textToMorseCode(String text) {
        // expect 1 space between words and no spaces between letters
        // output sets 2 spaces between words and 1 space between letters
        StringBuilder sb = new StringBuilder();
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; ++i) {
            for (int j = 0; j < words[i].length(); ++j) {
                sb.append(textToMorseCodeMappings.get(String.valueOf(words[i].charAt(j)).toLowerCase())).append(" ");
            }
            sb.append(" ");
        }
        // remove 2 extra spaces at the end
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}