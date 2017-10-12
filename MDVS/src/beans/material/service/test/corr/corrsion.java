package beans.material.service.test.corr;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class corrsion 
{
	@Id
	@GenericGenerator(name="corrsion_Id_Generator",strategy="native")
	@GeneratedValue(generator="corrsion_Id_Generator")
	private Integer corrsion_id;
	private Integer row;
	private Integer col;
	
	public Integer getCorrsion_id() 
	{
		return corrsion_id;
	}
	public void setCorrsion_id(Integer corrsion_id) 
	{
		this.corrsion_id = corrsion_id;
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
}