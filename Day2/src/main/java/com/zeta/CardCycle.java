package com.zeta;

public class CardCycle {
    public ICreditCard createCard(String name, CARD_TYPE type  ){
        switch(type){
            case Emerald:
                return new EmeraldCreditCard(name);

            case Infinia:
                return new InfiniaCreditCard(name);
        }


        throw new IllegalArgumentException("not a valid cardtype");
    }

}
