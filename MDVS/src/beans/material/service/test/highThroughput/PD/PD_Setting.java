package beans.material.service.test.highThroughput.PD;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class PD_Setting 
{
	@Id
	@GenericGenerator(name="PD_Setting_Id_Generator",strategy="native")
	@GeneratedValue(generator="PD_Setting_Id_Generator")
	private Integer id;
	
	private String PD_fileName;
	private double InitialE;
	private double FinalE;
	private double ScanRate;
	private double SamplePeriod;
	private double SampleArea;
	private double Density;
	private double Equiv;
	private double Conditioning;
	private double InitDelay;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPD_fileName() {
		return PD_fileName;
	}
	public void setPD_fileName(String pD_fileName) {
		PD_fileName = pD_fileName;
	}
	public double getInitialE() {
		return InitialE;
	}
	public void setInitialE(double initialE) {
		InitialE = initialE;
	}
	public double getFinalE() {
		return FinalE;
	}
	public void setFinalE(double finalE) {
		FinalE = finalE;
	}
	public double getScanRate() {
		return ScanRate;
	}
	public void setScanRate(double scanRate) {
		ScanRate = scanRate;
	}
	public double getSamplePeriod() {
		return SamplePeriod;
	}
	public void setSamplePeriod(double samplePeriod) {
		SamplePeriod = samplePeriod;
	}
	public double getSampleArea() {
		return SampleArea;
	}
	public void setSampleArea(double sampleArea) {
		SampleArea = sampleArea;
	}
	public double getDensity() {
		return Density;
	}
	public void setDensity(double density) {
		Density = density;
	}
	public double getEquiv() {
		return Equiv;
	}
	public void setEquiv(double equiv) {
		Equiv = equiv;
	}
	public double getConditioning() {
		return Conditioning;
	}
	public void setConditioning(double conditioning) {
		Conditioning = conditioning;
	}
	public double getInitDelay() {
		return InitDelay;
	}
	public void setInitDelay(double initDelay) {
		InitDelay = initDelay;
	}
	
	public PD_Setting() 
	{
		super();
	}
}
