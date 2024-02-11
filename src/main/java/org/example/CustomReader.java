package org.example;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CustomReader {
    public static void fileReader(File file) {
        try (FileReader reader = new FileReader(file);
        Scanner scanner = new Scanner(reader)) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.matches("^(?:\\(\\d{3}\\)\\s|\\d{3}-)\\d{3}-\\d{4}$")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
