package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by michaelhilton on 1/25/16.
 */
public abstract class Game
{
    //abstract functions for spanish and american games
    public abstract void remove(int columnNumber);
    public abstract void buildDeck();

    public java.util.List<Card> deck = new ArrayList<>();

    public java.util.List<java.util.List<Card>> cols = new ArrayList<>();

    public String errMsg="No Error";

    public Game()
    {
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
    }

    public void shuffle()
    {
        long seed = System.nanoTime();
        Collections.shuffle(deck, new Random(seed));
    }

    public void dealFour()
    {
        for(int i = 0; i < 4; i++)
        {
            cols.get(i).add(deck.get(deck.size()-1));
            deck.remove(deck.size()-1);
        }
    }

    //customDeal to setup game for testing purposes
    public void customDeal(int c1, int c2, int c3, int c4)
    {
        cols.get(0).add(deck.get(c1));
        deck.remove(c1);
        cols.get(1).add(deck.get(c2));
        deck.remove(c2);
        cols.get(2).add(deck.get(c3));
        deck.remove(c3);
        cols.get(3).add(deck.get(c4));
        deck.remove(c4);
    }

    protected boolean colHasCards(int colNumber)
    {
        if(this.cols.get(colNumber).size()>0)
        {
            return true;
        }
        return false;
    }

    protected Card getTopCard(int columnNumber)
    {
        return this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1);
    }


    public void move(int colFrom, int colTo)
    {
        if(colHasCards(colTo))
        {
            this.errMsg = "Invalid move";
        }
        else
        {
            this.errMsg = "No Error";
            Card cardToMove = getTopCard(colFrom);
            this.removeCardFromCol(colFrom);
            this.addCardToCol(colTo, cardToMove);

        }
    }

    protected void addCardToCol(int colTo, Card cardToMove)
    {
        cols.get(colTo).add(cardToMove);
    }

    protected void removeCardFromCol(int colFrom)
    {
        this.cols.get(colFrom).remove(this.cols.get(colFrom).size()-1);

        //I think that should conflict...
        //Did it work yet?

    }
}
