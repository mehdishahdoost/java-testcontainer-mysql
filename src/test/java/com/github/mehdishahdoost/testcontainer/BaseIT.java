package com.github.mehdishahdoost.testcontainer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;

@SpringBootTest(
	webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
abstract class BaseIT {

	static MySQLContainer mysql = new MySQLContainer("mysql:5.7");

	@DynamicPropertySource
	static void dynamicPortMapping(DynamicPropertyRegistry registry) {
		mysql.start();
		registry.add("spring.datasource.url", mysql::getJdbcUrl);
		registry.add("spring.datasource.username", mysql::getUsername);
		registry.add("spring.datasource.password", mysql::getPassword);
	}

}
