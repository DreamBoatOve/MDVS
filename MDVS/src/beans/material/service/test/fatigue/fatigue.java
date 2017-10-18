package beans.material.service.test.fatigue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class fatigue 
{
	@Id
	@GenericGenerator(name="fatigue_Id_Generator",strategy="native")
	@GeneratedValue(generator="fatigue_Id_Generator")
	private Integer fatigue_id;

	public Integer getFatigue_id() 
	{
		return fatigue_id;
	}
	public void setFatigue_id(Integer fatigue_id) 
	{
		this.fatigue_id = fatigue_id;
	}
	
	public fatigue() 
	{
		super();
	}
}
