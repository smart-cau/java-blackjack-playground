package blackjack.model.card;

public enum Suit {
    HEARTS("하트"), CLOVERS("클로버"), SPADES("스페이드"), DIAMONDS("다이아몬드");

    final private String name;

    private Suit(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
