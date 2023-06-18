package az.rabbit.mq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitMqRunner {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqRunner.class, args);
    }
}