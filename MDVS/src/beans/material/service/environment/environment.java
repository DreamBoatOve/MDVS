package beans.material.service.environment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class environment 
{
	@Id
	@GenericGenerator(name="environment_Id_Generator",strategy="native")
	@GeneratedValue(generator="environment_Id_Generator")
	private Integer envir_id;

	public Integer getEnvir_id()
	{
		return envir_id;
	}
	public void setEnvir_id(Integer envir_id)
	{
		this.envir_id = envir_id;
	}
	
	public environment() 
	{
		super();
	}
	public environment(Integer envir_id) 
	{
		super();
		this.envir_id = envir_id;
	}
}
