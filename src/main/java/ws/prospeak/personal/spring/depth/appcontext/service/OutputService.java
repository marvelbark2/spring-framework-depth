package ws.prospeak.personal.spring.depth.appcontext.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OutputService {
    private final GreetingService greetingService;
    private final TimeService timeService;

    @Value("${app.name}")
    private String to;

    public OutputService(GreetingService greetingService, TimeService timeService) {
        this.greetingService = greetingService;
        this.timeService = timeService;
    }

    public void generateOutput() {
        String msg = greetingService.getGreeting() + " " + to;
        System.out.println(timeService.getTime() + " " + msg);
    }
}
