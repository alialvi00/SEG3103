public class AtmMachine {

    private BankAccount bankAccount = new BankAccount();
    private Wallet wallet = new Wallet();
    private boolean pinValid;

    public int depositMoney(int cash, int pin, boolean printReceipt){
        int depositAmount = wallet.getCash(cash);
        pinValid = bankAccount.enterPin(pin);

        return bankAccount.depositMoney(depositAmount, printReceipt,pin);
    }

    public int withdrawMoney(int withdrawAmount, int pin, boolean printReceipt){
            int newBalance = bankAccount.withdrawMoney(withdrawAmount,printReceipt,pin);
            wallet.depositCash(withdrawAmount);
            return newBalance;
    }

    public boolean changePin(int pin, int newPin){
        pinValid = bankAccount.enterPin(pin);

        if(pinValid){
            int digits = Integer.toString(newPin).length();
            if(digits > 4)
                return false;
            bankAccount.setPin(pin,newPin);
            return true;
        }
        return false;
    }
}
