package com.nimendra;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    Player player;

    public PlayerTest() {
        player = new Player("Mike", 20);
        assertEquals(0, player.getLimit());
        assertEquals(20, player.getBalance());
    }


    @Test
    public void takeBet() throws Exception {

        /* indirectly we can test the "balance exceeds limits" functions.
         * We don't know what they're supposed to do or what their
		 * purpose is exactly but one occurs in takeBet and has a
		 * exception so we can do what the exception says and see if it
		 * gets raised.
		 */

        int bet = -1;
        int balance = player.getBalance();
        try {
            player.takeBet(bet);
            assertEquals(true, false); //if we get to this point, the exception was not thrown.
        } catch (IllegalArgumentException e) {
            assertEquals(true, e.getMessage().equals("Bet cannot be negative."));
        }

        player.setBalance(balance); //just in case it changed

        assertEquals(true, balance > 2); //so we can make sure we get a positive bet that is smaller than balance
        bet = balance - 1;

        boolean bThrewException = true;
        try {
            player.takeBet(bet);
            bThrewException = false; //only gets here if no exception thrown.
        } catch (IllegalArgumentException e) {
            assertEquals(true, false);//don't want an exception thrown
        }
        assertEquals(false, bThrewException);

        player.setBalance(balance); //just in case it changed

        int limit = player.getLimit();
        player.setLimit(5);
        bet = balance - player.getLimit() + 1;

        try {
            player.takeBet(bet);
            assertEquals(true, false); //if we get to this point, the exception was not thrown.
        } catch (IllegalArgumentException e) {
            assertEquals(true, e.getMessage().equals("Placing bet would go below limit."));
        }
    }

    @Test
    public void receiveWinnings() throws Exception {

        int balance = player.getBalance();

        int winnings = 10;

        player.receiveWinnings(winnings);

        assertEquals(balance + winnings, player.getBalance());

        player.setBalance(balance);
    }

}