package action.material.service.test.highThroughput.EIS;

import java.io.File;

import service.material.service.test.highThroughput.EIS.IEISService;

public class EISAction 
{
	private File EISFile;
	
	private IEISService EISService;

	public File getEISFile() {
		return EISFile;
	}
	public void setEISFile(File eISFile) {
		EISFile = eISFile;
	}
	public IEISService getEISService() {
		return EISService;
	}
	public void setEISService(IEISService eISService) {
		EISService = eISService;
	}
	

}
