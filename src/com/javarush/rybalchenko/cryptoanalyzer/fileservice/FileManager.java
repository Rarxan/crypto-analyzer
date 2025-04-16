package com.javarush.rybalchenko.cryptoanalyzer.fileservice;

import java.io.*;

public class FileManager {

    public static String readFile(String filepath) {
        StringBuilder text = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append("\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found" + filepath);
        } catch (IOException e) {
            System.out.println("Error reading file:" + e.getMessage());
        }
        return text.toString();

    }

    public static void writeFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        } catch (IOException e) {
            System.out.println("Error writing file!" + e.getMessage());
        }
    }
}
