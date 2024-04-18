package com.example.skola;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {


    User findByEmails(String emails);
    User findByIsActiveTrue();
    List<User> findByLoreAndSchoolClass(String lore, String schoolClass);

}
