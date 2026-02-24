package ru.rksp.chechulina_processor.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.rksp.chechulina_ingest.dto.StudentEventRequest;
import ru.rksp.chechulina_processor.model.postgres.StudentEvent;
import ru.rksp.chechulina_processor.repository.postgres.StudentEventRepository;

@Component
public class RabbitMQListener {

    private static final Logger log = LoggerFactory.getLogger(RabbitMQListener.class);
    private final StudentEventRepository repository;

    public RabbitMQListener(StudentEventRepository repository) {
        this.repository = repository;
    }

    @RabbitListener(queues = "events.raw")
    public void receiveMessage(StudentEventRequest request) {
        log.info("Получено событие: студент {} {}", request.getФамилия(), request.getИмя());

        StudentEvent event = new StudentEvent();
        event.setФамилия(request.getФамилия());
        event.setИмя(request.getИмя());
        event.setГруппа(request.getГруппа());
        event.setДата_события(request.getДата_события());
        event.setВремя_получения(request.getВремя_получения());

        repository.save(event);
        log.info("Событие сохранено в PostgreSQL");
    }
}