package ws.prospeak.personal.spring.depth.appcontext.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ws.prospeak.personal.spring.depth.appcontext.aspect.logging.Logging;

@Service
public class GreetingService {
    @Value("${app.greeting}")
    private String greeting;

    @Logging
    public String getGreeting() {
        return greeting;
    }
}
