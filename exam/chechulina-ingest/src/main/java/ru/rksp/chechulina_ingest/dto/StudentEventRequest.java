package ru.rksp.chechulina_ingest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

@Schema(description = "Запрос на создание события студента")
public class StudentEventRequest {

    @Schema(description = "Фамилия студента", example = "Иванов")
    private String фамилия;

    @Schema(description = "Имя студента", example = "Иван")
    private String имя;

    @Schema(description = "Группа", example = "ИС-21")
    private String группа;

    @Schema(description = "Дата события", example = "2026-02-24T10:00:00")
    private LocalDateTime дата_события;

    @Schema(description = "Время получения", example = "2026-02-24T10:30:00")
    private LocalDateTime время_получения;

    public String getФамилия() { return фамилия; }
    public void setФамилия(String фамилия) { this.фамилия = фамилия; }

    public String getИмя() { return имя; }
    public void setИмя(String имя) { this.имя = имя; }

    public String getГруппа() { return группа; }
    public void setГруппа(String группа) { this.группа = группа; }

    public LocalDateTime getДата_события() { return дата_события; }
    public void setДата_события(LocalDateTime дата_события) { this.дата_события = дата_события; }

    public LocalDateTime getВремя_получения() { return время_получения; }
    public void setВремя_получения(LocalDateTime время_получения) { this.время_получения = время_получения; }
}