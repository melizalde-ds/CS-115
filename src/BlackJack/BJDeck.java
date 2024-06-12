/**
* File: BJDeck.java
* Description: This class creates a BJDeck object.
* Lessons Learned: It helped me review how to create a class that extends another class, and overwrite methods.
* Instructor's Name: Barbara Chamberlin
*
* @author: Miguel Elizalde
* @since: 11/11/2023
*/
package BlackJack;

import java.util.ArrayList;
import java.util.Collections;

import BlackJackBase.PCard;

public class BJDeck implements BlackJackBase.PDeck{
    private ArrayList<BJCard> cards = new ArrayList<BJCard>();

    public BJDeck() {
        for(BJCard.Suit suit : BJCard.Suit.values()){
            for(BJCard.Rank rank : BJCard.Rank.values()){
                cards.add(new BJCard(rank.toString(), suit.toString()));
            }
        }
    }
    
    @Override
    public void shuffle() {
        Collections.shuffle(cards);
    }

    @Override
    public void addCard(PCard card) {
        cards.add((BJCard)card);
    }

    @Override
    public PCard dealCard() {
        if(cards.size() == 0){
            return null;
        }
        return cards.remove(cards.size() - 1);
    }

    @Override
    public PCard dealHiddenCard() {
        if (cards.size() == 0) {
            return null;
        }
        cards.get(cards.size() - 1).hideCard();
        return cards.remove(cards.size() - 1);
    }

    @Override
    public int cardCount() {
        return cards.size();
    }
    

   
}
