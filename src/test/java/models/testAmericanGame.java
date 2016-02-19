package models;

import org.junit.Test;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.instanceOf;

/**
 * Created by ramcharan on 2/19/16.
 */
public class testAmericanGame
{
    @Test
    public void testAmGameCreation()
    {
        Game g = new amGame();
        assertNotNull(g);
    }

    @Test
    public void testAmGameClass()
    {
        Game g = new amGame();
        assertThat(g,instanceOf(amGame.class));
    }

    @Test
    public void testBuildDeck()
    {
        Game g = new amGame();
        g.buildDeck();

        assertEquals(52,g.deck.size());
    }

    @Test
    public void testAmGameShuffle()
    {
        Game g = new amGame();
        g.buildDeck();
        g.shuffle();

        assertNotEquals(2,g.deck.get(0).getValue());
    }

    @Test
    public void testAmGameStart()
    {
        Game g = new amGame();
        g.buildDeck();
        g.shuffle();
        g.dealFour();
        assertEquals(1,g.cols.get(0).size());
        assertEquals(1,g.cols.get(1).size());
        assertEquals(1,g.cols.get(2).size());
        assertEquals(1,g.cols.get(3).size());
    }

    @Test
    public void testAmCustomDeal()
    {
        Game g = new amGame();
        g.buildDeck();
        g.customDeal(0,3,6,9);
        assertEquals("2Clubs",g.cols.get(0).get(0).toString());
        assertEquals("3Clubs",g.cols.get(1).get(0).toString());
        assertEquals("4Clubs",g.cols.get(2).get(0).toString());
        assertEquals("5Clubs",g.cols.get(3).get(0).toString());
    }

    @Test
    public void testAmRemoveFunction()
    {
        Game g = new amGame();
        g.buildDeck();
        g.customDeal(0,3,6,9);
        g.remove(2);
        assertEquals(0,g.cols.get(2).size());
    }

    @Test
    public void testerMsg()
    {
        Game g = new amGame();
        assertEquals("No Error", g.errMsg);
    }
}
