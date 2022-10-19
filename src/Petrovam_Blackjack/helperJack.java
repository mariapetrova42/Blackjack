package Petrovam_Blackjack;

/**
 * helperJack.java
 * @author Maria Petrova
 * @description A helper class for KardGameGUI.java
 * @version 7.0 finalized 10.10.22
 */

public class helperJack
{
    /**
     *
     * @param hand an array containing a hand of Cards
     * @param hy hand size (excludes empty slots)
     * @return int value of the total value of the cards in the hand
     */
    public static int handTotal(Card[] hand, int hy)
    {
        int tot = 0;
        for (int i = 0; i < hy; i++)
            tot += hand[i].getValue();
        return tot;
    }

    /**
     * determines whether there are any aces in the hand, when the hand is worth over 21 points
     * @param hand an array containing an array of cards
     * @param tot the total value of the cards so far
     * @param hy the number of cards in the hand of Cards
     * @return boolean yessub if '1' should be used as the value of the ace instead of '11'
     */
    public static boolean gotAce(Card[] hand, int tot, int hy)
    {
        boolean yessub = false;

        if(tot > 21) {
            for (int i = 0; i < hy; i++) {
                if (hand[i].getRank() == Card.Rank.Ace) {
                    yessub = true;
                    break;
                }
            }
        }

        return yessub;
    }

    /**
     * counts and returns the number of aces in the hand
     * @param hand of Cards
     * @param hy number of cards in hand
     * @return
     */
    public static int numAce(Card[] hand, int hy)
    {
        int nuA = 0;

        for (int i = 0; i < hy; i++) {
            if (hand[i].getRank() == Card.Rank.Ace) {
                nuA++;
            }
        }

        return nuA;
    }

    /**
     * determines number of aces that need to be counted as 1s instead of 11s
     * @param tot point value of hand
     * @param nA number of aces in hand
     * @return number of aces counted as 1 instead of 11
     */
    public static int BumAce(int tot, int nA)
    {
        int bna = 0;

        if(tot > 21 && nA > 0) {
            tot -= 10;
            nA--;
            bna++;
            if(tot > 21 && nA > 0) {
                tot -= 10;
                nA--;
                bna++;
                if(tot > 21 && nA > 0) {
                    tot -= 10;
                    nA--;
                    bna++;
                    if(tot > 21 && nA > 0) {
                        tot -= 10;
                        nA--;
                        bna++;
                    }
                }
            }
        }

        return bna;
    }
}
