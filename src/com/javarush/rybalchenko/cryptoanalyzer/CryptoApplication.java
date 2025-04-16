package com.javarush.rybalchenko.cryptoanalyzer;

import com.javarush.rybalchenko.cryptoanalyzer.runapp.TextEncryptorService;

public class CryptoApplication {
    public void run() {
        ConsoleReader consoleReader = new ConsoleReader();

        OperationType operation = consoleReader.readOperation();
        String inputPath = consoleReader.readInputPath();
        String outputPath = consoleReader.readOutputPath();
        int key = consoleReader.readKey();

        switch (operation) {
            case ENCRYPT -> TextEncryptorService.encryptFile(inputPath, outputPath, key);
            case DECRYPT -> TextEncryptorService.decryptFile(inputPath, outputPath, key);
        }
    }
}