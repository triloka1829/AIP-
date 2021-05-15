package com.thriloka.addressbook.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thriloka.addressbook.service.AddressBookRestService;

@RestController
public class RestApi {
	
	@Autowired
	AddressBookRestService service;
	
	@GetMapping(value = "/findAllAddress")
	public ResponseEntity<String> findAllAddress() {
		return new ResponseEntity<String>(service.getList(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/addAddress")
	public ResponseEntity<String> addAddress(@RequestParam String name, @RequestParam String phone, @RequestParam String company){
		return new ResponseEntity<String>(service.addPerson(name, phone, company), HttpStatus.OK);
	}
	
	@PostMapping(value = "/updateAddress")
	public ResponseEntity<String> updateAddress(@RequestParam String name, @RequestParam String phone, @RequestParam String company, @RequestParam String id){
		return new ResponseEntity<String>(service.updatePerson(name, phone, company, Integer.parseInt(id)), HttpStatus.OK);
	}
	
	@PostMapping(value = "/deleteAddress")
	public ResponseEntity<String> deleteAddress(@RequestParam String id){
		return new ResponseEntity<String>(service.removePerson(Integer.parseInt(id)), HttpStatus.OK);
	}
	
}
