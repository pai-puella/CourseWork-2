package com.example.exam2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Exam2ApplicationTests {

	@Test
	void contextLoads() {
		// Проверяет, что Spring контекст успешно загружается
	}

	@Test
	void mainMethodStartsApplication() {
		// Проверяет, что метод main успешно запускает приложение
		Exam2Application.main(new String[]{});
	}
}
