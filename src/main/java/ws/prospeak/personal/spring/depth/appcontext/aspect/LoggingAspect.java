package ws.prospeak.personal.spring.depth.appcontext.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerFactory.class);

    @Pointcut(value="@annotation(name)")
    public void executeLogging(Logging name) {}

    //Before advice
    @Before("executeLogging(logging)")
    public void logMethodCalled(JoinPoint joinPoint, Logging logging) {
        LOGGER.info("After advice: " + "JoinPoint is completed: " + joinPoint.getSignature().toString() + "  ");
    }
}
