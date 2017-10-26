package dao.material.service.test.highThroughput;

import java.util.Set;

import beans.material.service.test.highThroughput.highThroughput;
import beans.material.service.test.highThroughput.EIS.EIS;
import beans.material.service.test.highThroughput.PD.PD;

public interface IHighThroughputDao 
{
	void addHighThroughput(highThroughput h);
	void removeHighThroughput(highThroughput h);
	void modifyHighThroughput(highThroughput h);
	
	Set<EIS> findEISSet(int id);
	Set<PD> findPDSet(int id);
}
