package fr.epita.cards.tests;

import fr.epita.cards.datamodel.Card;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestA01 {


    public static void main(String[] args) {
        /*
        {7 of Hearts, 3 of Spades, 5 of Diamonds, 9 of Hearts, Jack (11) of
Diamonds, King of Clubs(13), 6 of Clubs, Ace of Diamonds}
         */

        Card card = new Card(7, "HEART");
        Card card2 = new Card(3, "SPADE");
        Card card3 = new Card(9, "HEART");
        Card card4 = new Card(11, "DIAMOND");
        Card card5 = new Card(13, "CLUB");
        Card card6 = new Card(6, "CLUB");
        Card card7 = new Card(14, "DIAMOND");

        List<Card> cards = new ArrayList<>(List.of(card,card2,
                card3,
                card4,
                card5,
                card6,
                card7
        ));

        cards.sort((o1, o2) -> o1.getValue() - o2.getValue());

        System.out.println(cards);



    }
}
