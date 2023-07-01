package blackjack.model.card;

public class Deck {
    // Card 리스트. 4(Suits) x 11(Numbers) = 44개를 갖고 있음
    static final private Cards deck = new Cards();
    static private Deck instance;

    private Deck() {
        for (Number number : Number.values()) {
            for (Suit suit : Suit.values()) {
                deck.add(new Card(number, suit));
            }
        }
    }

    static public Deck getInstance() {
        if (instance == null)
            instance = new Deck();
        return instance;
    }

    public Card draw() {
        return deck.pop();
    }

    public Cards getDeck() {
        return deck;
    }
}
