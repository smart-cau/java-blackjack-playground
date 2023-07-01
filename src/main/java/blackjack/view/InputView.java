package blackjack.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import blackjack.model.card.Cards;
import blackjack.model.card.Deck;
import blackjack.model.gamer.Dealer;
import blackjack.model.gamer.Gamer;
import blackjack.model.gamer.Gamers;
import blackjack.model.gamer.Player;

public class InputView {

    static final private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static final private Gamers GAMERS = new Gamers();
    static final private Deck DECK = Deck.getInstance();
    static final private Dealer DEALER = new Dealer(0, "딜러", drawCards(2));
    static final private String YES = "y";
    static final private String NO = "n";

    static public void setGamers() throws NumberFormatException, IOException {
        String[] names = getNames();

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + "의 배팅 금액은?");
            Integer betting = Integer.parseInt(reader.readLine());

            Gamer gamer = new Player(betting, names[i], drawCards(2));
            GAMERS.add(gamer);

            printNewLine();
        }

        System.out.println(DEALER.getPlayerName() + "와 " + GAMERS.playerNames() + "에게 2장씩 나누었습니다.");
        printNewLine();
        System.out.println(DEALER.toString());
        System.out.println(GAMERS.printPlayers());
    }

    static public Gamers gameOn() throws IOException {
        playersDrawCards();
        dealerDrawsCards();
        adjustBettings();

        GAMERS.add(DEALER);
        return GAMERS;
    }

    static private void playersDrawCards() throws IOException {
        for (int i = 0; i < GAMERS.size(); i++) {
            Gamer player = GAMERS.get(i);
            if (player.isBalckJack()) {
                player.multiplyBetting(1.5);
                return;
            }

            while (true) {
                if (!player.getDrawble())
                    break;

                System.out.println(player.getPlayerName() + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
                if (stopDrawing())
                    break;

                player.draw(1);
                System.out.println(player.toString());

                ifPlayerLost(player);
            }
        }
    }

    static private void dealerDrawsCards() {
        if (!DEALER.isOver()) {
            DEALER.draw(1);
            System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
            printNewLine();
        }
    }

    static private void adjustBettings() {
        for (int i = 0; i < GAMERS.size(); i++) {
            Gamer player = GAMERS.get(i);
            // case0 딜러가 21 오버
            if (DEALER.isLost())
                return;
            // case1 딜러 & 플레이어 동시 블랙잭
            if (DEALER.isBalckJack() && player.isBalckJack())
                break;
            // case2 카드 2장에 바로 블랙잭
            if (player.getCards().size() == 2 && player.isBalckJack())
                player.multiplyBetting(1.5);
            // case3 플레이어만 블랙잭 -> 베팅금액 그대로
            // case4 플레이어가 진 경우
            if (player.isLost())
                player.multiplyBetting(-1);
        }

    }

    static private boolean stopDrawing() throws IOException {
        while (true) {
            String keepDrawing = reader.readLine();

            if (keepDrawing.equals(YES))
                return false;
            if (keepDrawing.equals(NO))
                return true;
            System.out.println("y 또는 n으로만 응답할 수 있습니다.");
        }
    }

    private static void ifPlayerLost(Gamer player) {
        if (player.isLost()) {
            player.setDrawableFalse();
        }
    }

    static private String[] getNames() throws IOException {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        String[] names = reader.readLine().split(",");
        printNewLine();
        return names;
    }

    static private Cards drawCards(int times) {
        Cards cards = new Cards();

        for (int i = 0; i < times; i++) {
            cards.add(DECK.draw());
        }

        return cards;
    }

    static private void printNewLine() {
        System.out.println();
    }
}
