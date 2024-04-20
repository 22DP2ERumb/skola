package com.example.skola;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradesRepository extends CrudRepository<Grades, Long> {
    Grades findByStudentEmail(String email);
    
}
