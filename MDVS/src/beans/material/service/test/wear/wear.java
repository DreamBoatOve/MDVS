package beans.material.service.test.wear;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class wear
{
	@Id
	@GenericGenerator(name="wear_Id_Generator",strategy="native")
	@GeneratedValue(generator="wear_Id_Generator")
	private Integer wear_id;

	public Integer getWear_id()
	{
		return wear_id;
	}
	public void setWear_id(Integer wear_id) 
	{
		this.wear_id = wear_id;
	}
	
	public wear() 
	{
		super();
	}
}
