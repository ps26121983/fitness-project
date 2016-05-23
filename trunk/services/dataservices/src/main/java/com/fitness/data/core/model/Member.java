package com.fitness.data.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MEMBER_DETAILS")
public class Member {
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column(name="MEMBER_ID")
	private int id;
	@Column(name="MEMBER_NAME")
	private String name;
	@Column(name="CONTACT_NUM")
	private Long contactNo;
	@Column(name="ADDRESS")
	private String address;

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
