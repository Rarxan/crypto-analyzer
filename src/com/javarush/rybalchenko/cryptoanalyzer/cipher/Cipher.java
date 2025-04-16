package com.javarush.rybalchenko.cryptoanalyzer.cipher;

import com.javarush.rybalchenko.cryptoanalyzer.constant.Alphabets;

import java.util.ArrayList;

public class Cipher {

    public static final ArrayList<Character> ALPHABET = Alphabets.ALPHABET_EN;

    private static int indexOfChar(char ch) {
        for (int i = 0; i < ALPHABET.size(); i++) {
            if (ALPHABET.get(i) == ch) {
                return i;
            }
        }
        return -1;
    }

    public static String encrypt(String text, int key) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            int index = indexOfChar(currentChar);

            if (index != -1) {
                int newIndex = (index + key + ALPHABET.size()) % ALPHABET.size();
                result.append(ALPHABET.get(newIndex));
            } else {
                result.append(currentChar);
            }
        }
        return result.toString();
    }

    public static String decrypt(String text, int key) {
        return encrypt(text, -key);
    }

}
