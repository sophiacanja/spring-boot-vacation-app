package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.example.demo.Dto.ChecklistDto;
import com.example.demo.Entity.Checklist;
import com.example.demo.Repository.ChecklistRepository;
import com.example.demo.Repository.VacationRepository;
import com.example.demo.Service.ChecklistService;

@RestController 
@RequestMapping("/Checklist")
public class ChecklistController {
	
	private final ChecklistService checklistService; 
	
	@Autowired 
	ChecklistController(ChecklistService service){
		checklistService = service; 
	}
	

	//cannot send 400 error, only returns 500
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<ChecklistDto> getItem(@PathVariable(value="id")int checklistId){
		try{
			ChecklistDto checklistDto = checklistService.getItem(checklistId);
			return ResponseEntity.ok(checklistDto);
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
//	@GetMapping("/")
//	public @ResponseBody List<Checklist> getAllItems(@RequestParam(required = false) Integer vacationId){
//		if(vacationId != null) {
//			return checklistRepository.findByVacationId(vacationId) ;
//		}
//		return checklistRepository.findAll();
//	}
//	
//	@PostMapping("/")
//	public Checklist addToChecklist(@RequestBody Checklist item) {
//			return checklistRepository.save(item);
//	}
	

}
