package ws.prospeak.personal.spring.depth.appcontext.service.throwable;

public class WithdrawLimitException extends Exception {
    public WithdrawLimitException(String message) {
        super(message);
    }
}
