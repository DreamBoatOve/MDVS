package action.material;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import beans.Student;
import beans.material.material;
import service.material.IMaterialService;

@Component("materialAction")
@Scope("prototype")
@Namespace("/material")
@ParentPackage("struts-default")
public class materialAction 
{
	private String materialName;
	private String color;
	private String reserves;
	private String density;
	private String scale;
	
	@Autowired
	@Qualifier("materialService")
	private IMaterialService materialService;
	
	public String getMaterialName() 
	{
		return materialName;
	}
	public void setMaterialName(String materialName) 
	{
		this.materialName = materialName;
	}
	public String getColor() 
	{
		return color;
	}
	public void setColor(String color) 
	{
		this.color = color;
	}
	public String getReserves() 
	{
		return reserves;
	}
	public void setReserves(String reserves) 
	{
		this.reserves = reserves;
	}
	public String getDensity() 
	{
		return density;
	}
	public void setDensity(String density) 
	{
		this.density = density;
	}
	public IMaterialService getMaterialService() 
	{
		return materialService;
	}
	public String getScale() 
	{
		return scale;
	}
	public void setScale(String scale)
	{
		this.scale = scale;
	}
	public void setMaterialService(IMaterialService materialService) 
	{
		this.materialService = materialService;
	}
	@Action(value="addMaterial", results=@Result(location="/welcome.jsp"))
	public String addMaterial()
	{
		System.out.println("Adding... "+materialName+" color:"+color+" reserves:"+reserves+" density:"+density);
		material m = new material();
		m.setMaterialName(materialName);
		m.setMaterialColor(color);
		m.setMaterialReserves(reserves);
		m.setMaterialDensity(density);
		m.setMaterialScale(scale);
		materialService.addMaterial(m);
		return "success";
	}
	public 
}
