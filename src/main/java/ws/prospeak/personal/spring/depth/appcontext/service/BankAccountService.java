package ws.prospeak.personal.spring.depth.appcontext.service;

import org.springframework.stereotype.Service;
import ws.prospeak.personal.spring.depth.appcontext.aspect.account.AccountOperation;
import ws.prospeak.personal.spring.depth.appcontext.domain.Account;
import ws.prospeak.personal.spring.depth.appcontext.service.throwable.WithdrawLimitException;

import java.util.Random;

@Service
public class BankAccountService {
    private final static Random RANDOM = new Random();

    @AccountOperation(operation = "deposit")
    public void deposit(Account account, Double amount) {
        account.setBalance(account.getBalance() + amount);
    }

    @AccountOperation(operation = "withdraw")
    public void withdraw(Account account, Double amount) throws WithdrawLimitException {

        if (amount > 500.0) {
            throw new WithdrawLimitException("Withdraw limit exceeded.");
        }

        account.setBalance(account.getBalance() - amount);
    }

    public double getBalance() {
        return RANDOM.nextDouble();
    }
}
