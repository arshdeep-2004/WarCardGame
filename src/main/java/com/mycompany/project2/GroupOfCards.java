/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GroupOfCards {
    private List<Card> cards;

    public GroupOfCards() {
        cards = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        for (String suit : suits) {
            for (int rank = 2; rank <= 14; rank++) { // 11–14 = J, Q, K, A
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public List<Card> getCards() {
        return cards;
    }

    public void deal(Player p1, Player p2) {
        for (int i = 0; i < cards.size(); i++) {
            if (i % 2 == 0)
                p1.addCards(cards.get(i));
            else
                p2.addCards(cards.get(i));
        }
    }
}

