package models;

import org.junit.Test;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.instanceOf;

/**
 * Created by michaelhilton on 1/26/16.
 */
public class testCard
{
    @Test
    public void testObjCreation()
    {
        Card c = new Card(5,null,spanishSuit.Cups);
        assertNotNull(c);
    }

    @Test
    public void testIfRightObj()
    {
        Card c = new Card(5,americanSuit.Clubs,null);
        assertThat(c,instanceOf(Card.class));
    }

    @Test
    public void testGetValue()
    {
        Card c = new Card(5,null,spanishSuit.Swords);
        assertEquals(5,c.getValue());
    }

    @Test
    public void testGetAmericanSuit()
    {
        Card c = new Card(5,americanSuit.Clubs,null);
        assertEquals(americanSuit.Clubs,c.getAmericanSuit());
    }

    @Test
    public void testGetSpanishSuit()
    {
        Card c = new Card(7,null,spanishSuit.Swords);
        assertEquals(spanishSuit.Swords,c.getSpanishSuit());
    }

    @Test
    public void testToStringAmerican()
    {
        Card c = new Card(5,americanSuit.Clubs,null);
        assertEquals("5Clubs",c.toString());
    }

    @Test
    public void testToStringSpanish()
    {
        Card c = new Card(3,null,spanishSuit.Swords);
        assertEquals("3Swords",c.toString());
    }
/*
    @Test
    public void testMoveCard()
    {
        Game g = new Game();
        g.buildDeck();
        g.customDeal(0,3,6,9);
        g.remove(2);
        assertEquals(0,g.cols.get(2).size());
        g.move(0,2);
        assertEquals(1,g.cols.get(2).size());
        assertEquals(0,g.cols.get(0).size());
    }

*/
}
