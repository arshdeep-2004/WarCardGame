/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project2;

import java.util.Scanner;

public class WarCardMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name for Player 1: ");
        String name1 = scanner.nextLine();

        System.out.print("Enter name for Player 2: ");
        String name2 = scanner.nextLine();

        Game game = new Game(name1, name2);
        game.startGame();

        for (int round = 1; round <= 26; round++) {
            System.out.println("\nRound " + round + ":");
            game.playRound();
        }

        game.displayWinner();
    }
}
