package service.material.service.test.highThroughput;

import java.util.Set;

import beans.material.service.test.highThroughput.highThroughput;
import beans.material.service.test.highThroughput.EIS.EIS;
import beans.material.service.test.highThroughput.PD.PD;

public interface IHighThroughputService 
{
	void addHighThroughput(highThroughput h);
	void removeHighThroughput(highThroughput h);
	void modifyHighThroughput(highThroughput h);
	
	EIS findEISSet(int id);
	PD findPDSet(int id);
}
