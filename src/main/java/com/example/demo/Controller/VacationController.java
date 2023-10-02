package com.example.demo.Controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.VacationEntity;
import com.example.demo.Repository.VacationRepository;

@RestController
@RequestMapping("/Vacation")
public class VacationController {
	
	private final VacationRepository vacationRepository; 
	
	@Autowired
	VacationController(VacationRepository repository){
		vacationRepository = repository;
	}
	
	@GetMapping("/getAll")
	public @ResponseBody List<VacationEntity> getAllVacations(){
		return vacationRepository.findAll(); 
	}
	
	@GetMapping("/{id}")
	public Optional<VacationEntity> getVacation(@PathVariable(value="id")int vacationId) {
		return vacationRepository.findById(vacationId);	
	}
	
	@PostMapping("/createVacation")
	public VacationEntity createVacation(@RequestBody VacationEntity vacation) {
		return vacationRepository.save(vacation);
	}
	
}
