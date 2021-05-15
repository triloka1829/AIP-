package com.thriloka.addressbook.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.thriloka.addressbook.model.AddressBookModel;
import com.thriloka.addressbook.repository.AddressBookRepository;

@Service
public class AddressBookRestService implements AddressBookRestServiceInterface {
	
	@Autowired
	AddressBookRepository addressBookRepository;

	@Override
	public String addPerson(String name, String phone, String company) {
		addressBookRepository.insert(new AddressBookModel(name, phone, company, Integer.MIN_VALUE));
		return "Success";
	}

	@Override
	public String getList() {
		ArrayList<AddressBookModel> AddressList = new ArrayList<AddressBookModel>();
		AddressList = addressBookRepository.findAll();
		return new Gson().toJson(AddressList);
	}

	@Override
	public String updatePerson(String name, String phone, String company, int id) {
		addressBookRepository.udpate(new AddressBookModel(name, phone, company, id));
		return "Success";
	}

	@Override
	public String removePerson(int id) {
		addressBookRepository.delete(id);
		return "Success";
	}

	
	
}
