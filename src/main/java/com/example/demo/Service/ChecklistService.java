package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Dto.ChecklistDto;
import com.example.demo.Entity.Checklist;
import com.example.demo.Repository.ChecklistRepository;
import com.example.demo.Repository.VacationRepository;

@Service
public class ChecklistService {
	private ChecklistRepository checklistRepository;
	@Autowired 
	ChecklistService(ChecklistRepository repository){
		checklistRepository = repository; 
	}
	
	//returns a single checklist dto with given id
	public ChecklistDto getItem(int checklistId){
		Checklist checklistObj = checklistRepository.findById(checklistId).get();
		//if object is empty, return nothing
		if(checklistObj == null) {
			return null;
		}
		//if object is not empty, map object to dto and return dto
		return createDto(checklistObj);
	}
	
	public ChecklistDto createDto(Checklist obj) {
		ChecklistDto dto = new ChecklistDto();
		dto.setChecklistId(obj.getChecklistId());
		dto.setItem(obj.getItem());
		dto.setVacationId(obj.getVacationId());
		dto.setVacation(obj.getVacation());
		return dto;
	}

}
