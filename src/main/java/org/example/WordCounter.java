package org.example;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordCounter implements Comparable<WordCounter>{
    private String word;
    private int counter;
    public static void counter(File file) {
        try(FileReader reader = new FileReader(file);
        Scanner scanner = new Scanner(reader)) {
            StringBuilder builder = new StringBuilder();
            while (scanner.hasNextLine()) {
                builder.append(" ").append(scanner.nextLine());
            }
            String input = builder.toString().trim().replaceAll(" +", " ");
            String[] allWords = input.split(" ");
            Set<String> beforRemDuplicates = new HashSet<>(Arrays.asList(allWords));
            String[] afterRemDuplicates = beforRemDuplicates.toArray(new String[0]);

            List<WordCounter> wordList = new ArrayList<>();
            for (int i = 0; i < afterRemDuplicates.length; i++) {
                int counter = 0;
                for (int j = 0; j < allWords.length; j++) {
                    if (afterRemDuplicates[i].equals(allWords[j])){
                        counter++;
                    }
                }
                wordList.add(new WordCounter(afterRemDuplicates[i], counter));
            }
            Collections.sort(wordList);
            for (int i = 0; i < wordList.size(); i++) {
                System.out.println(wordList.get(i));
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public WordCounter(String word, int counter) {
        this.word = word;
        this.counter = counter;
    }

    @Override
    public int compareTo(WordCounter o) {
        if (counter < o.counter) {
            return 1;
        } else if (counter > o.counter) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return word + " " + counter;
    }
}
