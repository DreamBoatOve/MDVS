package beans.material.service.test.highThroughput.PD;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class PD_Chart 
{
	@Id
	@GenericGenerator(name="PD_Chart_Id_Generator",strategy="native")
	@GeneratedValue(generator="PD_Chart_Id_Generator")
	private Integer id;
	
	private Integer originalID;
	private double Time;
	private double Vf;
	private double Im;
	private double Vu;
	private double Sig;
	private double Ach;
	private double IERange;
	
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
	public double getIm() {
		return Im;
	}
	public void setIm(double im) {
		Im = im;
	}
	public double getVu() {
		return Vu;
	}
	public void setVu(double vu) {
		Vu = vu;
	}
	public double getSig() {
		return Sig;
	}
	public void setSig(double sig) {
		Sig = sig;
	}
	public double getAch() {
		return Ach;
	}
	public void setAch(double ach) {
		Ach = ach;
	}
	public double getIERange() {
		return IERange;
	}
	public void setIERange(double iERange) {
		IERange = iERange;
	}
	
	public PD_Chart() 
	{
		super();
	}
}
