package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Repository.VacationRepository;



@SpringBootTest
class VacationApp1ApplicationTests {
	
	@Autowired
	private VacationRepository vacationRepository; 

//	@Test
//	public void saveVacationTest_thenFIndsByName() {
//		Date currentDate = new Date(System.currentTimeMillis());
//		vacationRepository.save(new VacationEntity(
//				"San Clemente",
//				currentDate));
//		assertThat(vacationRepository.findAll()).isNotNull();
//	}
	
	@Test
	void contextLoads() {
		System.out.println("HELLO WORLD");
	}

}
