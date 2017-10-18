package beans.material.service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import beans.material.service.environment.environment;
import beans.material.service.test.test;

@Entity
@Table
public class service 
{
	@Id
	@GenericGenerator(name="service_Id_Generator",strategy="native")
	@GeneratedValue(generator="service_Id_Generator")
	private Integer service_id;
	
	//关联材料-服役-环境
	@OneToOne(targetEntity=environment.class)
	@JoinColumn(name="envir",referencedColumnName="envir_id",unique=true)
	private environment envir;

	//关联材料-服役-测试
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
	public Integer getService_id() 
	{
		return service_id;
	}
	public void setService_id(Integer service_id) 
	{
		this.service_id = service_id;
	}
	public environment getEnvir() 
	{
		return envir;
	}
	public void setEnvir(environment envir) 
	{
		this.envir = envir;
	}
	
	public service() 
	{
		super();
	}
}
