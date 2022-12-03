package com.github.mehdishahdoost.testcontainer.controller;

import lombok.AllArgsConstructor;

import com.github.mehdishahdoost.testcontainer.repository.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class PersonController {

    private PersonRepository personRepository;

    @GetMapping("/name")
    public List<String> getName() {
        return personRepository.findAll().stream()
                               .map(p->p.getName())
                               .collect(Collectors.toList());
    }

}
