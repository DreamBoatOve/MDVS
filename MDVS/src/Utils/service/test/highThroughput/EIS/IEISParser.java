package Utils.service.test.highThroughput.EIS;

import java.io.File;
import java.util.Set;

import beans.material.service.test.highThroughput.EIS.EIS_Bode_Nyquist;
import beans.material.service.test.highThroughput.EIS.EIS_OCV;
import beans.material.service.test.highThroughput.EIS.EIS_Setting;

public interface IEISParser 
{
	public EIS_Setting getEIS_Setting(File EISFile);
	public Set<EIS_OCV> getEIS_OCVSet(File EISFile);
	public Set<EIS_Bode_Nyquist> getEIS_Bode_NyquistSet(File EISFile);
}
