package action;

import beans.Student;
import service.IStudentService;

public class queryAction 
{
	private int id;
	private IStudentService service;
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public IStudentService getService() 
	{
		return service;
	}
	public void setService(IStudentService service) 
	{
		this.service = service;
	}
	
	public String execute()
	{
		Student student = service.findStudentById(id);
		System.out.println(student.toString());
		return "success";
	}
}
