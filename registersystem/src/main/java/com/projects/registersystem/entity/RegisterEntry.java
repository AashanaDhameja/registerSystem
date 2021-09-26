package com.projects.registersystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "registerEntry")
public class RegisterEntry {

	@Id
	private Integer visitorId;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "movement")
	private String movement;

	public Integer getVisitorId() {
		return visitorId;
	}

	public String getDate() {
		return date;
	}

	public String getMovement() {
		return movement;
	}

	public void setVisitorId(Integer visitorId) {
		this.visitorId = visitorId;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setMovement(String movement) {
		this.movement = movement;
	}

	public RegisterEntry(Integer visitorId, String date, String movement) {
		super();
		this.visitorId = visitorId;
		this.date = date;
		this.movement = movement;
	}

	public RegisterEntry() {
		super();
	}
	
	
	
}
