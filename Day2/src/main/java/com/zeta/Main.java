package com.zeta;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

         Bank bank = new Bank();


        bank.issueCard("Shiv" , CARD_TYPE.Emerald);
        bank.issueCard("Mani");
        //System.out.println(bank.card);

        }

    }
}