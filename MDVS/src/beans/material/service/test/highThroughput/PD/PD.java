package beans.material.service.test.highThroughput.PD;

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
public class PD 
{
	@Id
	@GenericGenerator(name="PD_Id_Generator",strategy="native")
	@GeneratedValue(generator="PD_Id_Generator")
	private Integer PD_id;
	
	@OneToOne(targetEntity=PD_Setting.class)
	@JoinColumn(name="PD_id",referencedColumnName="PD_id")
	private PD_Setting PD_Setting;
	
	@OneToMany(targetEntity=PD_OCV.class)
	@JoinColumn(name="PD_id")
	private Set<PD_OCV> PD_OCV_Set = new HashSet<PD_OCV>();
	
	@OneToMany(targetEntity=PD_Chart.class)
	@JoinColumn(name="PD_id")
	private Set<PD_Chart> PD_Chart_Set = new HashSet<PD_Chart>();

	public Integer getPD_id() 
	{
		return PD_id;
	}
	public void setPD_id(Integer pD_id) 
	{
		PD_id = pD_id;
	}
	public PD_Setting getPD_Setting() {
		return PD_Setting;
	}
	public void setPD_Setting(PD_Setting pD_Setting) {
		PD_Setting = pD_Setting;
	}
	public Set<PD_OCV> getPD_OCV_Set() {
		return PD_OCV_Set;
	}
	public void setPD_OCV_Set(Set<PD_OCV> pD_OCV_Set) {
		PD_OCV_Set = pD_OCV_Set;
	}
	public Set<PD_Chart> getPD_Chart_Set() {
		return PD_Chart_Set;
	}
	public void setPD_Chart_Set(Set<PD_Chart> pD_Chart_Set) {
		PD_Chart_Set = pD_Chart_Set;
	}
	
	public PD() 
	{
		super();
	}
}
