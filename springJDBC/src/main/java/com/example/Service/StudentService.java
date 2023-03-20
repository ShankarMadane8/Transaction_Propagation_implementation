package com.example.Service;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.StudentDao;
import com.example.dao.StudentDaoImpl;
import com.example.entity.Student;

@Service
public class StudentService {
	
	@Autowired
	StudentDao studentDao;
	
	@Transactional
	public void saveStudentInfo() {
		//System.out.println("Start Transaction 1...");
		for(int i=20;i<25;i++) {
			studentDao.saveStudent(new Student(i,"nagesh","latur"));
		}
		
	    //System.out.println("end Transaction1 ..........");
	}

}
