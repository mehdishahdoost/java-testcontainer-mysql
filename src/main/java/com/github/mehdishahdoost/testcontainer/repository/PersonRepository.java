package com.github.mehdishahdoost.testcontainer.repository;

import com.github.mehdishahdoost.testcontainer.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
