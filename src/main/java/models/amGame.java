package models;

/**
 * Created by Sam on 2/18/2016.
 */
public class amGame extends Game{
    @Override
    public void buildDeck() {
        for(int i = 2; i < 15; i++){
            deck.add(new Card(i,americanSuit.Clubs,null));
            deck.add(new Card(i,americanSuit.Hearts,null));
            deck.add(new Card(i,americanSuit.Diamonds,null));
            deck.add(new Card(i,americanSuit.Spades,null));
        }
    }

    @Override
    public void remove(int columnNumber) {
        if (colHasCards(columnNumber)) {
            Card c = getTopCard(columnNumber);
            Boolean removeCard = false;
            for (int i = 0; i < 4; i++) {
                if (i != columnNumber) {
                    if (colHasCards(i)) {
                        Card compare = getTopCard(i);
                        if (compare.getAmericanSuit() == c.getAmericanSuit()) {
                            if (compare.getValue() > c.getValue()) {
                                removeCard = true;
                            }
                        }
                    }
                }
            }
            if (removeCard) {
                this.cols.get(columnNumber).remove(this.cols.get(columnNumber).size() - 1);
                this.errMsg = "No Error";
            }
            if (!removeCard) {
                this.errMsg = "Invalid remove!";
            }
        }
    }
}
