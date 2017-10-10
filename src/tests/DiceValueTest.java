package com.nimendra;

import org.junit.Test;

import static org.junit.Assert.*;

public class DiceValueTest {

    @Test
    public void TestToString(){

        DiceValue diceValue = DiceValue.SPADE;
        String sDiceValue = diceValue.toString(diceValue);
        assertEquals(true, sDiceValue.equals("Spade"));

        diceValue = DiceValue.HEART;
        sDiceValue = diceValue.toString(diceValue);
        assertEquals(true, sDiceValue.equals("Heart"));

        diceValue = DiceValue.CLUB;
        sDiceValue = diceValue.toString(diceValue);
        assertEquals(true, sDiceValue.equals("Club"));

        diceValue = DiceValue.DIAMOND;
        sDiceValue = diceValue.toString(diceValue);
        assertEquals(true, sDiceValue.equals("Diamond"));

        diceValue = DiceValue.CROWN;
        sDiceValue = diceValue.toString(diceValue);
        assertEquals(true, sDiceValue.equals("Crown"));

        diceValue = DiceValue.ANCHOR;
        sDiceValue = diceValue.toString(diceValue);
        assertEquals(true, sDiceValue.equals("Anchor"));

    }

    @Test
    public void TestGetRandom() throws Exception {
        DiceValue diceValue = DiceValue.getRandom();
        for (int i = 0; i < 50; i++) {
            assertEquals(true, diceValue.ordinal() > -1);
            assertEquals(true, diceValue.ordinal() < 6);
            diceValue = DiceValue.getRandom();
        }
    }

}