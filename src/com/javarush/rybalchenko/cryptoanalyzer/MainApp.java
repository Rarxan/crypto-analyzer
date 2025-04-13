package com.javarush.rybalchenko.cryptoanalyzer;

public class MainApp {
    public static void main(String[] args) {

//        String text = "Все, что можно вообразить – реально. – Пабло Пикассо.";
//        int key = 3;
//
//        String encrypted = Cipher.encrypt(text, key);
//        System.out.println("Зашифрованный текст : " + encrypted);
//
//        String decrypted = Cipher.decrypt(encrypted, key);
//        System.out.println("Расшифрованный текст : " + decrypted);

        String inputPath = "C:\\JavaTest\\input.txt";
        String outputPath = "C:\\JavaTest\\output.txt";

        String testing = FileManager.readFile(inputPath);

        String encrypted = Cipher.encrypt(testing, 3);
        FileManager.writeFile(outputPath, encrypted);

        System.out.println("Зашифрованный текст записываем в " + outputPath);

        System.out.println("Оригинальный текст: " + testing);
        System.out.println("Зашифрованный текст: " + encrypted);

    }
}