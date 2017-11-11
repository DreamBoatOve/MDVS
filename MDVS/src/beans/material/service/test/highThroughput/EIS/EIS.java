package beans.material.service.test.highThroughput.EIS;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class EIS 
{
	@Id
	@GenericGenerator(name="EIS_Id_Generator",strategy="native")
	@GeneratedValue(generator="EIS_Id_Generator")
	private Integer EIS_id;
	
	@OneToOne(targetEntity=EIS_Setting.class)
	@JoinColumn(name="EIS_id")
	//@JoinColumn(name="EIS_Setting",referencedColumnName="id")
	private EIS_Setting EIS_Setting;
	
	@OneToMany(targetEntity=EIS_OCV.class)
	@JoinColumn(name="EIS_id")
	private Set<EIS_OCV> EIS_OCV_Set = new HashSet<EIS_OCV>();
	
	@OneToMany(targetEntity=EIS_Bode_Nyquist.class)
	@JoinColumn(name="EIS_id")
	private Set<EIS_Bode_Nyquist> EIS_Bode_Nyquist_Set = new HashSet<EIS_Bode_Nyquist>();
	
	public Integer getEIS_id() {
		return EIS_id;
	}
	public void setEIS_id(Integer eIS_id) {
		EIS_id = eIS_id;
	}
	public EIS_Setting getEIS_Setting() {
		return EIS_Setting;
	}
	public void setEIS_Setting(EIS_Setting eIS_Setting) {
		EIS_Setting = eIS_Setting;
	}
	public Set<EIS_OCV> getEIS_OCV_Set() {
		return EIS_OCV_Set;
	}
	public void setEIS_OCV_Set(Set<EIS_OCV> eIS_OCV_Set) {
		EIS_OCV_Set = eIS_OCV_Set;
	}
	public Set<EIS_Bode_Nyquist> getEIS_Bode_Nyquist_Set() {
		return EIS_Bode_Nyquist_Set;
	}
	public void setEIS_Bode_Nyquist_Set(Set<EIS_Bode_Nyquist> eIS_Bode_Nyquist_Set) {
		EIS_Bode_Nyquist_Set = eIS_Bode_Nyquist_Set;
	}
	
	public EIS()
	{
		super();
	}
}
