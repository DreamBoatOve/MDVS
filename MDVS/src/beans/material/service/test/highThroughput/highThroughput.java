package beans.material.service.test.highThroughput;

import java.util.Date;
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

import beans.material.service.test.highThroughput.EIS.EIS;
import beans.material.service.test.highThroughput.PD.PD;

@Entity
@Table
public class highThroughput 
{
	@Id
	@GenericGenerator(name="highThoughput_Id_Generator",strategy="native")
	@GeneratedValue(generator="highThoughput_Id_Generator")
	private Integer high_id;
	
	private Integer row;
	private Integer col;
	/*EIS已经提前入库，再此处，便不进行级联操作(cascade=CascadeType.ALL)*/
	@OneToOne(targetEntity = EIS.class)
	@JoinColumn(name="EIS_Id",referencedColumnName="EIS_id",unique=true)
	private EIS eis;
	/*PD已经提前入库，再此处，便不进行级联操作(cascade=CascadeType.ALL)*/
	@OneToOne(targetEntity = PD.class)
	@JoinColumn(name="PD_id",referencedColumnName="PD_id",unique=true)
	private PD pd;
	
	private Date experimentTime;
	private String operatorName;
	
	
	public Integer getHigh_id() 
	{
		return high_id;
	}
	public void setHigh_id(Integer high_id) 
	{
		this.high_id = high_id;
	}
	public Integer getRow() 
	{
		return row;
	}
	public void setRow(Integer row) 
	{
		this.row = row;
	}
	public Integer getCol() 
	{
		return col;
	}
	public void setCol(Integer col) 
	{
		this.col = col;
	}
	public EIS getEis() 
	{
		return eis;
	}
	public void setEis(EIS eis) 
	{
		this.eis = eis;
	}
	public PD getPd() 
	{
		return pd;
	}
	public void setPd(PD pd) 
	{
		this.pd = pd;
	}
	public Date getExperimentTime() 
	{
		return experimentTime;
	}
	public void setExperimentTime(Date experimentTime) 
	{
		this.experimentTime = experimentTime;
	}
	public String getOperatorName() 
	{
		return operatorName;
	}
	public void setOperatorName(String operatorName) 
	{
		this.operatorName = operatorName;
	}
	
	
	public highThroughput() 
	{
		super();
	}
}
