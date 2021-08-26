package ws.prospeak.personal.spring.depth;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ws.prospeak.personal.spring.depth.appcontext.config.ApplicationConfig;
import ws.prospeak.personal.spring.depth.appcontext.service.OutputService;

public class Application {
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        OutputService outputService = ctx.getBean(OutputService.class);

        for (int i = 0; i < 5; i++) {
            outputService.generateOutput();
            Thread.sleep(5000);
        }
    }
}
