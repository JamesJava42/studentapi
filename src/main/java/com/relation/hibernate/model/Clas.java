package com.relation.hibernate.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "class")
public class Clas {
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "c_id")
	private int id;
	
	@Column(name="c_stand")
	private int standard;
	

	/*Getter setters*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getStandard() {
		return standard;
	}
	public void setStandard(int standard) {
		this.standard = standard;
	}
	public Clas(int id, int standard) {
		super();
		this.id = id;
		
		this.standard = standard;
	}
	
	
	public Clas() {}
	
	
	
	
	
	

}
