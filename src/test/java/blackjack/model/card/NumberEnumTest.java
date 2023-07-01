package blackjack.model.card;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class NumberEnumTest {
    @Test
    void number_getValue_test() {
        Integer value = 1;
        for (Number number : Number.values()) {
            Integer compare = value;
            if (number.isLargerThanTEN())
                compare = 10;

            assertThat(number.getValue()).isEqualTo(compare);
            value++;
        }
    }
}
