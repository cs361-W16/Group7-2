package models;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by ramcharan on 2/19/16.
 */
public class testSpanishGame
{
    @Test
    public void testSpGameCreation()
    {
        Game g = new spGame();
        assertNotNull(g);
    }

    @Test
    public void testSpGameClass()
    {
        Game g = new spGame();
        assertThat(g,instanceOf(spGame.class));
    }

    @Test
    public void testBuildDeck()
    {
        Game g = new spGame();
        g.buildDeck();

        assertEquals(40,g.deck.size());
    }

    @Test
    public void testSpGameShuffle()
    {
        Game g = new spGame();
        g.buildDeck();
        g.shuffle();

        assertNotEquals(2,g.deck.get(0).getValue());
    }

    @Test
    public void testSpGameStart()
    {
        Game g = new spGame();
        g.buildDeck();
        g.shuffle();
        g.dealFour();
        assertEquals(1,g.cols.get(0).size());
        assertEquals(1,g.cols.get(1).size());
        assertEquals(1,g.cols.get(2).size());
        assertEquals(1,g.cols.get(3).size());
    }

    @Test
    public void testSpCustomDeal()
    {
        Game g = new spGame();
        g.buildDeck();
        g.customDeal(0,3,6,9);
        assertEquals("1Clubs",g.cols.get(0).get(0).toString());
        assertEquals("2Clubs",g.cols.get(1).get(0).toString());
        assertEquals("3Clubs",g.cols.get(2).get(0).toString());
        assertEquals("4Clubs",g.cols.get(3).get(0).toString());
    }

    @Test
    public void testSpRemoveFunction()
    {
        Game g = new spGame();
        g.buildDeck();
        g.customDeal(0,3,6,9);
        g.remove(2);
        assertEquals(0,g.cols.get(2).size());
    }

    @Test
    public void testerMsg()
    {
        Game g = new spGame();
        assertEquals("No Error", g.errMsg);
    }
}
