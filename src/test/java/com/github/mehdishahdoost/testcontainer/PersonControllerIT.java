package com.github.mehdishahdoost.testcontainer;


import com.github.mehdishahdoost.testcontainer.entity.Person;
import com.github.mehdishahdoost.testcontainer.repository.PersonRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import javax.annotation.PostConstruct;
import java.util.List;

public class PersonControllerIT extends BaseIT {

    @Autowired
    TestRestTemplate testRestTemplate;
    @Autowired
    PersonRepository personRepository;

    @PostConstruct
    public void setup() {
        Person person = new Person();
        person.setName("Test");
        personRepository.save(person);
    }

    @Test
    public void getName() {

        ResponseEntity<List<String>> exchange =
            testRestTemplate.exchange("/name", HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>() {
            });

        Assert.assertEquals(exchange.getBody().get(0), "Test");
    }

}
