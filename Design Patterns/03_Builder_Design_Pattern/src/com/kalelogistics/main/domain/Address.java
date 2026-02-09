package com.kalelogistics.main.domain;

public class Address {
	private String addressId;
	private String houseNumber;
	private String block;
	private String street;
	private String city;
	private String pin;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String addressId, String houseNumber, String block, String street, String city, String pin) {
		super();
		this.addressId = addressId;
		this.houseNumber = houseNumber;
		this.block = block;
		this.street = street;
		this.city = city;
		this.pin = pin;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
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

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", houseNumber=" + houseNumber + ", block=" + block + ", street="
				+ street + ", city=" + city + ", pin=" + pin + "]";
	}

}
