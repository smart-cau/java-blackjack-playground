package blackjack.model.card;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cards {

    final private List<Card> cards;
    final static private Integer MAX_NUMBER = 21;
    final static private Integer BIG_ACE = 10;
    final static private String ERROR_ADD_MESSAGE = "똑같은 카드를 2장 이상 추가할 수 없습니다.";

    public Cards() {
        this.cards = new ArrayList<>();
    }

    public void add(Card card) {
        if (this.cards.contains(card))
            throw new IllegalArgumentException(ERROR_ADD_MESSAGE);

        cards.add(card);
    }

    public Card get(int index) {
        return cards.get(index);
    }

    public Integer size() {
        return cards.size();
    }

    public Card pop() {
        int randomIndex = getRandomNumber(0, size() - 1);
        Card randomCard = get(randomIndex);

        remove(randomIndex);
        return randomCard;
    }

    public Integer getSum() {

        Integer sum = this.cards.stream()
                .map(card -> card.getNumber().getValue())
                .reduce(0, Integer::sum);

        if (sum > MAX_NUMBER && this.hashAce())
            return sum - BIG_ACE;

        return sum;
    }

    public boolean hashAce() {
        return this.cards
                .stream()
                .filter(card -> card.isAce())
                .findFirst()
                .isPresent();
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private void remove(int index) {
        this.cards.remove(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.cards.forEach(card -> {
            if (this.cards.indexOf(card) != this.cards.size() - 1) {
                sb.append(card.toString() + ", ");
                return;
            }
            sb.append(card.toString());
        });

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;

        Cards other = (Cards) o;

        if (cards.size() != other.size())
            return false;

        for (int i = 0; i < cards.size(); i++) {
            if (!cards.get(i).equals(other.get(i)))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        return prime * Objects.hashCode(cards);
    }

}
