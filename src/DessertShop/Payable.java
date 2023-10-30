/**
* File: Payable.java
* Description: This is an interface that defines the payment methods.
* Lessons Learned: How to create an interface
* Instructor's Name: Barbara Chamberlin
*
* @author: Miguel Elizalde
*/
package DessertShop;

public interface Payable {
    enum PayType {
        CASH, CARD, PHONE
    }

    public PayType getPayType();

    public void setPayType(PayType payType);
}
