package com.projects.registersystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "persons")
public class Person {
	
	@Id
	@Column(name = "Id")
	@GenericGenerator(name = "inc", strategy = "increment")
	@GeneratedValue(generator = "inc")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "flatno")
	private String  flatNo;
	
	@Column(name = "purpose")
	private String purpose;
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getFlatNo() {
		return flatNo;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
	public Person() {
		super();
	}
	
	public Person(Integer id, String name, String flatNo, String purpose) {
		super();
		this.id = id;
		this.name = name;
		this.flatNo = flatNo;
		this.purpose = purpose;
	}
	
	
}
