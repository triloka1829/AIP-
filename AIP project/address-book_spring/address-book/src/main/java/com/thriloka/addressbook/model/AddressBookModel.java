package com.thriloka.addressbook.model;

public class AddressBookModel {

	private int personId;
	private String personName;
	private String personPhone;
	private String personCompany;
	
	public AddressBookModel() {}
	
	public AddressBookModel(String personName, String personPhone, String personCompany, int id) {
		super();
		this.personName = personName;
		this.personPhone = personPhone;
		this.personCompany = personCompany;
		this.personId = id;
	}
	
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getPersonPhone() {
		return personPhone;
	}
	public void setPersonPhone(String personPhone) {
		this.personPhone = personPhone;
	}
	public String getPersonCompany() {
		return personCompany;
	}
	public void setPersonCompany(String personCompany) {
		this.personCompany = personCompany;
	} 
}
