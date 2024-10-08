package com.BikkadIT.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.BikkadIT.app.model.Student;
import com.BikkadIT.app.service.StudentServiceI;

@Controller
public class StudentController {

	@Autowired
	private StudentServiceI studentServiceI;
	
	@GetMapping("/welcomeToReg")
	public String preReg() {
		return "welcome";
		
	}
	@GetMapping("/saveStu")
	public ModelAndView saveStud(Student stu) {
		Student saveStu = studentServiceI.saveStu(stu);
		ModelAndView mav=new ModelAndView();
		mav.addObject("STU", saveStu);
		mav.setViewName("Reg");
		return mav;
		
	}
	@GetMapping("/students")
	public ModelAndView getStudents() {
		List<Student> allStudent = studentServiceI.getAllStudent();
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("STUS", allStudent);
		mav.setViewName("allStudents");
		return mav;
		
	}
	
	@GetMapping("/deleteAll")
	public String deleteAllData(Model model) {
		boolean all = studentServiceI.deleteAll();
		if(all) {
			String msg = "Record deleted Successfully";
			model.addAttribute("delete", msg);
		return "page1";
		
		}else {
			String msg = "Record not deleted...";
			model.addAttribute("notDelete", msg);
		return "page1";
		}
	}
}
