package org.example;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    public static void fileReader(File file) {
        try (FileReader fileReader = new FileReader(file);
        Scanner scanner = new Scanner(fileReader)) {
            while (scanner.hasNextLine()) {
                String[] nameAge = scanner.nextLine().split(" ");
                List<>
                for (int i = 1; scanner.hasNextLine(); i++) {

                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
