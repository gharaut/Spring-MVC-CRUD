package com.flp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.flp.pojo.Student;


public class Dao {
    int i=1;
    static ArrayList<Student> al=new ArrayList<Student>();
	public boolean addStudent(Student s1) {
		/*HashMap<Integer,Student> hm=new HashMap<Integer,Student>();
		hm.put(i, s1);*/
		
		al.add(s1);
		//System.out.println(al);
		return true;
	}
	public ArrayList<Student> showAllStudent() {
		//System.out.println("DAO"+al);
		return al;
	}
	public Student searchStudentByRole(String input) {
		Student s4=null;
		for(Student s2:al){
			if(input.equals(s2.getRole())){
				s4=s2;
			}
		}
		return s4;
	}
	public ArrayList<Student> searchByContent(String input) {
		ArrayList<Student> al1=new ArrayList<Student>();
		//Student s1=new Student();
		System.out.println("Input data from DAO"+input);
		for(Student s2:al){
			if(s2.getName().contains(input)){
				al1.add(s2);
			}
		}
		return al1;
	}
	public boolean deleteStudentByRole(String srole1) {
		ArrayList<Student> al1=showAllStudent();
		System.out.println("Hello DAO HOw are uuuuuu??");
		boolean result1=false;
		//Iterator<Student> ite = al.iterator();
		Iterator<Student> iter = al1.iterator();
		while(iter.hasNext()){
			Student str = iter.next();
		      if( srole1.equals(str.getRole() ))
		      {
		        iter.remove();
		        result1=true;
		      }
		}
		/*for(Student s2:al1){
			if(srole1.equals(s2.getRole())){
				al1.remove(s2);
				result1=true;
			}
		}*/
		System.out.println("Welcome to DAO delete "+result1);
		return result1;
	}

}
