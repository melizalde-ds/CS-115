/**
* File: BJHand.java
* Description: This class creates a BJHand object.
* Lessons Learned: It helped me review how to create a class that extends another class, and overwrite methods.
* Instructor's Name: Barbara Chamberlin
*
* @author: Miguel Elizalde
* @since: 11/18/2023
*/
package BlackJack;

import java.util.ArrayList;

import BlackJackBase.PCard;
import BlackJackBase.PHand;

public class BJHand implements PHand {
    private ArrayList<BJCard> hand;

    public BJHand() {
        this.hand = new ArrayList<BJCard>();
    }

    @Override
    public int getSize() {
        return hand.size();
    }

    @Override
    public void addCard(PCard card) {
        hand.add((BJCard) card);
    }

    @Override
    public PCard getCard(int index) {
        return hand.get(index);
    }

    @Override
    public PCard removeCard(int index) {
        return hand.remove(index);
    }

    @Override
    public int getValue() {
        int value = 0;
        for (BJCard card : hand) {
            if (value <= 21 && card.getRank().equals("A") && value + 11 <= 21) {
                value += 11;
            } else if (value > 21 && card.getRank().equals("A")) {
                value += 1;
            } else if(BJCard.Rank.valueOf(card.getRank()).ordinal() > 10){
                value += 10;
            }else{
                value += BJCard.Rank.valueOf(card.getRank()).ordinal() + 1;
            }
        }
        return value;
    }
}
