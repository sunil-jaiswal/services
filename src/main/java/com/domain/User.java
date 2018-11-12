/**
 * 
 */
package com.domain;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * @author sunil
 *
 */
@Entity
@Table(schema = "public", name = "user")
public class User  {
	
	@Id
	@SequenceGenerator(name = "USER_ID_GENERATOR", sequenceName= "USER_ID_SEQ",  allocationSize = 1)
	@GeneratedValue(strategy =  GenerationType.IDENTITY, generator="USER_ID_GENERATOR")
	private Long id;
	
	private String firstName;
	
	private String lastName;

	private String email;
	
	private String password;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roleId")
    private TypesData               roleId;

    @Column(name = "createdDate", nullable = false)
	private Timestamp createdDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TypesData getRoleId() {
		return roleId;
	}

	public void setRoleId(TypesData roleId) {
		this.roleId = roleId;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

}
