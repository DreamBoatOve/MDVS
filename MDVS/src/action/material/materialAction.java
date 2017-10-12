package action.material;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import beans.Student;

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
	
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public char getColor() {
		return color;
	}
	public void setColor(char color) {
		this.color = color;
	}
	public char getReserves() {
		return reserves;
	}
	public void setReserves(char reserves) {
		this.reserves = reserves;
	}
	public char getDensity() {
		return density;
	}
	public void setDensity(char density) {
		this.density = density;
	}
	
	@Action(value="addMaterial", results=@Result(location="/welcome.jsp"))
	public String execute()
	{
		System.out.println(materialName+" color:"+color+" reserves:"+reserves+" density:"+density);
		//Student stu = new Student(name,age);
		//service.addStudent(stu);
		return "success";
	}

}
