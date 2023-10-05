package com.example.demo.Service;

import java.util.List;
import java.util.stream.Collectors;

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
	
	//helper function that takes in a single checklist obj and returns a checklistDto
	public ChecklistDto createDto(Checklist obj) {
		ChecklistDto dto = new ChecklistDto();
		dto.setChecklistId(obj.getChecklistId());
		dto.setItem(obj.getItem());
		dto.setVacationId(obj.getVacationId());
		dto.setVacation(obj.getVacation());
		return dto;
	}
	
	//returns list of Checklist Obj with associated vacationId
	public List<ChecklistDto> getAllItems(Integer vacationId) {
		//if no vacationId is given return all entries in table
		if(vacationId == null) {
			return checklistRepository.findAll().stream().map(currObj -> createDto(currObj)).collect(Collectors.toList());
		}
		//return items associated with vacationId
		return checklistRepository.findByVacationId(vacationId).stream().map(currObj -> createDto(currObj)).collect(Collectors.toList());
	}
	
	//adds new row into database table
	public ChecklistDto addToChecklist(Checklist checklistObj) {
		return createDto(checklistRepository.save(checklistObj));
	}

}
