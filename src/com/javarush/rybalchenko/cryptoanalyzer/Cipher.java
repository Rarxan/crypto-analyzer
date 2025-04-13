package com.javarush.rybalchenko.cryptoanalyzer;

public class Cipher {

    private static final char[] ALPHABET = {
            'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с',
            'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я',
            'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С',
            'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я',
            '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ', '—', '-'
    };

    private static int indexOfChar(char ch) {
        for (int i = 0; i < ALPHABET.length; i++) {
            if (ALPHABET[i] == ch) {
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
                int newIndex = (index + key + ALPHABET.length) % ALPHABET.length;
                result.append(ALPHABET[newIndex]);
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
