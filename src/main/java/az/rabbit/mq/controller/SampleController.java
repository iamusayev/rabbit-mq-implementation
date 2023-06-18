package az.rabbit.mq.controller;

import java.util.concurrent.ThreadLocalRandom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class SampleController {

    private final AmqpTemplate template;

    @PostMapping("/emit")
    public ResponseEntity<String> emit(@RequestBody String message) {
        log.info("Emit to myQueue");
        for (int i = 0; i < 10; i++) {
            template.convertAndSend("myQueue", ThreadLocalRandom.current());
        }
        return ResponseEntity.ok("Success emit to queue");
    }
}