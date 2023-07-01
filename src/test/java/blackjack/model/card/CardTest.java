package blackjack.model.card;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CardTest {

    Card card;

    @BeforeEach
    void setup() {
        card = new Card(Number.ACE, Suit.SPADES);
    }

    @Test
    void card_equal_test() {
        assertThat(card.equals(new Card(Number.ACE, Suit.SPADES))).isTrue();
    }

    @Test
    void toString_test() {
        assertThat(card.toString().equals("A스페이드")).isTrue();
    }

    @Test
    void isAce_test() {
        Card heart7 = new Card(Number.SEVEN, Suit.HEARTS);
        assertThat(card.isAce()).isTrue();
        assertThat(heart7.isAce()).isFalse();
    }
}
