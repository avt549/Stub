package otusApplication;

import configuration.WebConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RunnerApp extends WebConfiguration {
    public static void main(String[] args) {
        System.getProperties().put( "server.port", 8080 );
        SpringApplication.run(Controllers.class, args);
    }
}
