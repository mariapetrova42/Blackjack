package Petrovam_Blackjack;

/**
 * methodTester.java
 * @description tests a number of methods, specifically from helperJack class
 * @author Maria Petrova
 * @version 7.0 Reviewed 10.10.22
 */

public class methodTester
{
    static final int HANDSIZE = 12;
    static int handCount = 0;
    static Card nextCard;
    static CardDeck deck = new CardDeck();
    static Card[] yhand = new Card[6];
    static Card[] hhand = new Card[6];
    static boolean gameOver = false;
    static int y = 0, h = 0, t = 0;
    static int ytot, htot;

    public static void main(String[] args)
    {
        deck.shuffle();

        /*
        yhand[0] = deck.nextCard();
        System.out.println("y: " + yhand[0]);
        y++;

        yhand[1] = deck.nextCard();
        y++;
        System.out.println("y: " + yhand[1]);

        ytot = helperJack.handTotal(yhand, y);
        System.out.println("ytot = " + ytot);

        System.out.println();
        */

        hhand[0] = deck.nextCard();
        h++;
        System.out.println("h: " + hhand[0]);

        hhand[1] = deck.nextCard();
        h++;
        System.out.println("h: " + hhand[1]);

        htot = helperJack.handTotal(hhand, h);
        System.out.println("htot = " + htot);

        System.out.println();

        /*
        yhand[2] = deck.nextCard();
        y++;
        System.out.println("y: " + yhand[2]);
        ytot = helperJack.handTotal(yhand, y);
        System.out.println("ytot nA = " + ytot);
        if (helperJack.gotAce(yhand, ytot, y)) ytot -= 10;
        System.out.println("ytot yA = " + ytot);
         */

        hhand[2] = deck.nextCard();
        h++;
        System.out.println("h: " + hhand[2]);
        htot = helperJack.handTotal(hhand, h);
        System.out.println("htot nA = " + htot);


        hhand[3] = deck.nextCard();
        h++;
        System.out.println("h: " + hhand[3]);
        htot = helperJack.handTotal(hhand, h);
        System.out.println("htot nA = " + htot);


        System.out.println("numA: " + helperJack.numAce(hhand, h));
        System.out.println("benumA: " + helperJack.BumAce(htot, helperJack.numAce(hhand, h)));
        int bna = helperJack.BumAce(htot, helperJack.numAce(hhand, h));
        if (helperJack.gotAce(hhand, htot, h)) htot -= bna*10;
        System.out.println("htot yA = " + htot);


    }

}