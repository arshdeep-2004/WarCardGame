/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project2;
import java.util.LinkedList;
import java.util.Queue;

public class Player {
    private String name;
    private Queue<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void addCards(Card... cards) {
        for (Card card : cards) {
            hand.add(card);
        }
    }

    public Card drawCard() {
        return hand.poll();
    }

    public int cardCount() {
        return hand.size();
    }

    public boolean hasEnoughCards(int count) {
        return hand.size() >= count;
    }

    public Queue<Card> getHand() {
        return hand;
    }
}
