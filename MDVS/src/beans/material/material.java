package beans.material;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import beans.material.service.test.test;

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
	
	//关联材料-服役-测试
	//定义material实体关联的test实体
	@OneToOne(targetEntity=test.class)
	//映射名为test_id的外键列
	@JoinColumn(name="test_id",referencedColumnName="test_id",unique=true)
	private test test;
	
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
	public char getCommon_Rare() 
	{
		return common_Rare;
	}
	public void setCommon_Rare(char common_Rare) 
	{
		this.common_Rare = common_Rare;
	}
	public test getTest() 
	{
		return test;
	}
	public void setTest(test test) 
	{
		this.test = test;
	}

	private material() 
	{}
	private material(String materialName, char black_Colorful, char light_Heavy, char common_Rare) 
	{
		this.materialName = materialName;
		this.black_Colorful = black_Colorful;
		this.light_Heavy = light_Heavy;
		this.common_Rare = common_Rare;
	}
	
	
}
