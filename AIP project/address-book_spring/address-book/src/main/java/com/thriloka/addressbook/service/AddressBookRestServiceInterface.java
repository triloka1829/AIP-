package com.thriloka.addressbook.service;

import java.util.ArrayList;

import com.thriloka.addressbook.model.AddressBookModel;

public interface AddressBookRestServiceInterface {
	
	public String addPerson(String name, String phone, String company);
	public String getList();
	public String updatePerson(String name, String phone, String company, int id);
	public String removePerson(int id);
	
}
