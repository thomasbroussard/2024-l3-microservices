package fr.epita.cards.tests;

import fr.epita.cards.datamodel.Card;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestA03 {

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

        Map<String, List<Card>> groupedCards = new LinkedHashMap<>();

        //"manual method"
        for (Card currentCard: cards){
            List<Card> currentCardsList = groupedCards.get(currentCard.getColor());
            if (currentCardsList == null){
                currentCardsList = new ArrayList<>();
                groupedCards.put(currentCard.getColor(), currentCardsList);
            }
            currentCardsList.add(currentCard);
        }
        groupedCards.clear();
        //other version
        for (Card currentCard: cards){
            List<Card> currentCardsList = groupedCards.computeIfAbsent(currentCard.getColor(), key -> new ArrayList<>());
            currentCardsList.add(currentCard);
        }

        //one liner
        Map<String, List<Card>> collectedList = cards.stream()
                .collect(Collectors.groupingBy(c -> c.getColor()));




    }
}
