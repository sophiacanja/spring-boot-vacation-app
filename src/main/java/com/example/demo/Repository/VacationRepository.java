package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.VacationEntity;

public interface VacationRepository extends JpaRepository<VacationEntity, Integer>{
	
}
