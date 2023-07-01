package blackjack.model.card;

public enum Number {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;

    public Integer getValue() {
        if (isLargerThanTEN())
            return 10;
        if (this.equals(ACE))
            return 11;
        return ordinal() + 1;
    }

    public boolean isLargerThanTEN() {
        return this.compareTo(TEN) > 1;
    }

    @Override
    public String toString() {
        if (this.equals(ACE))
            return "A";
        return getValue().toString();
    }
}
