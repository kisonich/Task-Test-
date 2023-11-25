package com.example.tasktest.controller;

import com.example.tasktest.CharacterFrequency;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.*;

@RestController
public class FrequencyController {
    private static final String FILE_PATH = "fileTask.txt";

    @GetMapping("/api/frequency")
    public List<CharacterFrequency> getCharacterFrequency() {
        String line = readTextFromConsole();
        writeTextToFile(line);
        return calculateFrequency(line);
    }

    private String readTextFromConsole() {
        System.out.println("Введите текст:");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();
            return line;
        }
        scanner.close();
        return null;
    }

    private void writeTextToFile(String line) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<CharacterFrequency> calculateFrequency(String line) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : line.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        List<CharacterFrequency> characterFrequencyList = new ArrayList<>();

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            characterFrequencyList.add(new CharacterFrequency(entry.getKey(), entry.getValue()));
        }

        characterFrequencyList.sort(Comparator.comparing(CharacterFrequency::getFrequency).reversed());

        return characterFrequencyList;
    }
}


//@RestController
//public class FrequencyController {
//    private static final String FILE_PATH = "fileTask.txt";
//
//    @GetMapping("/frequency")
//    public List<CharacterFrequency> getCharacterFrequency() {
//        String line = readTextFromConsole();
//        writeTextToFile(line);
//        return calculateFrequency(line);
//    }
//
//    private String readTextFromConsole() {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNextLine()) {
//
//            System.out.println("Введите текст:");
//            String line = scanner.nextLine();
//
//            return line;
//        }
//
//        scanner.close();
//            return null;
//    }
//
//
//    private void writeTextToFile(String line) {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
//            writer.write(line);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private List<CharacterFrequency> calculateFrequency(String line) {
//        Map<Character, Integer> frequencyMap = new HashMap<>();
//
//        for (char c : line.toCharArray()) {
//            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
//        }
//
//        List<CharacterFrequency> characterFrequencyList = new ArrayList<>();
//
//        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
//            characterFrequencyList.add(new CharacterFrequency(entry.getKey(), entry.getValue()));
//        }
//
//        characterFrequencyList.sort(Comparator.comparing(CharacterFrequency::getFrequency).reversed());
//
//        return characterFrequencyList;
//    }
//}


//@RestController
//public class FrequencyController {
//    @GetMapping("/frequency")
//    public List<CharacterFrequency> getCharacterFrequency() {
//        String line = "aaaaabcccc";
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader("com/example/tasktest/fileTask.txt"));
//            line = reader.readLine();
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return calculateFrequency(line);
//    }
//
//    private List<CharacterFrequency> calculateFrequency(String line) {
//        Map<Character, Integer> frequencyMap = new HashMap<>();
//
//        for (char c : line.toCharArray()) {
//            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
//        }
//
//        List<CharacterFrequency> characterFrequencyList = new ArrayList<>();
//        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
//            characterFrequencyList.add(new CharacterFrequency(entry.getKey(), entry.getValue()));
//        }
//
//        characterFrequencyList.sort(Comparator.comparing(CharacterFrequency::getFrequency).reversed());
//
//        return characterFrequencyList;
//    }
//}