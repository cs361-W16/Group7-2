package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by michaelhilton on 1/25/16.
 */

public class Card implements Serializable {
    public final int value;
    public final americanSuit amSuit;
    public final spanishSuit spSuit;

    @JsonCreator
    public Card(@JsonProperty("value") int value, @JsonProperty("americanSuit") americanSuit amSuit, @JsonProperty("spSuit") spanishSuit spSuit)
    {
        this.value = value;
        this.amSuit = amSuit;
        this.spSuit = spSuit;
    }

    public americanSuit getAmericanSuit()
    {
        return amSuit;
    }

    public spanishSuit getSpanishSuit()
    {
        return spSuit;
    }

    public int getValue()
    {
        return value;
    }

    public String toString()
    {
        if (amSuit == null) { return this.value + this.spSuit.toString(); }

        return this.value + this.amSuit.toString();
    }
}
