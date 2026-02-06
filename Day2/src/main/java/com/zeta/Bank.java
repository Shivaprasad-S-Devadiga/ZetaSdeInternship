package com.zeta;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    List<ICreditCard> cardslist = new ArrayList<>();
    CardCycle cardCycle = new CardCycle();

    ICreditCard issueCard(String customerName , CARD_TYPE type){
        //check for blank

        ICreditCard card = cardCycle.createCard(customerName , type);
        cardslist.add(card);
        return card;
    }

}
