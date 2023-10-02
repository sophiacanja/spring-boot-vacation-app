package com.example.demo.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

@Entity
@Table(name="Vacation")
public class VacationEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int vacationId;
	
	@Column(name="Location", length=255, nullable=false, unique=false)
	private String location;
	
	@Column(name="DepartureDate",nullable=false, unique=false)
	private Date departureDate;
	
	public VacationEntity() {
		
	}
	
	public VacationEntity(String location, Date date){
		this.location = location;
		this.departureDate = date;
	}
	
	public int getVacationId() {
		return vacationId;
	}
	public void setVacationId(int vacationId) {
		this.vacationId = vacationId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

}
