package ru.rksp.chechulina_processor.repository.postgres;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rksp.chechulina_processor.model.postgres.StudentEvent;

@Repository
public interface StudentEventRepository extends JpaRepository<StudentEvent, Integer> {
}