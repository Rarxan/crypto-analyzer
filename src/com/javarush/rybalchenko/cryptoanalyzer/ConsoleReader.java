package com.javarush.rybalchenko.cryptoanalyzer;

import java.io.File;
import java.util.Scanner;

public class ConsoleReader {
    private final Scanner scanner = new Scanner(System.in);

    public OperationType readOperation() {
        while (true) {
            System.out.println("Choose operation: encrypt / decrypt");
            String input = scanner.nextLine().toLowerCase();
            try {
                return OperationType.valueOf(input.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid operation. Please choose 'encrypt' or 'decrypt'.");
            }
        }
    }

    public String readInputPath() {
        while (true) {
            System.out.println("Enter input file path: ");
            String path = scanner.nextLine();
            File file = new File(path);
            if (!file.exists()) {
                System.out.println("File not found. Please check the file path.");
            } else {
                return path;
            }
        }
    }

    public String readOutputPath() {
        System.out.println("Enter output file path: ");
        return scanner.nextLine();
    }

    public int readKey() {
        System.out.println("Enter key: ");
        try {
            int key = Integer.parseInt(scanner.nextLine());
            if (key <= 0) {
                System.out.println("Key must be a positive integer.");
                return readKey();
            }
            return key;
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format. Please enter a valid integer.");
            return readKey();
        }
    }
}