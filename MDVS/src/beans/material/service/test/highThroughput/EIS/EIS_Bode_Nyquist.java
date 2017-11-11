package beans.material.service.test.highThroughput.EIS;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class EIS_Bode_Nyquist 
{
	@Id
	@GenericGenerator(name="EIS_Bode_Nyquist_Id_Generator",strategy="native")
	@GeneratedValue(generator="EIS_Bode_Nyquist_Id_Generator")
	private Integer id;
	private Integer original_ID;
	private double T;
	private double Freq;
	private double Zreal;
	private double Zimg;
	private double Zsig;
	private double Zmod;
	private double Zphz;
	private double Idc;
	private double Vdc;
	private double IErange;
	
	public Integer getId() {
		return id;
	}
	public Integer getOriginal_ID() {
		return original_ID;
	}
	public void setOriginal_ID(Integer original_ID) {
		this.original_ID = original_ID;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getT() {
		return T;
	}
	public void setT(double t) {
		T = t;
	}
	public double getFreq() {
		return Freq;
	}
	public void setFreq(double freq) {
		Freq = freq;
	}
	public double getZreal() {
		return Zreal;
	}
	public void setZreal(double zreal) {
		Zreal = zreal;
	}
	public double getZimg() {
		return Zimg;
	}
	public void setZimg(double zimg) {
		Zimg = zimg;
	}
	public double getZsig() {
		return Zsig;
	}
	public void setZsig(double zsig) {
		Zsig = zsig;
	}
	public double getZmod() {
		return Zmod;
	}
	public void setZmod(double zmod) {
		Zmod = zmod;
	}
	public double getZphz() {
		return Zphz;
	}
	public void setZphz(double zphz) {
		Zphz = zphz;
	}
	public double getIdc() {
		return Idc;
	}
	public void setIdc(double idc) {
		Idc = idc;
	}
	public double getVdc() {
		return Vdc;
	}
	public void setVdc(double vdc) {
		Vdc = vdc;
	}
	public double getIErange() {
		return IErange;
	}
	public void setIErange(double iErange) {
		IErange = iErange;
	}
	
	public EIS_Bode_Nyquist() 
	{
		super();
	}
}
