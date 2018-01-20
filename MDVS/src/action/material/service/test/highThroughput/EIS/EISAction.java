package action.material.service.test.highThroughput.EIS;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

import Utils.service.test.highThroughput.EIS.EISParser;
import beans.material.service.test.highThroughput.EIS.EIS;
import service.material.service.test.highThroughput.EIS.IEISService;

@Component("EISAction")
@Scope("prototype")
@Namespace("/EIS")
//@ParentPackage("struts-default")
@ParentPackage("json-default")
public class EISAction extends ActionSupport
{
	private File EISFile;
	/*jsonData includes all the parameters the front page need
	 * */
	private Map<String,Object> jsonData = new HashMap<String,Object>();
	
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
	public Map<String, Object> getJsonData() {
		return jsonData;
	}
	public void setJsonData(Map<String, Object> jsonData) {
		this.jsonData = jsonData;
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
	//@Action(value="addEIS",results={@Result(type="json",params={"noCache","true","contentType","text/html","excludeNullProperties","true","root","EIS_Id"})})
	@Action(value="addEIS",results={@Result(name="success",type="json",params={"root","jsonData"})})
	public String addEIS()
	{
		EISParser ep = new EISParser(EISFile);
		EIS e = new EIS(ep.getEIS_Setting(),ep.getEIS_OCVSet(),ep.getEIS_Bode_NyquistSet());
		EISService.addEIS(e);
		//Put the id of EIS into the jsonData Map
		jsonData.put("EIS_Id",e.getEIS_id());
		return SUCCESS;
	}
}