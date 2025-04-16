package com.javarush.rybalchenko.cryptoanalyzer.runapp;

import com.javarush.rybalchenko.cryptoanalyzer.cipher.Cipher;
import com.javarush.rybalchenko.cryptoanalyzer.fileservice.FileManager;

public class TextEncryptorService {
    public static void encryptFile(String inputPath, String outputPath, int key) {
        String originalText = FileManager.readFile(inputPath);
        String encryptedText = Cipher.encrypt(originalText, key);

        FileManager.writeFile(outputPath, encryptedText);
        System.out.println("The file is encrypted and written to: " + outputPath);
    }

    public static void decryptFile(String inputPath, String outputPath, int key) {
        String originalText = FileManager.readFile(inputPath);
        String decryptedText = Cipher.decrypt(originalText, key);
        FileManager.writeFile(outputPath, decryptedText);
        System.out.println("The file is decrypted and written to: " + outputPath);
    }
}
