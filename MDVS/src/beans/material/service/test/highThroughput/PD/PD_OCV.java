package beans.material.service.test.highThroughput.PD;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class PD_OCV 
{
	@Id
	@GenericGenerator(name="PD_OCV_Id_Generator",strategy="native")
	@GeneratedValue(generator="PD_OCV_Id_Generator")
	private Integer id;
	private double Time;
	private double Vf;
	private double Vm;
	private double Ach;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getTime() {
		return Time;
	}
	public void setTime(double time) {
		Time = time;
	}
	public double getVf() {
		return Vf;
	}
	public void setVf(double vf) {
		Vf = vf;
	}
	public double getVm() {
		return Vm;
	}
	public void setVm(double vm) {
		Vm = vm;
	}
	public double getAch() {
		return Ach;
	}
	public void setAch(double ach) {
		Ach = ach;
	}
	
	public PD_OCV() 
	{
		super();
	}
}
