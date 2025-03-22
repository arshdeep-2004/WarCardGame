/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project2;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player player1;
    private Player player2;
    private GroupOfCards deck;

    public Game(String name1, String name2) {
        player1 = new Player(name1);
        player2 = new Player(name2);
        deck = new GroupOfCards();
    }

    public void startGame() {
        deck.shuffle();
        List<List<Card>> hands = deck.dealCards();
        for (Card card : hands.get(0)) {
            player1.receiveCard(card);
        }
        for (Card card : hands.get(1)) {
            player2.receiveCard(card);
        }
    }

    public void playRound() {
        Card card1 = player1.drawCard();
        Card card2 = player2.drawCard();

        System.out.println(player1.getName() + " plays " + card1);
        System.out.println(player2.getName() + " plays " + card2);

        int result = compareCards(card1, card2);
        List<Card> roundCards = new ArrayList<>();
        roundCards.add(card1);
        roundCards.add(card2);

        if (result > 0) {
            System.out.println(player1.getName() + " wins the round.");
            player1.addCards(roundCards);
        } else if (result < 0) {
            System.out.println(player2.getName() + " wins the round.");
            player2.addCards(roundCards);
        } else {
            System.out.println("War!");
            handleWar(roundCards);
        }
    }

    public int compareCards(Card c1, Card c2) {
        return Integer.compare(c1.getValue(), c2.getValue());
    }

    public void handleWar(List<Card> warCards) {
        if (player1.getHandSize() < 4 || player2.getHandSize() < 4) {
            System.out.println("Not enough cards to continue war.");
            return;
        }

        for (int i = 0; i < 3; i++) {
            warCards.add(player1.drawCard());
            warCards.add(player2.drawCard());
        }

        Card warCard1 = player1.drawCard();
        Card warCard2 = player2.drawCard();

        warCards.add(warCard1);
        warCards.add(warCard2);

        System.out.println(player1.getName() + " plays war card: " + warCard1);
        System.out.println(player2.getName() + " plays war card: " + warCard2);

        int result = compareCards(warCard1, warCard2);
        if (result > 0) {
            player1.addCards(warCards);
        } else if (result < 0) {
            player2.addCards(warCards);
        } else {
            System.out.println("War again!");
            handleWar(warCards); // recursive call
        }
    }

    public void displayWinner() {
        System.out.println("Final Result:");
        System.out.println(player1.getName() + ": " + player1.getHandSize() + " cards");
        System.out.println(player2.getName() + ": " + player2.getHandSize() + " cards");

        if (player1.getHandSize() > player2.getHandSize()) {
            System.out.println(player1.getName() + " wins the game!");
        } else if (player2.getHandSize() > player1.getHandSize()) {
            System.out.println(player2.getName() + " wins the game!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}
