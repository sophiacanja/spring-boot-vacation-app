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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Checklist;
import com.example.demo.Repository.ChecklistRepository;

@RestController 
@RequestMapping("/Checklist")
public class ChecklistController {
	
	private final ChecklistRepository checklistRepository; 
	
	@Autowired ChecklistController(ChecklistRepository repository){
		checklistRepository = repository; 
	}
	
	@GetMapping("/getItems/{id}")
	public @ResponseBody Optional<Checklist> getAllItems(@PathVariable(value="id")int vacationId){
		return checklistRepository.findById(vacationId);
	}
	

}
