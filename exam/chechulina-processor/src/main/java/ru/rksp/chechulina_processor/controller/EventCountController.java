package ru.rksp.chechulina_processor.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import ru.rksp.chechulina_processor.repository.postgres.StudentEventRepository;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/events")
@Tag(name = "Статистика", description = "Контроллер для подсчета событий")
public class EventCountController {

    private static final Logger log = LoggerFactory.getLogger(EventCountController.class);
    private final StudentEventRepository eventRepository;
    private final JdbcTemplate clickhouseJdbcTemplate;

    @Autowired
    public EventCountController(
            StudentEventRepository eventRepository,
            @Qualifier("clickhouseJdbcTemplate") JdbcTemplate clickhouseJdbcTemplate) {
        this.eventRepository = eventRepository;
        this.clickhouseJdbcTemplate = clickhouseJdbcTemplate;
    }

    @PostMapping("/count")
    @Operation(summary = "Получить количество записей в PostgreSQL и записать в ClickHouse")
    public ResponseEntity<Map<String, Long>> countEvents() {
        long count = eventRepository.count();
        log.info("Количество записей в PostgreSQL: {}", count);

        try {
            String sql = "INSERT INTO default.агрегаты_событий_студентов (дата_и_время_записи, количество_записей) VALUES (?, ?)";
            clickhouseJdbcTemplate.update(sql, LocalDateTime.now(), count);
            log.info("Данные записаны в ClickHouse");
        } catch (Exception e) {
            log.error("Ошибка при записи в ClickHouse: {}", e.getMessage());
        }

        return ResponseEntity.ok(Map.of("recordCount", count));
    }
}