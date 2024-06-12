/**
* File: PlayBlackJack.java
* Description: This class is the main class that runs the BlackJack game.
* Lessons Learned: It helped me review how to create a class that extends another class, and overwrite methods.
* Instructor's Name: Barbara Chamberlin
*
* @author: Miguel Elizalde
* @since: 11/11/2023
*/
package BlackJackTest;

import BlackJackBase.PCard;
import BlackJackBase.PGame;
import BlackJackBase.PHand;

import java.awt.Color;

import BlackJack.BJCard;
import BlackJack.BJDeck;
import BlackJack.BJHand;

public class PlayBlackJack {
    public static void main(String[] args) {
        BJDeck deck = new BJDeck();
        deck.shuffle();
        PHand playerHand = new BJHand();
        PHand dealerHand = new BJHand();
        PGame.setBackgroundColor(Color.WHITE);
        PGame.setBannerColor(Color.LIGHT_GRAY);
        PGame.setBannerTextColor(Color.BLACK);
        PGame.setStatusTextColor(Color.red);
        PGame.setButtonTextColor(Color.BLACK);
        PGame.setButtonColor(Color.LIGHT_GRAY);
        PGame.setButtonHighlightColor(Color.GRAY);
        PGame.setFont("Arial");
        PGame.run(deck, dealerHand, playerHand);

    }
}
