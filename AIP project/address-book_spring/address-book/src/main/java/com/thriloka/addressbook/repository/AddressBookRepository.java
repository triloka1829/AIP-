package com.thriloka.addressbook.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.thriloka.addressbook.model.AddressBookModel;

@Repository
public class AddressBookRepository {

	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class AddressBookRowMapper implements RowMapper<AddressBookModel>{
        @Override
        public AddressBookModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        	AddressBookModel addressBookModel = new AddressBookModel();
        	addressBookModel.setPersonName(rs.getString("person_name"));;
        	addressBookModel.setPersonPhone(rs.getString("person_phone"));
        	addressBookModel.setPersonCompany(rs.getString("person_company"));
        	addressBookModel.setPersonId(Integer.parseInt(rs.getString("person_id")));
            return addressBookModel;
        }
    }
	
	public int insert(AddressBookModel addressBook) {
		String preparedStatment = "insert into t_person (person_name, person_phone, person_company) values (?, ?, ?)";
		return jdbcTemplate.update(preparedStatment, new Object[] {
				addressBook.getPersonName(), addressBook.getPersonPhone(), addressBook.getPersonCompany()
		});
	}
	
	public int udpate(AddressBookModel addressBook) {
		String preparedStatment = "update t_person set person_name = ?, person_phone = ?, person_company = ? where person_id = ?";
		return jdbcTemplate.update(preparedStatment, new Object[] {
				addressBook.getPersonName(), addressBook.getPersonPhone(), addressBook.getPersonCompany(), addressBook.getPersonId()
		});
	}
	
	
	
	public int delete(int id) {
		String preparedStatment = "delete from t_person where person_id=?";
		return jdbcTemplate.update(preparedStatment, new Object[] {id});
	}
	
	public ArrayList<AddressBookModel> findAll() {
        return (ArrayList<AddressBookModel>) jdbcTemplate.query("select * from t_person", new AddressBookRowMapper());
    }
}
