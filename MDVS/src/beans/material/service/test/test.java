package beans.material.service.test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import beans.material.service.test.corr.corrsion;

@Entity
@Table
public class test 
{
	@Id
	@GenericGenerator(name="test_Id_Generator",strategy="native")
	@GeneratedValue(generator="test_Id_Generator")
	private Integer test_id;
	private Integer fatigue;
	private Integer corrsion;
	private Integer fracture;
	private Integer wear;
	//测试的腐蚀模块对应的是高通量组合样品的测试
	@OneToOne(targetEntity=corrsion.class)
	@JoinColumn(name="corrsion_id",referencedColumnName="corrsion_id",unique=true)
	private Integer corrsion_id;
	
	public Integer getTest_id() 
	{
		return test_id;
	}
	public void setTest_id(Integer test_id) 
	{
		this.test_id = test_id;
	}
	public Integer getFatigue() {
		return fatigue;
	}
	public void setFatigue(Integer fatigue) {
		this.fatigue = fatigue;
	}
	public Integer getCorrsion() {
		return corrsion;
	}
	public void setCorrsion(Integer corrsion) {
		this.corrsion = corrsion;
	}
	public Integer getFracture() {
		return fracture;
	}
	public void setFracture(Integer fracture) {
		this.fracture = fracture;
	}
	public Integer getWear() {
		return wear;
	}
	public void setWear(Integer wear) {
		this.wear = wear;
	}
	
	private test() 
	{
		super();
	}
}