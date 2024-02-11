package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static List<User> getUsers(String sourceFilePath) {
        List<User> userList = new ArrayList<>();
        try (FileReader fileReader = new FileReader(sourceFilePath);
             Scanner scanner = new Scanner(fileReader)) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String[] nameAge = scanner.nextLine().split(" ");
                userList.add(new User(nameAge[0], Integer.parseInt(nameAge[1])));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return userList;
    }

    public static void toGSON(List<User> userList) {
        Gson gsonMapper = new GsonBuilder().setPrettyPrinting().create();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < userList.size(); i++) {
            builder.append("\n").append(gsonMapper.toJson(userList.get(i)));
        }
        try (FileOutputStream fOs = new FileOutputStream("gson.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fOs))) {
            bufferedWriter.write(builder.toString().trim());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}


