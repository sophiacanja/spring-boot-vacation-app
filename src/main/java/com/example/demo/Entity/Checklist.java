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

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "checklistId")
    private int checklistId;
	
	@Column(name="Item", length=255, nullable=false, unique=false)
	private String item; 
	
	@Column(name="VacationId")
	private int vacationId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false) 
	@JoinColumn(name = "vacationId")
	private VacationEntity vacation; 
	
	public Checklist() {
		
	}
	
	public Checklist(VacationEntity vacation, String item) {
		this.vacationId = vacation.getVacationId(); 
		this.item = item; 
	}
	
	public int getVacationId() {
		return vacationId;
	}
	public void setVacationId(int vacationId) {
		this.vacationId = vacationId;
	}
	public String getItem() {
		return item; 
	}
	public void setItem(String item) {
		this.item = item;
	}
	
}
