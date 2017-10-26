package dao.material.service.test.highThroughput.EIS;

import java.util.Set;

import beans.material.service.test.highThroughput.EIS.EIS;
import beans.material.service.test.highThroughput.EIS.EIS_Bode_Nyquist;
import beans.material.service.test.highThroughput.EIS.EIS_OCV;

public interface IEISDao 
{
	void addEIS(EIS eis);
	void removeEIS(EIS eis);
	void modifyEIS(EIS eis);
	
	Set<EIS_OCV> findEIS_OCV_Set(int id);
	Set<EIS_Bode_Nyquist> findEIS_Bode_Nyquist(int id);
}
