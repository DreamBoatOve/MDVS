package beans.material.service.test.highThroughput.EIS;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class EIS_Setting 
{
	@Id
	@GenericGenerator(name="EIS_Setting_Id_Generator",strategy="native")
	@GeneratedValue(generator="EIS_Setting_Id_Generator")
	private Integer id;
	private String Test_Identifier;
	private Date experimentTime;
	private double DC;
	private double AC;
	private double Initial_Freq;
	private double Final_Freq;
	private double Point_Decade;
	private double Area;
	private char ConditioningStatus;
	private double Conditioning;
	private char Init_DelayStatus;
	private double Init_Delay;
	
	public String getTest_Identifier() {
		return Test_Identifier;
	}
	public void setTest_Identifier(String test_Identifier) {
		Test_Identifier = test_Identifier;
	}
	public Date getExperimentTime() {
		return experimentTime;
	}
	public void setExperimentTime(Date experimentTime) {
		this.experimentTime = experimentTime;
	}
	public char getConditioningStatus() {
		return ConditioningStatus;
	}
	public void setConditioningStatus(char conditioningStatus) {
		ConditioningStatus = conditioningStatus;
	}
	public char getInit_DelayStatus() {
		return Init_DelayStatus;
	}
	public void setInit_DelayStatus(char init_DelayStatus) {
		Init_DelayStatus = init_DelayStatus;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getDC() {
		return DC;
	}
	public void setDC(double dC) {
		DC = dC;
	}
	public double getAC() {
		return AC;
	}
	public void setAC(double aC) {
		AC = aC;
	}
	public double getInitial_Freq() {
		return Initial_Freq;
	}
	public void setInitial_Freq(double initial_Freq) {
		Initial_Freq = initial_Freq;
	}
	public double getFinal_Freq() {
		return Final_Freq;
	}
	public void setFinal_Freq(double final_Freq) {
		Final_Freq = final_Freq;
	}
	public double getPoint_Decade() {
		return Point_Decade;
	}
	public void setPoint_Decade(double point_Decade) {
		Point_Decade = point_Decade;
	}
	public double getArea() {
		return Area;
	}
	public void setArea(double area) {
		Area = area;
	}
	public double getConditioning() {
		return Conditioning;
	}
	public void setConditioning(double conditioning) {
		Conditioning = conditioning;
	}
	public double getInit_Delay() {
		return Init_Delay;
	}
	public void setInit_Delay(double init_Delay) {
		Init_Delay = init_Delay;
	}
	
	public EIS_Setting()
	{
		super();
	}
}
