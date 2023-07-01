package blackjack.model.card;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CardsTest {
    Cards cards;

    @BeforeEach
    void setup() {
        cards = new Cards();
        cards.add(new Card(Number.ACE, Suit.SPADES));
    }

    @AfterEach
    void teardown() {
        cards = null;
    }

    @Test
    void add_same_card() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            cards.add(new Card(Number.ACE, Suit.SPADES));
        });
    }

    @Test
    void pop_test() {
        Card popped = cards.pop();
        assertThat(popped).isEqualTo(new Card(Number.ACE, Suit.SPADES));
        assertThat(cards.size()).isEqualTo(0);
    }

    @Test
    void toString_test() {
        cards.add(new Card(Number.SEVEN, Suit.CLOVERS));

        assertThat(cards.toString().equals("A스페이드, 7클로버")).isTrue();
    }

    @Test
    void hashAce_test() {
        assertThat(cards.hashAce()).isTrue();

        cards.pop();
        assertThat(cards.hashAce()).isFalse();
    }

    @Test
    void getSum_test() {
        cards.add(new Card(Number.SEVEN, Suit.CLOVERS));
        assertThat(cards.getSum()).isEqualTo(18);

        cards.add(new Card(Number.KING, Suit.HEARTS));
        assertThat(cards.getSum()).isEqualTo(18);
    }

    @Test
    void equals_test() {
        cards.add(new Card(Number.SEVEN, Suit.CLOVERS));

        Cards other = new Cards();
        other.add(new Card(Number.ACE, Suit.SPADES));
        other.add(new Card(Number.SEVEN, Suit.CLOVERS));

        assertThat(cards.equals(other)).isTrue();

        other.add(new Card(Number.KING, Suit.HEARTS));
        assertThat(cards.equals(other)).isFalse();
    }
}
