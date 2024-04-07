package com.user.Enitity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "first_name")
	private String fname;

	@Column(name = "last_name")
	private String lastname;

	@Column(name = "phone_no")
	private String phone;

	@Column(name = "enabled")
	private boolean enabled = true;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long id, String fname, String lastname, String phone, boolean enabled) {
		super();
		this.id = id;
		this.fname = fname;
		this.lastname = lastname;
		this.phone = phone;
		this.enabled = enabled;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fname=" + fname + ", lastname=" + lastname + ", phone=" + phone + ", enabled="
				+ enabled + "]";
	}

}
