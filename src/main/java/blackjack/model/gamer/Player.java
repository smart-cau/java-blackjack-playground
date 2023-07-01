package blackjack.model.gamer;

import blackjack.model.card.Cards;

public class Player extends AbstracGamer {

    public Player(int betting, String playerName, Cards initCards) {
        super(betting, playerName, initCards);
    }
    
}
