/**
* File: BJCard.java
* Description: This class creates a BJCard object.
* Lessons Learned: It helped me review how to create a class that extends another class, and overwrite methods.
* Instructor's Name: Barbara Chamberlin
*
* @author: Miguel Elizalde
* @since: 11/11/2023
*/

package BlackJack;

import BlackJackBase.PCard;
import java.awt.Color;

public class BJCard extends PCard {
    private int rank;
    private int suit;
    private boolean hidden;

    public enum Rank {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, KNIGHT, QUEEN, KING
    };

    public enum Suit {
        SPADE, HEART, DIAMOND, CLUB
    }

    public BJCard(String rank, String suit) {
        this.rank = Rank.valueOf(rank).ordinal() + 1;
        this.suit = Suit.valueOf(suit).ordinal() + 1;
        this.hidden = false;
    }

    public String getRank() {
        return Rank.values()[this.rank - 1].toString();
    }

    public void setRank(String rank) {
        this.rank = Rank.valueOf(rank).ordinal() + 1;
    }

    public String getSuit() {
        return Suit.values()[this.suit - 1].toString();
    }

    public void setSuit(String suit) {
        this.suit = Suit.valueOf(suit).ordinal() + 1;
    }

    @Override
    public void hideCard() {
        this.hidden = true;
    }

    @Override
    public void showCard() {
        this.hidden = false;
    }

    @Override
    public boolean isHidden() {
        return this.hidden;
    }

    @Override
    public String getText() {
        String cardText = "";
        switch (this.rank) {
            case 1:
                cardText += "A";
                break;

            case 11:
                cardText += "J";
                break;

            case 12:
                cardText += "Kn";
                break;
            case 13:
                cardText += "Q";
                break;

            case 14:
                cardText += "K";
                break;

            default:
                cardText += this.rank;
                break;
        }
        switch (this.suit) {
            case 1:
                cardText += "\u2660";
                break;

            case 2:
                cardText += "\u2665";
                break;

            case 3:
                cardText += "\u2666";
                break;

            case 4:
                cardText += "\u2663";
                break;
        }
        return cardText;
    }

    @Override
    public Color getFontColor() {
        if (this.hidden) {
            return Color.LIGHT_GRAY;
        }
        if (this.suit == 2 || this.suit == 3) {
            return Color.RED;
        }
        return Color.BLACK;
    }

    @Override
    public Color getBorderColor() {
        if (this.hidden) {
            return Color.cyan;
        }
        if (this.suit == 2 || this.suit == 3) {
            return Color.RED;
        }
        return Color.BLACK;
    }

    @Override
    public Color getFaceColor() {
        if (this.hidden) {
            return Color.white;
        }
        return Color.WHITE;
    }

    @Override
    public Color getStripeColor() {
        if (this.hidden) {
            return Color.BLUE;
        }
        return Color.WHITE;
    }
}
