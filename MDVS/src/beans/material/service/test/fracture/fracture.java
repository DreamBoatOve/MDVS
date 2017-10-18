package beans.material.service.test.fracture;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class fracture 
{
	@Id
	@GenericGenerator(name="fracture_Id_Generator",strategy="native")
	@GeneratedValue(generator="fracture_Id_Generator")
	private Integer fracture_id;

	public Integer getFracture_id() 
	{
		return fracture_id;
	}
	public void setFracture_id(Integer fracture_id)
	{
		this.fracture_id = fracture_id;
	}
	
	public fracture() 
	{
		super();
	}
}
