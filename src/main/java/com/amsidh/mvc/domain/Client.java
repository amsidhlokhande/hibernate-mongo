package com.amsidh.mvc.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Client {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	private String name;
	private String lastName;
	private int phone;
	private String address;
	private String email;

	private String bank;

	@OneToMany(mappedBy = "buyer", cascade = CascadeType.PERSIST)
	private Set<Store> purchases = new HashSet<>();

	Client() {

	}

	public Client(String name, String lastName, String email, String address, String bank) {
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.bank = bank;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getLastName() {

		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Store> getPurchases() {
		return purchases;
	}

	public void setPurchases(Set<Store> purchases) {
		this.purchases = purchases;
	}
}
