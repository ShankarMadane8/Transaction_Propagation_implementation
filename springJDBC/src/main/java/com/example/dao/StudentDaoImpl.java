package com.example.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Student;



@Repository
public class StudentDaoImpl implements StudentDao {
      
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	
	//============================================================
	        // Transaction Propgation
	//============================================================

    @Transactional
	//@Transactional(propagation = Propagation.SUPPORTS)
	//@Transactional(propagation =Propagation.NOT_SUPPORTED)
	//@Transactional(propagation = Propagation.REQUIRES_NEW)
    //@Transactional(propagation = Propagation.NEVER )
    //@Transactional(propagation =Propagation.MANDATORY)
    //@Transactional(propagation = Propagation.NESTED)
	public void saveStudent(Student stu) {
    	//System.out.println("Strat Transaction 2......");
		String query="insert into student(id,name,address) values(?,?,?)";
		int insert = jdbcTemplate.update(query,stu.getId(),stu.getName(),stu.getAddress());
		System.out.println("save..");
		//System.out.println("end transaction2 ...........");
		
	}



    
    
    
    
	public String update(Student stu, int id) {
		String query="update student set name=? , address=? where id=?";
		int update = jdbcTemplate.update(query,stu.getName(),stu.getAddress(),id);
		System.out.println("update count:"+update); 
		return "update student successfully.....";
	}


	public String delete(int id) {
		String query="delete  from student where id=?";
		int delete = jdbcTemplate.update(query,id);
		System.out.println("delete count:"+delete); 
		return "delete student successfully.....";
	}


	public List<Student> getStudent() {
		String query="select * from student";
		List<Student> list=jdbcTemplate.query(query,new BeanPropertyRowMapper(Student.class));
		return list;
	}
	

}
