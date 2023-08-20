package com.hangman;

import java.util.Arrays;
import java.util.List;

public class Canvas {

    public static final char CHAR = '█';
    public static final char BG_CHAR = ' ';
    private char[][] canvas;

    public Canvas() {
        this.canvas = new char[16][70];
        init();
    }

    public void init() {
        for (char[] chars : canvas) {
            Arrays.fill(chars, BG_CHAR);
            Arrays.fill(chars, 0, 2, CHAR);
        }
        Arrays.fill(canvas[0], 2, 20, CHAR);

    }

    public void setMessage(String t) {
        clearAndSet(10, t);

    }

    public void setStatistics(String text) {
        String t = "Статистика: ".concat(text);
        clearAndSet(0, t);

    }
    public void setErrors(List<Character> text) {
        StringBuilder t = new StringBuilder("Ошибки: ");
        text.forEach(t::append);

        clearAndSet(6, t.toString());

    }



    public void setMaskedWord(String text) {
        String t = "Слово: ".concat(text);
        clearAndSet(4, t);
    }

    public void setWord(String text) {
        String t = "Загадано: ".concat(text);
        clearAndSet(14, t);
    }

    private void clearAndSet(int row, String t) {
        Arrays.fill(canvas[row], 25, canvas[row].length, BG_CHAR);
        for (int i = 0; i < t.length(); i++) {
            canvas[row][25 + i] = t.charAt(i);
        }
    }


    public void next(int x) {
        switch (x) {
            case 1 -> addHead();
            case 2 -> addBody();
            case 3 -> addHand1();
            case 4 -> addHand2();
            case 5 -> addLeg1();
            case 6 -> addLeg2();
        }
    }

    private void addHead() {
        for (int i = 2; i < 6; i++) {
            Arrays.fill(canvas[i], 8, 18, CHAR);
        }
    }

    private void addBody() {
        for (int i = 0; i < 12; i++) {
            Arrays.fill(canvas[i], 12, 14, CHAR);
        }
    }

    private void addHand1() {
        Arrays.fill(canvas[7], 6, 12, CHAR);

    }

    private void addHand2() {
        Arrays.fill(canvas[7], 14, 20, CHAR);
    }

    private void addLeg1() {
        Arrays.fill(canvas[11], 8, 12, CHAR);
        for (int i = 12; i < 14; i++) {
            Arrays.fill(canvas[i], 8, 10, CHAR);
        }
    }

    private void addLeg2() {

        Arrays.fill(canvas[11], 14, 18, CHAR);
        for (int i = 12; i < 14; i++) {
            Arrays.fill(canvas[i], 16, 18, CHAR);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(1130);

        for (char[] chars : canvas) {
            builder.append(chars).append('\n');
        }

        return builder.toString();
    }

}
