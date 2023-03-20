package com.example.springJDBC;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.Service.StudentService;
import com.example.dao.StudentDao;
import com.example.entity.Student;

public class App 
{
    
	public static void main( String[] args )
    {
     
//      ApplicationContext context= new ClassPathXmlApplicationContext("com/example/springJDBC/config.xml");
	  ApplicationContext context= new AnnotationConfigApplicationContext(ConfigJDBC.class);
		  
	  //StudentDao studao=(StudentDao)context.getBean("studentDaoImpl");

	  StudentService studentService=(StudentService)context.getBean("studentService");
	  studentService.saveStudentInfo();
	  
	  
	  
	  
//      String msg=studao.saveStudent(new Student(6,"nagesh","latur"));
//      System.out.println(msg);
      
      
//      String msg =studao.update(new Student(2,"rahul","velapur"), 3);
//      System.out.println(msg);
      
      
//      String msg =studao.delete(3);
//      System.out.println(msg);
     
      
//      List<Student> list=studao.getStudent();
//      for(Student stu:list) {
//    	  System.out.println(stu.getId()+"\t"+stu.getName()+"\t\t"+stu.getAddress());
//      }
      
      
        
   }
}
