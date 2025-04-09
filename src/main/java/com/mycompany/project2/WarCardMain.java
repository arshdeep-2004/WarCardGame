/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project2;

import java.util.Scanner;

public class WarCardMain {
  public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Player 1 name: ");
        String name1 = input.nextLine();
        System.out.print("Enter Player 2 name: ");
        String name2 = input.nextLine();

        Game game = new Game(name1, name2);
        game.start();

        final int MAX_ROUNDS = 10; // 🔁 Limit to 10 turns for testing
        int roundCounter = 0;

        while (!game.isGameOver() && roundCounter < MAX_ROUNDS) {
            System.out.println("\n--- Round " + (roundCounter + 1) + " ---");
            game.playRound();
            roundCounter++;

            // Optional pause: comment out for faster testing
            System.out.println("Press Enter to continue...");
            input.nextLine();
        }

        System.out.println("\n--- Game Over ---");
        game.declareWinner();
        input.close();
    }
}

