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
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        for (String suit : suits) {
            for (int i = 2; i <= 14; i++) { // 11=J, 12=Q, 13=K, 14=A
                cards.add(new Card(suit, i));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public List<List<Card>> dealCards() {
        List<Card> p1 = new ArrayList<>();
        List<Card> p2 = new ArrayList<>();
        for (int i = 0; i < cards.size(); i++) {
            if (i % 2 == 0) p1.add(cards.get(i));
            else p2.add(cards.get(i));
        }
        List<List<Card>> dealt = new ArrayList<>();
        dealt.add(p1);
        dealt.add(p2);
        return dealt;
    }
}
