package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Sort;

import com.example.demo.Entity.Checklist;
import com.example.demo.Entity.VacationEntity;


public interface ChecklistRepository extends JpaRepository<Checklist, Integer>{

	//todo: make async
	List<Checklist> findByVacationId(int vacationId);
}
