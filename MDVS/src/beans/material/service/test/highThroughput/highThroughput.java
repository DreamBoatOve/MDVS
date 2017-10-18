package beans.material.service.test.highThroughput;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	
	private EIS eis;
	private PD pd;
	
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
	
	public highThroughput() 
	{
		super();
	}
	public highThroughput(Integer row, Integer col) 
	{
		super();
		this.row = row;
		this.col = col;
	}
}
