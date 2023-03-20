package com.example.dao;

import java.util.List;

import com.example.entity.Student;

public interface StudentDao {
	public void saveStudent(Student stu);
	public String update(Student stu,int id);
	public String delete(int id);
	public List<Student> getStudent();

}
