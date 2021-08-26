package ws.prospeak.personal.spring.depth.appcontext.config;

import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "ws.prospeak.personal.spring.depth.appcontext")
@EnableAspectJAutoProxy
public class ApplicationConfig {

}
