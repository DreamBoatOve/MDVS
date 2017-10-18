package beans.material;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import beans.material.service.service;
import beans.material.service.environment.environment;
import beans.material.service.test.test;

@Entity
@Table
public class material
{
	@Id
	@GenericGenerator(name="material_Id_Generator",strategy="native")
	@GeneratedValue(generator="material_Id_Generator")
	private Integer id;
	//材料名称
	private String materialName;
	//材料颜色 黑色/有色
	private String materialColor;
	//材料重量 轻金属/重金属
	private String materialDensity;
	//材料储量 常量金属/微量
	private String materialReserves;
	//材料实验区域大小 常规/微区
	private String materialScale; 
	
	//关联材料-服役-测试
	//定义material实体关联的test实体
/*	@OneToOne(targetEntity=test.class)
	//映射名为test_id的外键列
	//@JoinColumn(name="test_id",referencedColumnName="test_id",unique=true)
	@JoinColumn(name="test",referencedColumnName="test_id",unique=true)
	private test test;*/
	@OneToOne(targetEntity=service.class)
	@JoinColumn(name="service",referencedColumnName="service_id")
	private service service;
	
	@OneToOne(targetEntity=environment.class)
	@JoinColumn(name="envir",referencedColumnName="envir_id",unique=true)
	private environment envir;

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
	public String getMaterialColor() 
	{
		return materialColor;
	}
	public void setMaterialColor(String materialColor) 
	{
		this.materialColor = materialColor;
	}
	public String getMaterialDensity() 
	{
		return materialDensity;
	}
	public void setMaterialDensity(String materialDensity) 
	{
		this.materialDensity = materialDensity;
	}
	public String getMaterialReserves() 
	{
		return materialReserves;
	}
	public void setMaterialReserves(String materialReserves) 
	{
		this.materialReserves = materialReserves;
	}
	public String getMaterialScale() 
	{
		return materialScale;
	}
	public void setMaterialScale(String materialScale) 
	{
		this.materialScale = materialScale;
	}
	public service getService() 
	{
		return service;
	}
	public void setService(service service)
	{
		this.service = service;
	}
	public environment getEnvir() 
	{
		return envir;
	}
	public void setEnvir(environment envir) 
	{
		this.envir = envir;
	}
	
	public material() 
	{
		super();
	}
	public material(String materialName, String materialColor, String materialDensity, String materialReserves,
			String materialScale) 
	{
		super();
		this.materialName = materialName;
		this.materialColor = materialColor;
		this.materialDensity = materialDensity;
		this.materialReserves = materialReserves;
		this.materialScale = materialScale;
	}
}
