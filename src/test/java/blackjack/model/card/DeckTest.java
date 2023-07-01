package blackjack.model.card;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class DeckTest {

    Deck deck = Deck.getInstance();
    
    @Test
    void deck_creation_test() {
        // suit 4 x number 13 = 52
        assertThat(deck.getDeck().size()).isEqualTo(52);
    }

    @Test
    void draw_test() {
        // draw는 랜덤하게 이루어져야 함
        Card drawn = deck.draw();
        assertThat(drawn).isInstanceOf(Card.class);
        assertThat(deck.getDeck().size()).isEqualTo(51);
    }


}
