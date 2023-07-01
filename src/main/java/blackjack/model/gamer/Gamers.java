package blackjack.model.gamer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Gamers {
    final private List<Gamer> gamers;

    public Gamers() {
        this.gamers = new ArrayList<>();
    }

    public void add(Gamer gamer) {
        gamers.add(gamer);
    }

    public Gamer get(int index) {
        return gamers.get(index);
    }

    public Integer size() {
        return gamers.size();
    }

    public String playerNames() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < gamers.size(); i++) {
            if (i != gamers.size() - 1) {
                sb.append(gamers.get(i).getPlayerName() + ", ");
                continue;
            }
            sb.append(gamers.get(i).getPlayerName());
        }
        return sb.toString();
    }

    public Gamers blackjackGamer() {
        Gamers blackJackGamers = new Gamers();
        this.gamers.stream()
                .filter(gamer -> gamer.isBalckJack())
                .forEach(gamer -> blackJackGamers.add(gamer));
        return blackJackGamers;
    }

    public String printPlayers() {
        StringBuilder sb = new StringBuilder();
        for (Gamer gamer : gamers) {
            sb.append(gamer.toString() + "\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;

        Gamers other = (Gamers) o;

        if (gamers.size() != other.size())
            return false;

        for (int i = 0; i < gamers.size(); i++) {
            if (!gamers.get(i).equals(other.get(i)))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        return prime * Objects.hashCode(gamers);
    }
}
