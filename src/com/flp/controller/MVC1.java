package com.flp.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flp.pojo.Address;
import com.flp.pojo.Student;
import com.flp.service.BService;

@Controller
public class MVC1 {

	@RequestMapping(value = "/index.htm", method = RequestMethod.GET)
	public String showForm() {
		System.out.println("hello hi");
		return "index";
	}

	@RequestMapping(value = "/ShowAll.htm", method = RequestMethod.GET)
	public String showForm1() {
		System.out.println("hello hi");
		return "ShowAll";
	}

	@RequestMapping(value = "/SearchById.htm", method = RequestMethod.GET)
	public String showForm2() {
		System.out.println("hello hi");
		return "SearchById";
	}

	@RequestMapping(value = "/SearchByContent.htm", method = RequestMethod.GET)
	public String showForm3() {
		System.out.println("hello hi");
		return "SearchByContent";
	}

	@RequestMapping(value = "/Delete.htm", method = RequestMethod.GET)
	public String showForm4() {
		System.out.println("hello hi");
		return "Delete";
	}
	@RequestMapping(value = "/update.htm", method = RequestMethod.GET)
	public String showForm5() {
		System.out.println("hello hi");
		return "update";
	}

	// ===============================================Add Method==========================================//

	@RequestMapping(value = "/AddUser.htm", method = RequestMethod.POST)
	public @ResponseBody
	Student add(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("*************Add Method***********");
		Student s = new Student();

		String sname1 = request.getParameter("sname");
		String srole1 = request.getParameter("srole");
		int sage1 = Integer.parseInt(request.getParameter("sage"));
		String addressline1 = request.getParameter("add1");
		String addressline2 = request.getParameter("add2");
		String zipcode = request.getParameter("zip");
		//System.out.println("Helo Mr" + sname1);

		HashMap<String, Object> hm = new HashMap<String, Object>();
		BService bservice = new BService();
		hm.put("NAME", sname1);
		hm.put("ROLE", srole1);
		hm.put("AGE", sage1);
		hm.put("ADDR1", addressline1);
		hm.put("ADDR2", addressline2);
		hm.put("ZIP", zipcode);
		boolean response1;
		response1 = bservice.addStudent(hm);
		ArrayList<Student> al = new ArrayList<Student>();
		if(response1){
			s = bservice.searchStudentByRole(srole1);
		}
		
		
		return s;
	}

	// ====================================================To show all data==========================================//
	@RequestMapping(value = "/ShowAll.htm", method = RequestMethod.POST)
	public @ResponseBody
	ArrayList<Student> showAll(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("**********ShowAll*********** ");
		// Student s = new Student();

		String sname1 = request.getParameter("sname");

		//System.out.println("Helo Mr" + sname1);

		// HashMap<String, Object> hm=new HashMap<String, Object>();
		BService bservice = new BService();

		ArrayList<Student> al = new ArrayList<Student>();
		al = bservice.showAllStudent();
		//System.out.println(al);
		return al;
	}

	// =====================================================Search By Role number==========================================//
	@RequestMapping(value = "/SearchById.htm", method = RequestMethod.POST)
	public @ResponseBody
	Student searchByRole(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("**********SearchById***********");
		Student s = new Student();

		String srole1 = request.getParameter("srole");
		//System.out.println("Your role"+srole1);
		BService bservice = new BService();

		s = bservice.searchStudentByRole(srole1);
		//System.out.println(s);
		return s;
	}
	
	// ===========================================Search By Content ==========================================//
		@RequestMapping(value = "/SearchByContent.htm", method = RequestMethod.POST)
		public @ResponseBody
		ArrayList<Student> searchByContent(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			System.out.println("**************SearchByContent**********");
			// Student s = new Student();

			String input = request.getParameter("anytext");

			//System.out.println("Helo Mr" + input);

			// HashMap<String, Object> hm=new HashMap<String, Object>();
			BService bservice = new BService();

			ArrayList<Student> al = new ArrayList<Student>();
			al = bservice.searchByContent(input);
			//System.out.println(al);
			return al;
		}
		
		// ==========================================Delete By Role number==========================================//
		@RequestMapping(value = "/DeleteById.htm", method = RequestMethod.POST)
		public @ResponseBody
		ArrayList<Student> deleteByRole(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			System.out.println("****************Welcome to delete method******************");
		//	Student s = new Student();
			ArrayList<Student> alStudent=null;
			String srole1 = request.getParameter("srole");
			//System.out.println("Your role"+srole1);
			boolean result=false;
			BService bservice = new BService();

			result = bservice.deleteStudentByRole(srole1);
			if(result){
				alStudent=bservice.showAllStudent();
			}else{
				System.out.println("===SOME ISSUE IS COMMING===");
			}
		//	System.out.println(alStudent);
			return alStudent;
		}
		
		// ===============================================Update By Role number==========================================//
				@RequestMapping(value = "/UpdateByIdAction.htm", method = RequestMethod.POST)
				public @ResponseBody
				ArrayList<Student> UpdateByIdAction(HttpServletRequest request,
						HttpServletResponse response) throws Exception {
					System.out.println("************UpdateByIdAction************");
				//	Student s = new Student();
					ArrayList<Student> alStudent=null;
					String sname1 = request.getParameter("s_name");
					String srole1 = request.getParameter("s_role");
					int sage1 = Integer.parseInt(request.getParameter("s_age"));
					String zipcode = request.getParameter("s_zipcode");
					
					//System.out.println("Your role"+srole1);
					//System.out.println("Your zip"+zipcode);
					boolean result=false;
					BService bservice = new BService();

					result = bservice.UpdateByIdAction(srole1,sname1,sage1,zipcode);
					if(result){
						alStudent=bservice.showAllStudent();
					}else{
						System.out.println("===SOME ISSUE IS COMMING===");
					}
			//		System.out.println(alStudent);
					return alStudent;
				}

}
