package com.hangman;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Canvas canvas = new Canvas();
        String cmd;
        do {

            canvas.setStatistics("Всего %d Побед %d".formatted(Game.countGame, Game.countWin));
            canvas.setMessage(". Начать игру || exit");

            System.out.println(canvas);

            cmd = scanner.next().toLowerCase();

            if (!"exit".equals(cmd)) {
                new Game(canvas, Dictionary.getRandomWords(), scanner).start();
                canvas.init();
            }

        } while (!"exit".equals(cmd));


    }
}