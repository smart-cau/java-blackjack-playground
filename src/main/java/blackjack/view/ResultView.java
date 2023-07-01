package blackjack.view;

import blackjack.model.gamer.Gamer;
import blackjack.model.gamer.Gamers;

public class ResultView {
    public static void printResult(Gamers gamers) {
        for (int i = 0; i < gamers.size(); i++) {
            Gamer gamer = gamers.get(i);

            System.out.println(gamer.toString() + " - 결과: " + gamer.getCardSum());
        }
        System.out.println();
        System.out.println("## 최종 수익");
        for (int i = 0; i < gamers.size(); i++) {
            Gamer gamer = gamers.get(i);

            System.out.println(gamer.getPlayerName() + ": " + gamer.getBetting());
        }
    }
}
