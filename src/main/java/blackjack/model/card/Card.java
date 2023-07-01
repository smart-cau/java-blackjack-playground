package blackjack.model.card;

public class Card {
    final private Suit suit;
    final private Number number;

    public Card(Number number, Suit suit) {
        if (number == null || suit == null)
            throw new IllegalArgumentException();
        this.suit = suit;
        this.number = number;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public Number getNumber() {
        return this.number;
    }

    public boolean isAce() {
        return this.number.equals(Number.ACE);
    }

    @Override
    public String toString() {
        return getNumber().toString() + getSuit().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;

        Card other = (Card) o;

        if (number.equals(other.getNumber()) && suit.equals(other.getSuit()))
            return true;

        return false;
    }

    // https://www.geeksforgeeks.org/override-equalsobject-hashcode-method/
    @Override
    public int hashCode() {
        return number.hashCode() + suit.hashCode();
    }
}
