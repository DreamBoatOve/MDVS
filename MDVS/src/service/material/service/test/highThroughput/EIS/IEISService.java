package service.material.service.test.highThroughput.EIS;

import java.util.Set;

import beans.material.service.test.highThroughput.EIS.EIS;
import beans.material.service.test.highThroughput.EIS.EIS_Bode_Nyquist;
import beans.material.service.test.highThroughput.EIS.EIS_OCV;

public interface IEISService 
{
	void addEIS(EIS eis);
	void removeEIS(EIS eis);
	void modifyEIS(EIS eis);
	
	//EIS getEISById(int EIS_ID);
	
	Set<EIS_OCV> findEIS_OCV_Set(int id);
	Set<EIS_Bode_Nyquist> findEIS_Bode_Nyquist(int id);
}