package action.material;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Utils.Json.jsonConvert;
import beans.material.material;
import service.material.IMaterialService;
import sun.text.normalizer.Trie.DataManipulate;

@Component("materialAction")
@Scope("prototype")
@Namespace("/material")
//@ParentPackage("struts-default")
@ParentPackage("json-default")
public class materialAction extends ActionSupport
{
	private String materialName;
	private String color;
	private String reserves;
	
	private String materialNames_JA_Str;
	
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
	public String getMaterialNames_JA_Str() 
	{
		return materialNames_JA_Str;
	}
	public void setMaterialNames_JA_Str(String materialNames_JA_Str) 
	{
		this.materialNames_JA_Str = materialNames_JA_Str;
	}
	@Action(value="addMaterial", results=@Result(location="/success.jsp"))
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
	//往JSP传JSON的ACTION不用配置视图资源，传参配	"root","parameter name"参数要有get和set方法
	@Action(
			value="findMaterialNames", 
			results=
		{
			@Result(type="json",params={"noCache","true","contentType","text/html","excludeNullProperties","true","root","materialNames_JA_Str"}),
		}
			)
	public String findMaterialNames()
	{
		System.out.println("Finding all the materials... ");
		List<String> materialNamesList = materialService.findMaterialNames();
		materialNames_JA_Str = jsonConvert.List_To_JSONArray(materialNamesList);
		System.out.println("materialNames_JA_Str: "+materialNames_JA_Str);
		return "success";
	}
	public String modifyMaterial()
	{
		System.out.println("Modify... ");
		System.out.println("Original Info: "+materialName+" color:"+color+" reserves:"+reserves+" density:"+density);
		
		System.out.println("Final Info: "+materialName+" color:"+color+" reserves:"+reserves+" density:"+density);
		return "success";
	}
}
