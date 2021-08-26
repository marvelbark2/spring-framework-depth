package ws.prospeak.personal.spring.depth.appcontext.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TimeService {

    @Value("#{new Boolean(environment['envTarget'] != 'dev')}")
    private boolean is24;

    public String getTime() {
        LocalDateTime now = LocalDateTime.now();
        if(is24)
            return now.format(DateTimeFormatter.ISO_LOCAL_TIME);
        else {
            return now.minusHours(12).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        }
    }
}
