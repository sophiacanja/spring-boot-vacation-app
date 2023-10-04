package com.example.demo.Entity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="Vacation")
public class VacationEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "VacationId")
	private Integer vacationId;
	
	@Column(name="Location", length=255, nullable=false, unique=false)
	private String location;
	
	@Column(name="DepartureDate",nullable=false, unique=false)
	private Date departureDate;
	
//	@OneToMany(mappedBy="vacation", fetch = FetchType.LAZY,
//			cascade = CascadeType.ALL)
//	private Set<Checklist> item; 
	
	public VacationEntity() {
		
	}
	
	public VacationEntity(String location, Date date){
		this.location = location;
		this.departureDate = date;
	}
	
	public Integer getVacationId() {
		return vacationId;
	}
	public void setVacationId(Integer vacationId) {
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
