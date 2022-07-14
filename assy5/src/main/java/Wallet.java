public class Wallet {

    int cashAvailable = 1000;

    public int depositCash(int depositCash){
        cashAvailable -= depositCash;
        return depositCash;
    }

    public int getCash(int cash){
        cashAvailable = cashAvailable + cash;
        return cash;
    }
}
