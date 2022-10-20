Blackjack
@description: GUI game of blackjack
@author: Maria Petrova
-------------------------------------------------------
ABOUT THIS PROJECT:
    - This project was begun as an assignment for Oakton's CSC 241 Java Data Structures.
        In the end, the project became somewhat more complicated than what had been expected,
        but I am overall pleased with how it turned out. The GUI could definitely use a
        touch more of embellishment, but this is a decent game for a beginning blackjack
        player such as myself.
    - I've gone back and added some documentation, but otherwise the project has been
        left mostly untouched in terms of actual code. In the future, I'd like to streamline
        some methods and make variable names clearer.

TERMS AND DEFINITIONS:
    - Blackjack: When the sum of a hand equals 21 points. Automatic win.
    - Bust: When a drawn card raises the sum of a hand above 21 points. Automatic loss.
    - House: The computer against which the user is playing.
    - Hit: Player gets an additional card from the dealer.
    - Stand: Player does nothing, and the turn passes to the house. Or, the house stands and the round ends.

POINTS:
    - Number cards: Points equivalent to the number on the card.
    - Jack, Queen, King: worth 10 points each.
    - Ace: Worth either 1 or 11 points, depending on the situation.

HOW TO PLAY (SIMPLIFIED):
    0. This game is played with one standard deck of 52 cards.
    1. Press "Deal" to begin the game. The house will receive one card, and the player will receive two.
        The house's hand will be in the top row of the screen, and the player's hand will be in the bottom row.
    2. The player goes first.
        - If the hand dealt to the player is a blackjack (an ace and a face card): Player automatically wins the round.
            Press "Deal" to start a new round.
        - If the hand is not blackjack: player may either hit or stand.
            - If the player hits: the player gets one card from the dealer. If the point value of the player's hand
                is less than 21, the player may either hit again or stand. If the player gets blackjack, they
                automatically win the round. If the player busts, the house wins the round.
            - If the player stands: the turn passes to the house. If the house gets blackjack, the house wins.
                If the house busts, the player wins. If neither case is true, then the point values of the house's and
                the player's hands are compared, and the one with the greatest number of points (under 21) wins the round.
    3. Play continues until the deck is out of cards. Total wins, losses, and ties for the player will be
        displayed at the top of the window.
