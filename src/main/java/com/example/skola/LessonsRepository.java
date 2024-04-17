package com.example.skola;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonsRepository extends CrudRepository<Lessons, Long> {
    Lessons findBySchoolClassAndSchoolDay(String schoolClass, String schoolDay);
    
}
