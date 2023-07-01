package blackjack.model.gamer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import blackjack.model.card.Card;
import blackjack.model.card.Cards;
import blackjack.model.card.Number;
import blackjack.model.card.Suit;

public class PlayerTest {
    String name = "hyeonwoo";
    Cards cards;

    @BeforeEach
    void setup() {
        cards = new Cards();
    }

    @AfterEach
    void teardown() {
        cards = null;
    }

    @Test
    void gamer_args_validate_test_illegalParameter() {
        
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Player(0, null, null);
        });
        
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Player(0, name, null);
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Player(0, name, cards);
        });
        
        cards.add(new Card(Number.ACE, Suit.CLOVERS));

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Player(0, null, cards);
        });
    }

    @Test
    void getCardSum_test() {
        cards.add(new Card(Number.ACE, Suit.CLOVERS));
        cards.add(new Card(Number.KING, Suit.CLOVERS));

        Gamer player = new Player(0, name, cards);
        assertThat(player.getCardSum()).isEqualTo(21);
    }
}
