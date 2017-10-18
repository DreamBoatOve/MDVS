package beans.material.service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import beans.material.service.test.test;

@Entity
@Table
public class service 
{
	@Id
	@GenericGenerator(name="service_Id_Generator",strategy="native")
	@GeneratedValue(generator="service_Id_Generator")
	private Integer service_id;
	
	@OneToOne(targetEntity=test.class)
	@JoinColumn(name="test",referencedColumnName="test_id",unique=true)
	private test test;

	public test getTest() 
	{
		return test;
	}
	public void setTest(test test) 
	{
		this.test = test;
	}
	
	public service() 
	{
		super();
	}
	public service(beans.material.service.test.test test) 
	{
		super();
		this.test = test;
	}
}
