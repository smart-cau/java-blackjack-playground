package blackjack;

import java.io.IOException;

import blackjack.model.gamer.Gamers;
import blackjack.view.InputView;
import blackjack.view.ResultView;

public class Main {
    public static void main(String[] args) throws IOException {
        InputView.setGamers();
        Gamers result = InputView.gameOn();
        ResultView.printResult(result);
    }
}
