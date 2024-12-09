package fr.epita.cards.datamodel;

public class Card implements Comparable<Card> {
    private int value;
    private String color;

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
