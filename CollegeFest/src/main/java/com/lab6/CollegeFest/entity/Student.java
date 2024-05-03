package com.lab6.CollegeFest.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Student Id")
	private int id;
	@Column(name="First Name")
	private String firstName;
	@Column(name="Last Name")
	private String lastName;
	@Column(name="Course")
	private String course;
	@Column(name="Country")
	private String country;
}
