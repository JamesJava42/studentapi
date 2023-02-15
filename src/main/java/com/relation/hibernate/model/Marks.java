package com.relation.hibernate.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "marks")
public class Marks {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "m_id")
	private int mid;
	@Column(name="his")
	private int sub1;
	@Column(name="sci")
	private int sub2;
	@Column(name="mat")
	private int sub3;
	@Column(name = "year")
	private long year;
	@Column(name="s_id")
	private int sid;
	
	@Column(name="standard")
	private int standard;
	
	@ManyToOne(targetEntity = Student.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "s_fk_id",referencedColumnName = "s_id")
	public Student student;
	
	@ManyToOne(targetEntity = Clas.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "c_fk_id",referencedColumnName = "c_id")
	public Clas clas;
	
	
	
	
	
	
	
	public int getStandard() {
		return standard;
	}

	public void setStandard(int standard) {
		this.standard = standard;
	}

	public long getYear() {
		return year;
	}

	public void setYear(long year) {
		this.year = year;
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

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	@Column(name="marks")
	private double marks;
	
	@Column(name="gpa")
	private float gpa;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="sc_id")
//	private Studentclass studentclass;

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public int getSub1() {
		return sub1;
	}

	public void setSub1(int sub1) {
		this.sub1 = sub1;
	}

	public int getSub2() {
		return sub2;
	}

	public void setSub2(int sub2) {
		this.sub2 = sub2;
	}

	public int getSub3() {
		return sub3;
	}

	public void setSub3(int sub3) {
		this.sub3 = sub3;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}
	
	
	
	

}
