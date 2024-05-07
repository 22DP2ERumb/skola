package com.example.skola;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradesRepository extends CrudRepository<Grades, Long> {
    Grades findByStudentEmail(String email);

    List<Grades> findAllByOrderByMathematicsGradeAverageDesc();
    List<Grades> findAllByOrderByScienceAverageDesc();
    List<Grades> findAllByOrderByHistoryAverageDesc();
    List<Grades> findAllByOrderByEnglishAverageDesc();
    List<Grades> findAllByOrderBySportAverageDesc();
    List<Grades> findAllByOrderByComputerScienceAverageDesc();
    
}
