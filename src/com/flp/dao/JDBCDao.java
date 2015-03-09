package com.flp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

import com.flp.pojo.Address;
import com.flp.pojo.Student;

public class JDBCDao {

	public boolean addStudent(Student s1) {
		
		System.out.println("ADD DAO");
		boolean res=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("Hell");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/tester2", "root", "");

			// here sonoo is database name, root is username and password
			
		//	System.out.println("Hello2");
			
			String sql = "INSERT INTO student (name, role, age, addr1,addr2,zip) VALUES (?, ?, ?, ?,?,?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, s1.getName());
			statement.setString(2, s1.getRole());
			statement.setLong(3, s1.getAge());
			statement.setString(4, s1.getAddrStudent().getAddressline1());
			statement.setString(5, s1.getAddrStudent().getAddressline2());
			statement.setString(6, s1.getAddrStudent().getZipcode());
			int rowsInserted = statement.executeUpdate();
		//	System.out.println("Hello =="+rowsInserted);
			if (rowsInserted > 0) {
			    System.out.println("A new user was inserted successfully!");
			    res=true;
			}
		
			
		
			con.close();

		} catch (Exception e) {
			System.out.println("SOME EXCEPTION WILL BE HERE in Dao "+e);
		}

		return res;
	}

	public ArrayList<Student> showAllStudent() {
		ArrayList<Student> alStudent=new ArrayList<Student>();
		
		Student s=new Student();
		Address a1=new Address();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		//	System.out.println("Hell");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/tester2", "root", "");

			// here sonoo is database name, root is username and password
			
			//System.out.println("Hello2");
			
			String sql = "SELECT * FROM student";
			PreparedStatement statement = con.prepareStatement(sql);
			
			
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				Student st=new Student();
				Address ad=new Address();
				st.setName(rs.getString("name"));
				st.setRole(rs.getString("role"));
				st.setAge(rs.getInt("age"));
				ad.setAddressline1(rs.getString("addr1"));
				ad.setAddressline2(rs.getString("addr2"));
				ad.setZipcode(rs.getString("zip"));
				st.setAddrStudent(ad);
				alStudent.add(st);
			}
		
			
		
			con.close();

		} catch (Exception e) {
			System.out.println("SOME EXCEPTION WILL BE HERE"+e);
		}
		
	//	System.out.println("HRRR"+alStudent);
		
		return alStudent;
	}

	public Student searchStudentByRole(String input) {
		Student s=new Student();
		Address a1=new Address();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		//	System.out.println("Hell");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/tester2", "root", "");

			// here sonoo is database name, root is username and password
			
			//System.out.println("Hello2");
			
			String sql = "SELECT * FROM student WHERE role=?";
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setString(1, input);
			
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()){
				s.setName(rs.getString("name"));
				s.setRole(rs.getString("role"));
				s.setAge(rs.getInt("age"));
				a1.setAddressline1(rs.getString("addr1"));
				a1.setAddressline2(rs.getString("addr2"));
				a1.setZipcode(rs.getString("zip"));
				s.setAddrStudent(a1);
			}
		
			
		
			con.close();

		} catch (Exception e) {
			System.out.println("SOME EXCEPTION WILL BE HERE"+e);
		}
		
		
		
		return s;
	}
	public ArrayList<Student> searchByContent(String input) {
		ArrayList<Student> al1=new ArrayList<Student>();
		//Student s1=new Student();
	//	System.out.println("Input data from DAO"+input);
		for(Student s2:showAllStudent()){
			if(s2.getName().contains(input)){
				al1.add(s2);
			}
		}
		return al1;
	}
	public boolean deleteStudentByRole(String srole1) {
		boolean res=false;
		Student s=new Student();
		Address a1=new Address();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Hell");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/tester2", "root", "");

			// here sonoo is database name, root is username and password
			
	//		System.out.println("Hello2 ur role is"+srole1);
			
			String sql = "DELETE FROM student WHERE role=?";
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setString(1, srole1);
			
			int x=statement.executeUpdate();
			//statement.executeUpdate();
			
			//System.out.println("Return"+statement.executeUpdate());
		
			
			//System.out.println(sql);
			//int x=statement.executeUpdate(sql);
			
			System.out.println("x"+x);
			if (x==1) {
			    System.out.println("A user deleted successfully!");
			    res=true;
			}
		
			
		
			con.close();

		} catch (Exception e) {
			System.out.println("SOME EXCEPTION WILL BE HERE"+e);
		}

		return res;
	}

	public boolean UpdateByIdAction(String srole1, String sname1, int sage1,String zipcode) {
		boolean res=false;
		Student s=new Student();
		Address a1=new Address();
		try {
			Class.forName("com.mysql.jdbc.Driver");
	//		System.out.println("Hell");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/tester2", "root", "");

			// here sonoo is database name, root is username and password
			
			System.out.println("Hello2 ur role is"+srole1);
			System.out.println("role"+srole1);
			System.out.println("name"+sname1);
			System.out.println("age"+sage1);
			System.out.println("zip"+zipcode);
			String sql = "UPDATE student SET name = ?,age=?,zip=? WHERE role = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setString(1, sname1);
			statement.setInt(2,sage1);
			statement.setString(3, zipcode);
			statement.setString(4, srole1);
			
			int x=statement.executeUpdate();
			//statement.executeUpdate();
			
			//System.out.println("Return"+statement.executeUpdate());
		
			
			//System.out.println(sql);
			//int x=statement.executeUpdate(sql);
			
			System.out.println("x"+x);
			if (x==1) {
			    System.out.println("A user deleted successfully!");
			    res=true;
			}
		
			
		
			con.close();

		} catch (Exception e) {
			System.out.println("SOME EXCEPTION WILL BE HERE"+e);
		}

		return res;
	}
	

}
