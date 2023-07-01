package blackjack.model.gamer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import blackjack.model.card.Card;
import blackjack.model.card.Cards;
import blackjack.model.card.Number;
import blackjack.model.card.Suit;

public class GamersTest {
    Gamers gamers;
    Cards cards1 = new Cards();
    String name1 = "jung";
    Gamer player1;

    Cards cards2 = new Cards();
    String name2 = "hyeonwoo";
    Gamer player2;

    @BeforeEach
    void setup() {
        gamers = new Gamers();

        cards1.add(new Card(Number.ACE, Suit.SPADES));
        cards1.add(new Card(Number.KING, Suit.SPADES));
        player1 = new Player(0, name1, cards1);

        cards2.add(new Card(Number.ACE, Suit.HEARTS));
        cards2.add(new Card(Number.SEVEN, Suit.CLOVERS));
        player2 = new Player(0, name2, cards2);

        gamers.add(player1);
        gamers.add(player2);
    }

    @AfterEach
    void teardown() {
        gamers = null;
    }

    @Test
    void getPlayerNames_test() {
        assertThat(gamers.playerNames().equals("jung, hyeonwoo")).isTrue();
    }

    @Test
    void equals_test() {
        Gamers other = new Gamers();
        other.add(player1);
        other.add(player2);

        assertThat(gamers.equals(other)).isTrue();

        other.add(new Player(0, name1, cards1));
        assertThat(gamers.equals(other)).isFalse();
    }

    @Test
    void getBlackjackGamer_test() {
        Gamers winners = gamers.blackjackGamer();
        Gamers expected = new Gamers();
        expected.add(player1);

        assertThat(winners.equals(expected)).isTrue();
    }
}
