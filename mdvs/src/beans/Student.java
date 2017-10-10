package beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class Student 
{
	@Id
	@GenericGenerator(name="student_Id_Generator",strategy="native")
	@GeneratedValue(generator="student_Id_Generator")
	private Integer id;
	private String name;
	private int age;
	
	public Integer getId() 
	{
		return id;
	}
	public void setId(Integer id) 
	{
		this.id = id;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public int getAge() 
	{
		return age;
	}
	public void setAge(int age) 
	{
		this.age = age;
	}
	
	public Student() 
	{
		super();
	}
	public Student(String name, int age) 
	{
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() 
	{
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}
