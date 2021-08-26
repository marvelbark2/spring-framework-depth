package ws.prospeak.personal.spring.depth.appcontext.aspect.softdelete;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ws.prospeak.personal.spring.depth.appcontext.domain.enitiy.TrackedEntity;

import java.io.Serializable;
import java.util.Collection;
import java.util.stream.Collectors;

@Aspect
@Component
public class SoftDeleteAspect {
    @Pointcut("@within(SoftDelete)")
    public void interceptedClass() {}

    @Around("execution(* *(..)) && (interceptedClass())")
    public Object getInterceptedClass(ProceedingJoinPoint jp) throws Throwable {
        Object output;
       if(jp.getArgs().length> 0) output = jp.proceed(jp.getArgs());
       else output = jp.proceed();
       try {
           if(output instanceof Collection ) {
               @SuppressWarnings("unchecked")  Collection<? extends TrackedEntity<? extends Serializable>> entities = (Collection<? extends TrackedEntity<? extends Serializable>>) output;
               output = entities.stream().filter(x -> !x.isDeleted()).collect(Collectors.toList());
           } else if(output instanceof TrackedEntity) {
               output = ((TrackedEntity<? extends Serializable>) output).isDeleted() ? null : output;
           }
       } catch (Exception e) {
           throw new IllegalStateException("The entity is not trackable");
       }

        return output;
    }

}
