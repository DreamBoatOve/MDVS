package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Student;
import service.IStudentService;

public class myTest 
{
	private IStudentService service;
	@Before
	public void before()
	{
		//create container
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = (IStudentService) ac.getBean("studentService");
	}
	@Test
	public void test()
	{
		Student stu = new Student("Jean",15);
		service.addStudent(stu);
	}
}
