package com.BikkadIT.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.app.model.Student;
import com.BikkadIT.app.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentServiceI {
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveStu(Student stu) {
		Student student = studentRepository.save(stu);
		return student;
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> all = (List<Student>) studentRepository.findAll();
		return all;
	}

	@Override
	public boolean deleteAll() {
		List<Student> all = (List<Student>) studentRepository.findAll();
		if(all.isEmpty()) {
			return false;
		}else {
			studentRepository.deleteAll();
			return true;
		}
	}

}
