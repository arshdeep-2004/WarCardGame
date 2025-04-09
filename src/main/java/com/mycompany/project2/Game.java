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

    public void start() {
        deck.shuffle();
        deck.deal(player1, player2);
    }

    public void playRound() {
        if (isGameOver()) return;

        Card p1Card = player1.drawCard();
        Card p2Card = player2.drawCard();

        System.out.println(player1.getName() + " plays: " + p1Card);
        System.out.println(player2.getName() + " plays: " + p2Card);

        List<Card> pile = new ArrayList<>();
        pile.add(p1Card);
        pile.add(p2Card);

        if (p1Card.getRank() > p2Card.getRank()) {
            player1.addCards(pile.toArray(new Card[0]));
            System.out.println(player1.getName() + " wins the round.\n");
        } else if (p1Card.getRank() < p2Card.getRank()) {
            player2.addCards(pile.toArray(new Card[0]));
            System.out.println(player2.getName() + " wins the round.\n");
        } else {
            System.out.println("WAR!");
            handleWar(pile);
        }
    }

    private void handleWar(List<Card> pile) {
        if (!player1.hasEnoughCards(4)) {
            System.out.println(player1.getName() + " cannot continue the war. " + player2.getName() + " wins!");
            player2.addCards(pile.toArray(new Card[0]));
            return;
        }
        if (!player2.hasEnoughCards(4)) {
            System.out.println(player2.getName() + " cannot continue the war. " + player1.getName() + " wins!");
            player1.addCards(pile.toArray(new Card[0]));
            return;
        }

        List<Card> warCards1 = new ArrayList<>();
        List<Card> warCards2 = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            warCards1.add(player1.drawCard());
            warCards2.add(player2.drawCard());
        }

        Card p1FaceUp = player1.drawCard();
        Card p2FaceUp = player2.drawCard();

        warCards1.add(p1FaceUp);
        warCards2.add(p2FaceUp);

        System.out.println(player1.getName() + " war card: " + p1FaceUp);
        System.out.println(player2.getName() + " war card: " + p2FaceUp);

        pile.addAll(warCards1);
        pile.addAll(warCards2);

        if (p1FaceUp.getRank() > p2FaceUp.getRank()) {
            player1.addCards(pile.toArray(new Card[0]));
            System.out.println(player1.getName() + " wins the war.\n");
        } else if (p1FaceUp.getRank() < p2FaceUp.getRank()) {
            player2.addCards(pile.toArray(new Card[0]));
            System.out.println(player2.getName() + " wins the war.\n");
        } else {
            System.out.println("WAR again!");
            handleWar(pile);
        }
    }

    public boolean isGameOver() {
        return player1.cardCount() == 0 || player2.cardCount() == 0;
    }

    public void declareWinner() {
        if (player1.cardCount() > player2.cardCount())
            System.out.println(player1.getName() + " wins the game!");
        else if (player2.cardCount() > player1.cardCount())
            System.out.println(player2.getName() + " wins the game!");
        else
            System.out.println("Game is a draw!");
    }
}
