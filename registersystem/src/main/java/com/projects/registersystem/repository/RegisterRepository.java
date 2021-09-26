package com.projects.registersystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projects.registersystem.entity.RegisterEntry;

@Repository
public interface RegisterRepository extends JpaRepository<RegisterEntry, Integer>{
	
	public List<RegisterEntry> getRegisterEntryByDate(String date);
	public RegisterEntry getRegisterEntryByVisitorId(Integer visitorId);
}
