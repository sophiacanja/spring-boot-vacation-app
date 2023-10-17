package com.example.demo.Controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/")
	public @ResponseBody List<VacationEntity> getAllVacations(){
		return vacationRepository.findAll(); 
	}
	
	//http://localhost:8080/Vacation/?vacationId=
	@GetMapping("/{id}")
	public Optional<VacationEntity> getVacation(@PathVariable(value="id")int vacationId) {
		return vacationRepository.findById(vacationId);	
	}
	
	
	/* takes in request body with this format 
	 * {
    	"location": "San Francisco",
    	"departureDate": "2023-09-22T07:00:00.000+00:00"
		}
	 */
	@PostMapping("/")
	public VacationEntity createVacation(@RequestBody VacationEntity vacation) {
		return vacationRepository.save(vacation);
	}
	
	//updates existing entry with request body, and creates a new entry if given id is not found 
	@PutMapping("/{id}")
	public VacationEntity updateVacation(@RequestBody VacationEntity vacation, @PathVariable(value="id") int vacationId) {
		Optional<VacationEntity> currVacation = vacationRepository.findById(vacationId);
		if(currVacation.isPresent()) {
			VacationEntity updatedVacation = currVacation.get();
			updatedVacation.setLocation(vacation.getLocation());
			updatedVacation.setDepartureDate(vacation.getDepartureDate());
			return vacationRepository.save(updatedVacation);
		} else {
			return vacationRepository.save(vacation);
		}
				
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteVacation(@PathVariable(value="id") int vacationId) {
		vacationRepository.deleteById(vacationId);
	}
	
	
	
}
