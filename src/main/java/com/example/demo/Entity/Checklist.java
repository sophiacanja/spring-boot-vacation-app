package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="Checklist")
public class Checklist {

	//declare column and relationships of checklistId, vacationId, and vacation obj
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "checklistId")
    private Integer checklistId;
	
	@Column(name="Item", length=255, unique=false)
	private String item; 
	

	@Column(name="VacationId",unique=false)
	private Integer vacationId;
	
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "VacationId", insertable=false, updatable=false)
	private VacationEntity vacation; 
	
	//default empty constructor
	public Checklist() {
		
	}
	
	//getters and setters
	public Integer getVacationId() {
		return vacationId;
	}
	public void setVacationId(Integer vacationId) {
		this.vacationId = vacationId;
	}
	
	public VacationEntity getVacation() {
		return this.vacation; 
	}
	public void setVacation(VacationEntity vacation) {
		this.vacation = vacation;
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
