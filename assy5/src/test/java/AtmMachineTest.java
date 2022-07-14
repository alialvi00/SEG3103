import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.easymock.EasyMock.expect;

@RunWith(EasyMockRunner.class)
public class AtmMachineTest extends EasyMockSupport {

    @TestSubject
    AtmMachine atm = new AtmMachine();

    @Mock
    BankAccount bankAccount;

    @Mock
    Wallet wallet;

    @Test
    public void whenDepositMoney_BalanceGoesUp(){
        expect(wallet.getCash(50)).andReturn(50);
        expect(bankAccount.enterPin(1111)).andReturn(true);
        expect(bankAccount.depositMoney(50,true,1111)).andReturn(350);
        replayAll();

        atm.depositMoney(50,1111,true);

        verifyAll();
    }

    @Test
    public void whenWithdrawMoney_BalanceGoesDown(){
        expect(bankAccount.withdrawMoney(60,false,1111)).andReturn(-1);
        expect(wallet.depositCash(60)).andReturn(1060);
        replayAll();

        atm.withdrawMoney(60,1111,false);

        verifyAll();
    }

    @Test
    public void changePin_PinChanges(){
        expect(bankAccount.enterPin(1111)).andReturn(true);
        expect(bankAccount.setPin(1111,7860)).andReturn(true);
        replayAll();

        atm.changePin(1111,7860);

        verifyAll();
    }
}
