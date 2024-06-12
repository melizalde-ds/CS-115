/**
* File: BJCardTest.java
* Description: This class tests the BJCard class.
* Lessons Learned: It helped me review many things about JUnit.
* Instructor's Name: Barbara Chamberlin
*
* @author: Miguel Elizalde
* @since: 11/11/2023
*/
package BlackJack;

import static org.junit.Assert.*;
import org.junit.Test;

public class BJCardTest {
    @Test
    public void getRankTest() {
        BJCard card = new BJCard("ACE", "HEART");
        assertEquals("ACE", card.getRank());
    }

    @Test
    public void setRankTest() {
        BJCard card = new BJCard("ACE", "HEART");
        card.setRank("TWO");
        assertEquals("TWO", card.getRank());
    }

    @Test
    public void getSuitTest() {
        BJCard card = new BJCard("ACE", "HEART");
        assertEquals("HEART", card.getSuit());
    }

    @Test
    public void setSuitTest() {
        BJCard card = new BJCard("ACE", "HEART");
        card.setSuit("SPADE");
        assertEquals("SPADE", card.getSuit());
    }

    @Test
    public void hideCardTest() {
        BJCard card = new BJCard("ACE", "HEART");
        card.hideCard();
        assertEquals(true, card.isHidden());
    }

    @Test
    public void showCardTest() {
        BJCard card = new BJCard("ACE", "HEART");
        card.showCard();
        assertEquals(false, card.isHidden());
    }

    @Test
    public void isHiddenTest() {
        BJCard card = new BJCard("ACE", "HEART");
        assertEquals(false, card.isHidden());
    }

    @Test
    public void getTextTest() {
        BJCard card = new BJCard("ACE", "HEART");
        assertEquals("A\u2665", card.getText());
    }
}
