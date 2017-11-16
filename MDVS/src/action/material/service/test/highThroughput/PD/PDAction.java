package action.material.service.test.highThroughput.PD;

import java.io.File;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import Utils.service.test.highThroughput.PD.PDParser;
import beans.material.service.test.highThroughput.PD.PD;
import service.material.service.test.highThroughput.PD.IPDService;

@Component("PDAction")
@Scope("prototype")
@Namespace("/PD")
@ParentPackage("json-default")
public class PDAction 
{
	private File PDFile;
	private Integer pdID;
	@Autowired
	@Qualifier("PDService")
	private IPDService PDService;

	public File getPDFile() {
		return PDFile;
	}
	public void setPDFile(File pDFile) {
		PDFile = pDFile;
	}
	public Integer getPdID() {
		return pdID;
	}
	public void setPdID(Integer pdID) {
		this.pdID = pdID;
	}
	public IPDService getPDService() {
		return PDService;
	}
	public void setPDService(IPDService pDService) {
		PDService = pDService;
	}
	/*解析PD.DTA文件并将对应数据放入数据库
	 * */
	@Action(value="addPD",results={@Result(type="json",params={"noCache","true","contentType","text/html","excludeNullProperties","true","root",""})})
	public void addPD()
	{
		PDParser pp = new PDParser(PDFile);
		/*PD pd = new PD();
		pd.setPD_Setting(pp.getPD_Setting());
		pd.setPD_OCV_Set(pp.getPD_OcvSet());
		pd.setPD_Chart_Set(pp.getPD_ChartSet());*/
		PD pd = new PD(pp.getPD_Setting(), pp.getPD_OcvSet(), pp.getPD_ChartSet());
		PDService.addPD(pd);
		System.out.println(pd.getPD_id());
	}
}
