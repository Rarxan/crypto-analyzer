package com.javarush.rybalchenko.cryptoanalyzer;

import com.javarush.rybalchenko.cryptoanalyzer.bruteforce.BruteForceService;
import com.javarush.rybalchenko.cryptoanalyzer.fileservice.FileProcessingException;
import com.javarush.rybalchenko.cryptoanalyzer.runapp.TextEncryptorService;

public class CryptoApplication {
    public void run() {
        ConsoleReader consoleReader = new ConsoleReader();

        try {
            OperationType operation = consoleReader.readOperation();
            String inputPath = consoleReader.readInputPath();
            String outputPath = consoleReader.readOutputPath();
            int key = 0;
            if (operation != OperationType.BRUTE_FORCE) {
                key = consoleReader.readKey();
            }

            switch (operation) {
                case ENCRYPT -> TextEncryptorService.encryptFile(inputPath, outputPath, key);
                case DECRYPT -> TextEncryptorService.decryptFile(inputPath, outputPath, key);
                case BRUTE_FORCE -> BruteForceService.bruteForceDecrypt(inputPath, outputPath);
            }
        } catch (FileProcessingException e) {
            System.out.println("File error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}