package com.example.demo.Dto;

import com.example.demo.Entity.VacationEntity;

public class ChecklistDto {

	private Integer checklistId; 
	private String item;
	private Integer vacationId;
	private VacationEntity vacation; 
	
	public ChecklistDto() {
			
	}
	//getters and setters
	
	public VacationEntity getVacation() {
		return this.vacation; 
	}
	public void setVacation(VacationEntity vacation) {
		this.vacation = vacation;
	}
	
	public Integer getVacationId() {
		return vacationId;
	}
	public void setVacationId(Integer vacationId) {
		this.vacationId = vacationId;
	}
	public String getItem() {
		return item; 
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Integer getChecklistId() {
		return this.checklistId;
	}
	public void setChecklistId(Integer checklistId) {
		this.checklistId = checklistId;
	}
}
