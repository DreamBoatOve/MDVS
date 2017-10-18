package beans.material.service.test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import beans.material.service.test.fatigue.fatigue;
import beans.material.service.test.fracture.fracture;
import beans.material.service.test.highThroughput.highThroughput;
import beans.material.service.test.wear.wear;

@Entity
@Table
public class test 
{
	@Id
	@GenericGenerator(name="test_Id_Generator",strategy="native")
	@GeneratedValue(generator="test_Id_Generator")
	private Integer test_id;
	
	//fatigue
	@OneToOne(targetEntity=fatigue.class)
	@JoinColumn(name="fatigue",referencedColumnName="fatigue_id",unique=true)
	private fatigue fatigue;
	
	//fracture
	@OneToOne(targetEntity=fracture.class)
	@JoinColumn(name="fracture",referencedColumnName="fracture_id",unique=true)
	private fracture fracture;
	
	//wear
	@OneToOne(targetEntity=wear.class)
	@JoinColumn(name="wear",referencedColumnName="wear_id",unique=true)
	private Integer wear;
	
	//high-thoughput
	@OneToOne(targetEntity=highThroughput.class)
	@JoinColumn(name="hiighThroughput",referencedColumnName="high_id",unique=true)
	private highThroughput highThroughput;

	public Integer getTest_id() 
	{
		return test_id;
	}

	public void setTest_id(Integer test_id) 
	{
		this.test_id = test_id;
	}

	public fatigue getFatigue() 
	{
		return fatigue;
	}

	public void setFatigue(fatigue fatigue) 
	{
		this.fatigue = fatigue;
	}

	public fracture getFracture() {
		return fracture;
	}

	public void setFracture(fracture fracture) {
		this.fracture = fracture;
	}

	public Integer getWear() {
		return wear;
	}

	public void setWear(Integer wear) {
		this.wear = wear;
	}

	public highThroughput getHighThroughput() {
		return highThroughput;
	}

	public void setHighThroughput(highThroughput highThroughput) 
	{
		this.highThroughput = highThroughput;
	}

	public test() 
	{
		super();
	}
}