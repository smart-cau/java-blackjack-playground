package blackjack.model.gamer;

import blackjack.model.card.Cards;

public class Dealer extends AbstracGamer {

    final static private Integer DRAW_OVER_NUMBER = 16;

    public Dealer(int betting, String playerName, Cards initCards) {
        super(betting, playerName, initCards);
    }

    public boolean isOver() {
        return super.getCardSum() > DRAW_OVER_NUMBER;
    }

}
