package com.hangman;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Game {
    public static int countGame = 0;
    public static int countWin = 0;
    private final Canvas canvas;
    private final String word;
    private final Set<Character> set;
    private final List<Character> errors;

    private final Scanner scanner;


    public Game(Canvas canvas, String word, Scanner scanner) {
        this.word = word;
        this.canvas = canvas;
        this.errors = new ArrayList<>();
        this.set = new HashSet<>();

        for (char c : word.toCharArray()) {
            set.add(c);
        }

        this.scanner = scanner;

    }

    public void start() {
        canvas.setMaskedWord(getMasked());

        while (errors.size() < 6 && set.size() != 0) {
            canvas.setMessage("Отрыть букву?");
            System.out.println(canvas);

            char c = scanner.next().toLowerCase().charAt(0);

            if (set.contains(c)) {
                set.remove(c);
                canvas.setMaskedWord(getMasked());
            } else {
                errors.add(c);
                canvas.next(errors.size());
                canvas.setErrors(errors);
            }
        }

        canvas.setWord(word);

        if (set.size() == 0) {
            canvas.setMessage("Победа!");
            countWin++;

        } else {
            canvas.setMessage("You лось!");
        }

        countGame++;

        System.out.println(canvas);


    }

    private String getMasked() {
        char[] mask = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            if (set.contains(word.charAt(i))) {
                mask[i] = '_';
            } else {
                mask[i] = word.charAt(i);
            }
        }

        return new String(mask);
    }


}
