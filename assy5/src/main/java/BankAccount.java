public class BankAccount {

    int balance = 300;
    int depositAmount;
    int withdrawalAmount;
    int pin = 1111;

    public int depositMoney(int depositAmount, boolean printReceipt, int pin){


        if(enterPin(pin)) {
            this.depositAmount = depositAmount;
            balance += depositAmount;

            if (printReceipt)
                return balance;
            return -1;
        }
        return 0;
    }

    public int withdrawMoney(int withdrawalAmount, boolean printReceipt, int pin){

        if(enterPin(pin)) {
            this.withdrawalAmount = withdrawalAmount;
            balance -= withdrawalAmount;

            if (printReceipt)
                return balance;
            return -1;
        }
        return 0;
    }

    public boolean enterPin(int pin){
        return pin == this.pin;
    }

    public boolean setPin(int pin, int newPin){
        if(pin == this.pin) {
            this.pin = newPin;
            return true;
        }
        return false;
    }

    public int checkBalance(){
        if(enterPin(pin))
            return balance;
        return -1;
    }
}
