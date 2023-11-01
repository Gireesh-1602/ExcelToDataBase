package com.splenta.ReadExcelfileToDatabase.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="employeedetails")
@Getter
@Setter
@NoArgsConstructor
public class EmployeeEntity {
	@Id
	private double empId;
	@Column
	private String empName;
	@Column
	private String empDesignation;
	@Column
	private String empEmail;
	public double getEmpId() {
		return empId;
	}
	public void setEmpId(double empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDesignation() {
		return empDesignation;
	}
	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

}
