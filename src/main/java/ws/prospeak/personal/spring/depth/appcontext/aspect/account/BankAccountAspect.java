package ws.prospeak.personal.spring.depth.appcontext.aspect.account;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

@Aspect
@Component
public class BankAccountAspect {
    private final static Logger LOGGER = LoggerFactory.getLogger(BankAccountAspect.class);

    @Before(value = "@annotation(ws.prospeak.personal.spring.depth.appcontext.aspect.account.AccountOperation)")
    public void getAccountOperationInfo(JoinPoint joinPoint) {

        // Method Information
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        LOGGER.info("full method description: {}", signature.getMethod());
        LOGGER.info("method name: {}", signature.getMethod().getName());
        LOGGER.info("declaring type: {}", signature.getDeclaringType());

        // Method args
        LOGGER.info("Method args names:");
        Arrays.stream(signature.getParameterNames())
                .forEach(s -> LOGGER.info("arg name: {}", s));

        LOGGER.info("Method args types:");
        Arrays.stream(signature.getParameterTypes())
                .forEach(s -> LOGGER.info("arg type: {}", s));

        LOGGER.info("Method args values:");
        Arrays.stream(joinPoint.getArgs())
                .forEach(o -> LOGGER.info("arg value: {}", o.toString()));

        // Additional Information
        LOGGER.info("returning type: {}", signature.getReturnType());
        LOGGER.info("method modifier: {}", Modifier.toString(signature.getModifiers()));
        Arrays.stream(signature.getExceptionTypes())
                .forEach(aClass -> LOGGER.info("exception type: {}", aClass));

        // Method annotation
        Method method = signature.getMethod();
        AccountOperation accountOperation = method.getAnnotation(AccountOperation.class);
        LOGGER.info("Account operation annotation: {}",accountOperation);
        LOGGER.info("Account operation value: {}", accountOperation.operation());
    }
}
