package models;

/**
 * Created by Sam on 2/18/2016.
 */
public class spGame extends Game
{
    @Override
    public void buildDeck()
    {
        for (int i=1;i<8;i++)
        {
            deck.add(new Card(i,null,spanishSuit.Clubs));
            deck.add(new Card(i,null,spanishSuit.Coins));
            deck.add(new Card(i,null,spanishSuit.Swords));
            deck.add(new Card(i,null,spanishSuit.Cups));
        }

        for(int i=10;i<13;i++)
        {
            deck.add(new Card(i,null,spanishSuit.Clubs));
            deck.add(new Card(i,null,spanishSuit.Coins));
            deck.add(new Card(i,null,spanishSuit.Swords));
            deck.add(new Card(i,null,spanishSuit.Cups));
        }
    }

    @Override
    public void remove(int columnNumber)
    {
        if (colHasCards(columnNumber))
        {
            Card c = getTopCard(columnNumber);
            Boolean removeCard = false;
            for (int i = 0; i < 4; i++)
            {
                if (i != columnNumber)
                {
                    if (colHasCards(i))
                    {
                        Card compare = getTopCard(i);
                        if (compare.getSpanishSuit() == c.getSpanishSuit())
                        {
                            if (compare.getValue() > c.getValue())
                            {
                                removeCard = true;
                            }
                        }
                    }
                }
            }
            if (removeCard)
            {
                this.cols.get(columnNumber).remove(this.cols.get(columnNumber).size() - 1);
                this.errMsg = "No Error";
            }
            if (!removeCard)
            {
                this.errMsg = "Invalid remove!";
            }
        }
    }
}
