package action.material.service.test.highThroughput.EIS;

import java.io.File;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import Utils.service.test.highThroughput.EIS.EISParser;
import beans.material.service.test.highThroughput.EIS.EIS;
import service.material.service.test.highThroughput.EIS.IEISService;

@Component("EISAction")
@Scope("prototype")
@Namespace("/EIS")
//@ParentPackage("struts-default")
@ParentPackage("json-default")
public class EISAction 
{
	private File EISFile;
	private Integer EIS_Id;
	
	@Autowired
	@Qualifier("EISService")
	private IEISService EISService;

	public File getEISFile() 
	{
		return EISFile;
	}
	public void setEISFile(File eISFile) 
	{
		EISFile = eISFile;
	}
	public Integer getEIS_Id() {
		return EIS_Id;
	}
	public void setEIS_Id(Integer eIS_Id) {
		EIS_Id = eIS_Id;
	}
	public IEISService getEISService() 
	{
		return EISService;
	}
	public void setEISService(IEISService eISService) 
	{
		EISService = eISService;
	}
	
	/*解析EIS.DTA文件并将对应数据放入数据库
	 * */
	@Action(value="addEIS",results={@Result(type="json",params={"noCache","true","contentType","text/html","excludeNullProperties","true","root",""})})
	public void addEIS()
	{
		EISParser ep = new EISParser(EISFile);
		EIS e = new EIS(ep.getEIS_Setting(),ep.getEIS_OCVSet(),ep.getEIS_Bode_NyquistSet());
		EISService.addEIS(e);
		EIS_Id = e.getEIS_id();
		System.out.println(EIS_Id);
	}
}