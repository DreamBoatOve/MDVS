package beans.material;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class material 
{
	@Id
	@GenericGenerator(name="material_Id_Generator",strategy="native")
	@GeneratedValue(generator="material_Id_Generator")
	private Integer id;
	private String materialName;
	private char black_Colorful;
	private char light_Heavy;
	private char common_Rare;
	
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getMaterialName() 
	{
		return materialName;
	}
	public void setMaterialName(String materialName) 
	{
		this.materialName = materialName;
	}
	public char getBlack_Colorful() 
	{
		return black_Colorful;
	}
	public void setBlack_Colorful(char black_Colorful) 
	{
		this.black_Colorful = black_Colorful;
	}
	public char getLight_Heavy() 
	{
		return light_Heavy;
	}
	public void setLight_Heavy(char light_Heavy) 
	{
		this.light_Heavy = light_Heavy;
	}
	public char getCommon_rare() 
	{
		return common_Rare;
	}
	public void setCommon_rare(char common_Rare) 
	{
		this.common_Rare = common_Rare;
	}
}
