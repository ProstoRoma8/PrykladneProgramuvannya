package utils;

import java.io.*;
import java.util.List;

/** FileManager - утиліта для збереження останнього бою у txt файл */
public class FileManager {
    private static final String FILE_PATH = "battle_log.txt";

    public static void saveBattle(List<String> log) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (String line : log) writer.println(line);
            System.out.println("Бій збережено у файл.");
        } catch (IOException e) {
            System.out.println("Помилка запису файлу: " + e.getMessage());
        }
    }

    public static void loadBattle() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            System.out.println("=== Відтворення бою ===");
            while ((line = reader.readLine()) != null)
                System.out.println(line);
        } catch (IOException e) {
            System.out.println("Не вдалося прочитати файл: " + e.getMessage());
        }
    }
}
