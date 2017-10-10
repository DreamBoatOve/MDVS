package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import beans.Student;
import service.IStudentService;

@Component("registerAction")
@Scope("prototype")
@Namespace("/test")
@ParentPackage("struts-default")
public class registerAction 
{
	private String name;
	private Integer age;
	
	@Autowired
	@Qualifier("studentService")	//byName注入
	private IStudentService service;
	
	public IStudentService getService() 
	{
		return service;
	}
	public void setService(IStudentService service) 
	{
		this.service = service;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public Integer getAge() 
	{
		return age;
	}
	public void setAge(Integer age) 
	{
		this.age = age;
	}
	@Action(value="register", results=@Result(location="/welcome.jsp"))
	public String execute()
	{
		System.out.println(name+" whose age is "+age+" years old is about to be stored into database.");
		Student stu = new Student(name,age);
		service.addStudent(stu);
		return "success";
	}
}
