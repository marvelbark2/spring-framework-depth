package ws.prospeak.personal.spring.depth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ws.prospeak.personal.spring.depth.appcontext.config.ApplicationConfig;
import ws.prospeak.personal.spring.depth.appcontext.domain.Account;
import ws.prospeak.personal.spring.depth.appcontext.domain.Users;
import ws.prospeak.personal.spring.depth.appcontext.service.BankAccountService;
import ws.prospeak.personal.spring.depth.appcontext.service.OutputService;
import ws.prospeak.personal.spring.depth.appcontext.service.UsersService;
import ws.prospeak.personal.spring.depth.appcontext.service.throwable.WithdrawLimitException;

public class Application {
    static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        OutputService outputService = ctx.getBean(OutputService.class);
        BankAccountService bankAccountService = ctx.getBean(BankAccountService.class);
        UsersService usersService = ctx.getBean(UsersService.class);

        LOGGER.info("Users List {}", usersService.all());
        LOGGER.info("User with id 1 : {}", usersService.findUser(1));

        usersService.deleteUser(1);
        LOGGER.info("Deleted user 1");
        LOGGER.info("Users List {}", usersService.all());
        LOGGER.info("User with id 1 : {}", usersService.findUser(1));
        Account account = new Account();
        bankAccountService.deposit(account, 1_000.0);
        bankAccountService.withdraw(account, 500.0);
        bankAccountService.getBalance();

        for (int i = 0; i < 5; i++) {
            outputService.generateOutput();
            Thread.sleep(5000);
        }
    }
}
