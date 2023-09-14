package com.github.ghoultf.test.java.dp.bridge;

public class TestBridge {
    public static void main(String[] args) {
        // ABCBank b1 = new ABCDepositBank();
        ABCBank b1 = new ABCBank(new DepositAccount());
        b1.openAccount().showAccountType();

        // ABCBank b2 = new ABCSavingBank(new SavingAccount());
        ABCBank b2 = new ABCBank(new SavingAccount());
        b2.openAccount().showAccountType();

        // ICBCBank b3 = new ICBCDepositBank(new DepositAccount());
        ICBCBank b3 = new ICBCBank(new DepositAccount());
        b3.openAccount().showAccountType();

        // ICBCBank b4 = new ICBCSavingBank(new SavingAccount());
        ICBCBank b4 = new ICBCBank(new SavingAccount());
        b4.openAccount().showAccountType();
    }
}
