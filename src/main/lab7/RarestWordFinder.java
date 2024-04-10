package main.lab7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RarestWordFinder {
  private static final Map<String, Integer> wordsFrequency = new HashMap<>();

  public static void processFile(String filePath) {
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        List<String> words = Arrays.asList(line.trim().split("\\s+"));
        for (String word : words) {
          wordsFrequency.put(word, wordsFrequency.getOrDefault(word, 0) + 1);
        }
      }
    } catch (IOException e) {
      System.err.println("Error reading file: " + e.getMessage());
    }
  }

  public static String findRarestWord() {
    String rarestWord = null;
    int minFrequency = Integer.MAX_VALUE;

    for (Map.Entry<String, Integer> entry : wordsFrequency.entrySet()) {
      if (entry.getValue() < minFrequency) {
        minFrequency = entry.getValue();
        rarestWord = entry.getKey();
      }
    }

    return rarestWord != null ? rarestWord : "No words found";
  }
}
