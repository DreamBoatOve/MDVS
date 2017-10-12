package action.material;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import beans.Student;
import service.material.IMaterialService;

@Component("materialAction")
@Scope("prototype")
@Namespace("/material")
@ParentPackage("struts-default")
public class materialAction 
{
	private String materialName;
	private char color;
	private char reserves;
	private char density;
	private char convention_microScale;
	
	private IMaterialService materialService;
	
	public String getMaterialName() 
	{
		return materialName;
	}
	public void setMaterialName(String materialName) 
	{
		this.materialName = materialName;
	}
	public char getColor() 
	{
		return color;
	}
	public void setColor(char color) 
	{
		this.color = color;
	}
	public char getReserves() 
	{
		return reserves;
	}
	public void setReserves(char reserves) 
	{
		this.reserves = reserves;
	}
	public char getDensity() 
	{
		return density;
	}
	public void setDensity(char density)
	{
		this.density = density;
	}
	public char getConvention_microScale() 
	{
		return convention_microScale;
	}
	public void setConvention_microScale(char convention_microScale) 
	{
		this.convention_microScale = convention_microScale;
	}
	public IMaterialService getMaterialService() 
	{
		return materialService;
	}
	public void setMaterialService(IMaterialService materialService) 
	{
		this.materialService = materialService;
	}
	@Action(value="addMaterial", results=@Result(location="/welcome.jsp"))
	public String execute()
	{
		System.out.println("Adding... "+materialName+" color:"+color+" reserves:"+reserves+" density:"+density);
		
		return "success";
	}
}
