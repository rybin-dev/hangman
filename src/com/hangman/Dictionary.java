package com.hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.List;
import java.util.Random;

public class Dictionary {
    private static Random random = new Random();
    private static List<String> words;

    static {
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            Dictionary.class.getClassLoader().getResourceAsStream("singular.txt")));

            words = reader.lines().toList();

            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static String getRandomWords() {
        int randomIndex = random.nextInt(words.size() - 1);
        return words.get(randomIndex);
    }


}
