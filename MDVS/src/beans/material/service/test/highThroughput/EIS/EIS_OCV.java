package beans.material.service.test.highThroughput.EIS;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class EIS_OCV 
{
	@Id
	@GenericGenerator(name="EIS_OCV_Id_Generator",strategy="native")
	@GeneratedValue(generator="EIS_OCV_Id_Generator")
	private Integer id;
	private Integer originalID;
	private double T;
	private double Vf;
	private double Vm;
	private double Ach;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOriginalID() {
		return originalID;
	}
	public void setOriginalID(Integer originalID) {
		this.originalID = originalID;
	}
	public double getT() {
		return T;
	}
	public void setT(double t) {
		T = t;
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
	
	public EIS_OCV() 
	{
		super();
	}
	@Override
	public String toString() 
	{
		return "EIS_OCV [originalID=" + originalID + ", T=" + T + ", Vf=" + Vf + ", Vm=" + Vm + ", Ach=" + Ach + "]";
	}
}
