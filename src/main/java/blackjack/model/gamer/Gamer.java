package blackjack.model.gamer;

import blackjack.model.card.Cards;

public interface Gamer {
    Integer getBetting();

    Double multiplyBetting(double d);

    String getPlayerName();

    Cards getCards();

    void draw(int times);

    Integer getCardSum();

    boolean isBalckJack();

    boolean isLost();

    void setDrawableFalse();
    boolean getDrawble();
}
