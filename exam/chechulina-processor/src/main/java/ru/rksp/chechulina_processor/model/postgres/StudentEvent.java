package ru.rksp.chechulina_processor.model.postgres;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "сырые_события_студентов")
public class StudentEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "идентификатор")
    private Integer идентификатор;

    @Column(name = "фамилия", nullable = false)
    private String фамилия;

    @Column(name = "имя", nullable = false)
    private String имя;

    @Column(name = "группа")
    private String группа;

    @Column(name = "дата_события", nullable = false)
    private LocalDateTime дата_события;

    @Column(name = "время_получения", nullable = false)
    private LocalDateTime время_получения;

    // Геттеры и сеттеры
    public Integer getИдентификатор() { return идентификатор; }
    public void setИдентификатор(Integer идентификатор) { this.идентификатор = идентификатор; }

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