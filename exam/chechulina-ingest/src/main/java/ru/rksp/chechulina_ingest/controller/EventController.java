package ru.rksp.chechulina_ingest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rksp.chechulina_ingest.dto.StudentEventRequest;

@RestController
@RequestMapping("/api/v1/events")
@Tag(name = "События", description = "Контроллер для приема событий")
public class EventController {

    private static final Logger log = LoggerFactory.getLogger(EventController.class);
    private final RabbitTemplate rabbitTemplate;

    public EventController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping
    @Operation(summary = "Принять событие и отправить в очередь events.raw")
    public ResponseEntity<String> receiveEvent(@RequestBody StudentEventRequest eventRequest) {
        log.info("Получен запрос: студент {} {}, группа {}",
                eventRequest.getФамилия(), eventRequest.getИмя(), eventRequest.getГруппа());

        rabbitTemplate.convertAndSend("events.raw", eventRequest);
        return ResponseEntity.accepted().body("Событие принято и отправлено в очередь");
    }
}