package blackjack.model.gamer;

import java.util.Optional;

import blackjack.model.card.Cards;
import blackjack.model.card.Deck;

public abstract class AbstracGamer implements Gamer {

    final static private Integer MAX_NUMBER = 21;
    final static private Deck DECK = Deck.getInstance();
    final private String playerName;
    final private Integer betting;
    final private Cards cards;
    private boolean drawable = true;

    public AbstracGamer(int betting, String playerName, Cards initCards) {
        validateArgs(playerName, initCards);

        this.betting = betting;
        this.playerName = playerName;
        this.cards = initCards;
    }

    private void validateArgs(String playerName, Cards initCards) {
        Optional<String> optinalName = Optional.ofNullable(playerName);
        Optional<Cards> optionalCards = Optional.ofNullable(initCards);

        if (!optinalName.isPresent())
            throw new IllegalArgumentException();

        if (!optionalCards.isPresent() || optionalCards.isEmpty())
            throw new IllegalArgumentException();

        if (optionalCards.isPresent() && optionalCards.get().size() != 2)
            throw new IllegalArgumentException();
    }

    @Override
    public void draw(int times) {
        for (int i = 0; i < times; i++) {
            this.cards.add(DECK.draw());
        }
    }

    @Override
    public Integer getBetting() {
        return this.betting;
    }

    @Override
    public String getPlayerName() {
        return this.playerName;
    }

    @Override
    public Cards getCards() {
        return this.cards;
    }

    @Override
    public Integer getCardSum() {
        return this.cards.getSum();
    }

    @Override
    public Double multiplyBetting(double times) {
        return this.betting * times;
    }

    @Override
    public boolean isBalckJack() {
        return this.getCardSum() == MAX_NUMBER;
    }

    @Override
    public boolean isLost() {
        return this.getCardSum() > MAX_NUMBER;
    }

    @Override
    public void setDrawableFalse() {
        this.drawable = false;
    }

    @Override
    public boolean getDrawble() {
        return this.drawable;
    }

    @Override
    public String toString() {
        return this.getPlayerName() + ": " + getCards().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;

        Gamer other = (Gamer) o;

        if (this.getBetting() == other.getBetting() &&
                this.getPlayerName() == other.getPlayerName() &&
                this.getCards().equals(other.getCards()))
            return true;

        return false;
    }

    @Override
    public int hashCode() {
        return this.getBetting().hashCode() +
                this.getPlayerName().hashCode() +
                this.getCards().hashCode();
    }
}
