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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "studentclass")
public class Studentclass {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sc_id")
	private int id;
	
	@OneToOne( cascade = CascadeType.ALL)
	@JoinColumn(name = "s_s_id")
	private Student student;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Clas clas;
	
	private int promotion;
	
	
//	@OneToMany(targetEntity = Marks.class,cascade = CascadeType.ALL)
//	@JoinColumn(name = "sc_fk",referencedColumnName = "sc_id")
//	List<Marks> marks;
//	
	

//	public List<Marks> getMarks() {
//		return marks;
//	}
//
//	public void setMarks(List<Marks> marks) {
//		this.marks = marks;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Clas getClas() {
		return clas;
	}

	public void setClas(Clas clas) {
		this.clas = clas;
	}

	public int getPromotion() {
		return promotion;
	}

	public void setPromotion(int promotion) {
		this.promotion = promotion;
	}

	public Studentclass(int id, Student student, Clas clas, int promotion) {
		super();
		this.id = id;
		this.student = student;
		this.clas = clas;
		this.promotion = promotion;
	}
	
	
	public Studentclass() {}
	
	
	
	
	

}
