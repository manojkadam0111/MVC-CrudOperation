package com.BikkadIT.app.service;

import java.util.List;

import com.BikkadIT.app.model.Student;

public interface StudentServiceI {

	public Student saveStu(Student stu);
	
	public List<Student> getAllStudent();
}
