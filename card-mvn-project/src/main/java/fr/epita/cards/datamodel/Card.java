package fr.epita.cards.datamodel;

import jakarta.persistence.*;

@Entity
@Table(name = "CARDS")
public class Card implements Comparable<Card> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "VALUE")
    private int value;

    @Column(name = "COLOR")
    private String color;

    public Card() {
    }

    public Card(int value, String color) {
        this.value = value;
        this.color = color;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Card{" +
                "value=" + value +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public int compareTo(Card o) {
        return 0;
    }
}
