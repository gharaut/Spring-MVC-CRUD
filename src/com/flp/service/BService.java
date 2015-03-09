package com.flp.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.flp.dao.Dao;
import com.flp.dao.JDBCDao;
import com.flp.pojo.Address;
import com.flp.pojo.Student;

public class BService {

	public boolean addStudent(HashMap<String, Object> hm) {
		//Dao d1=new Dao();
		JDBCDao d=new JDBCDao();
		Student s1=new Student();
		Address a1=new Address();
		s1.setName((String) hm.get("NAME"));
		s1.setRole((String) hm.get("ROLE"));
		s1.setAge((int) hm.get("AGE"));
		a1.setAddressline1((String) hm.get("ADDR1"));
		a1.setAddressline2((String) hm.get("ADDR2"));
		a1.setZipcode((String) hm.get("ZIP"));
		s1.setAddrStudent(a1);
		return d.addStudent(s1);
		
	}

	public ArrayList<Student> showAllStudent() {
		//Dao d1=new Dao();
		JDBCDao d=new JDBCDao();
		//ArrayList<Student> al=new ArrayList<Student>();
		return d.showAllStudent();
	}

	public Student searchStudentByRole(String input) {
		JDBCDao d=new JDBCDao();
		//Dao d1=new Dao();
		return d.searchStudentByRole(input);
	}

	public ArrayList<Student> searchByContent(String input) {
		//Dao d=new Dao();
		JDBCDao d=new JDBCDao();
		return d.searchByContent(input);
	}

	public boolean deleteStudentByRole(String srole1) {
		System.out.println("Welcome to bservice");
		//Dao d=new Dao();
		JDBCDao d=new JDBCDao();
		return d.deleteStudentByRole(srole1);
	}

	public boolean UpdateByIdAction(String srole1, String sname1, int sage1,
			String zipcode) {
		JDBCDao d=new JDBCDao();
		return d.UpdateByIdAction(srole1,sname1,sage1,zipcode);
	}
	

}
