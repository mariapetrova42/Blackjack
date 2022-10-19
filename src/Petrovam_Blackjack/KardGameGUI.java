package Petrovam_Blackjack;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * KardGameGUI.java
 * @author Maria Petrova
 * @description A GUI-based game of blackjack played against the house. There is no betting system.
 * @version 7.0 finalized 10.10.22
 */

public class KardGameGUI
{
    // attributes
    static final int HANDSIZE = 10;
    static int handCount = 0;
    static Card nextCard;
    static CardDeck deck = new CardDeck();
    static Card[] yhand = new Card[10];
    static Card[] hhand = new Card[10];
    static JLabel[][] table = new JLabel[2][HANDSIZE];
    static JLabel winnerLoser;
    static JButton hit;
    static JButton stand;
    static JButton deal;
    static ButtonGroup hitstanGroup;
    static int y = 0;
    static int h = 0;
    static int ytot = 0;
    static int htot = 0;
    static int wins = 0;
    static int loss = 0;
    static int ties = 0;

    // methods

    /**
     * Main method: shuffles the deck and sets up the 'table' for gameplay
     * @param args
     */
    public static void main(String[] args)
    {
        deck.shuffle();
        for(int i = 0; i < HANDSIZE; i++) {
            table[0][i] = new JLabel("");
        }
        for(int i = 0; i < HANDSIZE; i++) {
            table[1][i] = new JLabel("");
        }


        JFrame frame = new JFrame("Blackjack GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.green);
        mainPanel.setPreferredSize(new Dimension(180 * HANDSIZE, 770));
        mainPanel.setLayout(new BorderLayout());

        JPanel north = new JPanel();
        north.setBackground(Color.white);
        north.setLayout(new FlowLayout());
        winnerLoser = new JLabel("Blackjack");
        north.add(winnerLoser);

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(2, 10));


        for(int i = 0; i < HANDSIZE; i++) {
            center.add(table[0][i]);
        }
        for(int i = 0; i < HANDSIZE; i++) {
            center.add(table[1][i]);
        }


        ButtonListener listener = new ButtonListener();
        hit = new JButton("Hit");
        stand = new JButton("Stand");
        deal = new JButton("Deal");
        hit.setEnabled(false);
        stand.setEnabled(false);
        deal.setEnabled(true);

        hitstanGroup = new ButtonGroup();
        hitstanGroup.add(hit);
        hitstanGroup.add(stand);
        hitstanGroup.add(deal);
        hit.addActionListener(listener);
        stand.addActionListener(listener);
        deal.addActionListener(listener);

        JPanel south = new JPanel();
        south.setLayout(new BorderLayout());
        JPanel hitStan = new JPanel();
        hitStan.setLayout(new FlowLayout());
        hitStan.add(hit);
        hitStan.add(stand);
        south.add(hitStan, BorderLayout.NORTH);
        south.add(deal, BorderLayout.SOUTH);

        mainPanel.add(north, BorderLayout.NORTH);
        mainPanel.add(center, BorderLayout.CENTER);
        mainPanel.add(south, BorderLayout.SOUTH);

        frame.getContentPane().add(mainPanel, "Center");
        frame.pack();
        frame.setVisible(true);

    }

    /**
     * ButtonListener class's actionPerformed method determines what happens when a user interacts with the GUI
     * The three buttons available for interaction are 'Hit', 'Stand', and 'Deal', with
     * different events happening when each button is pressed depending on the status of the game
     */
    private static class ButtonListener implements ActionListener
    {
        /**
         * actionPerformed moves the game forward depending on user interaction with the buttons of the GUI
         * @param event the event to be processed, aka the button pressed by the user
         */
        public void actionPerformed (ActionEvent event){
            if(event.getActionCommand().equals("Deal")){

                //housekeeping which clears the hy variables, hands, and table for next round
                for(int i = 0; i < 10; i++) {
                    table[0][i].setIcon(null);
                    table[1][i].setIcon(null);
                }

                y = 0; h = 0;
                ytot = 0; htot = 0;

                for(int i = 0; i < 10; i++) {
                    yhand[i] = null;
                    hhand[i] = null;
                }

                System.out.println();
                System.out.println("Deal");

                //what happens when you press "Deal"
                winnerLoser.setText("");
                handCount += 3;
                if(handCount + 3 >= 53) {
                    winnerLoser.setText("Game over!" + " Wins: " + wins + " Losses: " + loss + " Ties: " + ties);
                    deal.setEnabled(false);
                    hit.setEnabled(false);
                    stand.setEnabled(false);
                }
                else {
                    yhand[y] = deck.nextCard();
                    table[1][y].setIcon(yhand[y].getImage());
                    table[1][y].setVisible(true);
                    y++;

                    hhand[0] = deck.nextCard();
                    table[0][h].setIcon(hhand[0].getImage());
                    table[0][h].setVisible(true);
                    h++;

                    yhand[y] = deck.nextCard();
                    table[1][y].setIcon(yhand[y].getImage());
                    table[1][y].setVisible(true);
                    y++;

                    System.out.println("yhand0: " + yhand[0]);
                    System.out.println("yhand1: " + yhand[1]);
                    System.out.println("hhand0: " + hhand[0]);

                    ytot = helperJack.handTotal(yhand, y);
                    System.out.println("ytot: " + ytot);

                    deal.setEnabled(false);
                    hit.setEnabled(true);
                    stand.setEnabled(true);

                    if(ytot == 21) {
                        winnerLoser.setText("You got Blackjack! wins++");
                        wins++;

                        deal.setEnabled(true);
                        hit.setEnabled(false);
                        stand.setEnabled(false);

                        System.out.println("ubj w++");
                    }


                    hhand[1] = null;
                    table[0][1].setIcon(null);
                    for(int i = 2; i < 10; i++) {
                        yhand[i] = null;
                        hhand[i] = null;
                        table[0][i].setIcon(null);
                        table[1][i].setIcon(null);
                    }

                }
            }

            if(event.getActionCommand().equals("Hit")){
                nextCard = deck.nextCard();
                yhand[y] = nextCard;
                handCount++;
                System.out.println("yhand" + y + ": " + yhand[y]);
                table[1][y].setIcon(yhand[y].getImage());
                table[1][y].setVisible(true);
                y++;

                deal.setEnabled(false);
                hit.setEnabled(false);
                stand.setEnabled(false);

                ytot = helperJack.handTotal(yhand, y);
                if (helperJack.gotAce(yhand, ytot, y) && ytot > 21) ytot -= 10;

                System.out.println("ytot: " + ytot);


                // Determine and display results
                if (ytot < 21){
                    deal.setEnabled(false);
                    hit.setEnabled(true);
                    stand.setEnabled(true);

                }
                else if (ytot > 21){
                    winnerLoser.setText("You bust! #loss");
                    loss++;

                    deal.setEnabled(true);
                    hit.setEnabled(false);
                    stand.setEnabled(false);

                    System.out.println("ubb L++");

                }
                else{ //ytot == 21
                    winnerLoser.setText("You got 21! wins++");
                    wins++;

                    deal.setEnabled(true);
                    hit.setEnabled(false);
                    stand.setEnabled(false);

                    System.out.println("ubj w++");

                }

            }

            if(event.getActionCommand().equals("Stand")){

                System.out.println("ystand");
                houseTurn();
            }

        } //end of actionPerformed method

        /**
         * houseTurn moves the game forward based on the status of the game. The program decides whether the house
         * should hit or stand, depending on the current gameplay. This program is very rudimentary--
         * if the house's hand is less than 17, the house hits. Else, the house stands.
         */
        public void houseTurn() {

            deal.setEnabled(false);
            hit.setEnabled(false);
            stand.setEnabled(false);

            /*
               THIS IS THE COMPUTER DECIDING WHAT TO DO; AKA HOUSE TURN
            */

            // The bot will decide
            htot = helperJack.handTotal(hhand, h);
            if ((helperJack.gotAce(hhand, htot, h)) && (htot > 21)) htot -= 10;

            if(htot < 17) {
                nextCard = deck.nextCard();
                hhand[h] = nextCard;
                handCount++;
                System.out.println("hhand" + h + ": " + hhand[h]);
                table[0][h].setIcon(hhand[h].getImage());
                h++;
                htot = helperJack.handTotal(hhand, h);
                if ((helperJack.gotAce(hhand, htot, h)) && (htot > 21)) htot -= 10;
                System.out.println("htot: " + htot);

                while(htot < 17 && h < 5) {
                    nextCard = deck.nextCard();
                    hhand[h] = nextCard;
                    handCount++;
                    System.out.println("hhand" + h + ": " + hhand[h]);
                    table[0][h].setIcon(hhand[h].getImage());
                    h++;
                    htot = helperJack.handTotal(hhand, h);
                    if ((helperJack.gotAce(hhand, htot, h)) && (htot > 21)) htot -= 10;
                    System.out.println("htot: " + htot);

                }

                if(htot == 21) {
                    winnerLoser.setText("House gets 21! #loss");

                    if(h == 2) {
                        winnerLoser.setText("House gets Blackjack! #loss");
                    }

                    loss++;

                    deal.setEnabled(true);
                    hit.setEnabled(false);
                    stand.setEnabled(false);

                    System.out.println("hbj L++");

                } else if(htot > 21) {
                    winnerLoser.setText("House busts! wins++");
                    wins++;

                    deal.setEnabled(true);
                    hit.setEnabled(false);
                    stand.setEnabled(false);

                    System.out.println("hbb w++");


                } else {
                    if(htot > ytot) {
                        winnerLoser.setText("House wins! #loss");
                        loss++;

                        deal.setEnabled(true);
                        hit.setEnabled(false);
                        stand.setEnabled(false);

                        System.out.println("hww L++");

                    } else if(ytot > htot) {
                        winnerLoser.setText("You win! wins++");
                        wins++;

                        deal.setEnabled(true);
                        hit.setEnabled(false);
                        stand.setEnabled(false);

                        System.out.println("uww w++");

                    } else {
                        winnerLoser.setText("Push. tie+1");
                        ties++;

                        deal.setEnabled(true);
                        hit.setEnabled(false);
                        stand.setEnabled(false);

                        System.out.println("ppp t+1");

                    }
                }



            } else { //this means that 17 < htot < 21 bc otherwise house would have bust or BJ in prev turn
                //house stands
                //and if we're here that means that the player stood, too
                //so we compare scores
                if(htot > ytot) {
                    winnerLoser.setText("House wins! #loss");
                    loss++;

                    deal.setEnabled(true);
                    hit.setEnabled(false);
                    stand.setEnabled(false);

                    System.out.println("hww L++");

                } else if(ytot > htot) {
                    winnerLoser.setText("You win! wins++");
                    wins++;

                    deal.setEnabled(true);
                    hit.setEnabled(false);
                    stand.setEnabled(false);

                    System.out.println("uww w++");

                } else {
                    winnerLoser.setText("Push. tie+1");
                    ties++;

                    deal.setEnabled(true);
                    hit.setEnabled(false);
                    stand.setEnabled(false);

                    System.out.println("ppp t+1");

                }
            }


        } //end of houseTurn() method

    } //end of ButtonListener class

} // end of KardGameGUI class


