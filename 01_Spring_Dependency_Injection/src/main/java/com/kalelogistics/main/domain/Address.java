package com.kalelogistics.main.domain;

import org.springframework.stereotype.Component;

//@Component = Will mark this class as injectable and object can be created by spring container
@Component
public class Address {
	private int addressId;
	private String houseNumber;
	private String street;
	private String city;
	private int pin;

	public Address() {
		System.out.println("Default constructor of Address");
	}

	public Address(int addressId, String houseNumber, String street, String city, int pin) {
		super();
		this.addressId = addressId;
		this.houseNumber = houseNumber;
		this.street = street;
		this.city = city;
		this.pin = pin;
		System.out.println("Overloaded constructor of Address");
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", houseNumber=" + houseNumber + ", street=" + street + ", city="
				+ city + ", pin=" + pin + "]";
	}

}
