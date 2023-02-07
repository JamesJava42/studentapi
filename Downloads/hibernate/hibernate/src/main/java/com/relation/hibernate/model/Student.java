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
@Table(name="student")
public class Student {
	
	
	@Id  //@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="s_id")
	private int sid;
	@Column(name="s_name")
	private String name;
	
	@Column(name="s_age")
	private int age;
	
	
//	@OneToMany(targetEntity =  Marks.class,cascade = CascadeType.ALL )
//	@JoinColumn(name = "s_fk",referencedColumnName = "s_id")
//	List<Marks> marks;
//	
//	
//	public List<Marks> getMarks() {
//		return marks;
//	}
//	public void setMarks(List<Marks> marks) {
//		this.marks = marks;
//	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Column(name="s_city")
	private String city;
	
	// @OneToOne(mappedBy = Studentclass,cascade = CascadeType.ALL)
	
	
	
	
	
	
	/*Getters and Setters*/
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public Student() {}
	public Student(int sid, String name, int age, String city) {
		super();
		this.sid = sid;
		this.name = name;
		this.age = age;
		this.city = city;
	}
	
	
	
	
	
	

}
