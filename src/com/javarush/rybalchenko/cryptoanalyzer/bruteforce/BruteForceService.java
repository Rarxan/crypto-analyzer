package com.javarush.rybalchenko.cryptoanalyzer.bruteforce;

import com.javarush.rybalchenko.cryptoanalyzer.cipher.Cipher;
import com.javarush.rybalchenko.cryptoanalyzer.constant.Alphabets;
import com.javarush.rybalchenko.cryptoanalyzer.fileservice.FileManager;

import java.util.Arrays;
import java.util.List;

public class BruteForceService {
    private static final List<String> COMMON_PATTERNS = Arrays.asList(" to ", " the ", " for ", " is ", " that ", " with ", " in ", " you ", " and ", " of ");

    public static void bruteForceDecrypt(String inputPath, String outputPath) {
        String encryptedText = FileManager.readFile(inputPath);
        for (int key = 1; key < Alphabets.ALPHABET_EN.size(); key++) {
            String decrypted = Cipher.decrypt(encryptedText, key);
            if (looksLikeRealText(decrypted)) {
                FileManager.writeFile(outputPath, decrypted);
                System.out.println("Brute-force successful! Key found: " + key);
                System.out.println("Decrypted file written to: " + outputPath);
                return;
            }
        }
        System.out.println("Failed to determine the correct key using brute-force.");
    }

    private static boolean looksLikeRealText(String text) {
        for (String pattern : COMMON_PATTERNS) {
            if (text.contains(pattern)) {
                return true;
            }
        }
        return false;
    }
}