package service.material.service.test;

import java.util.Set;

import beans.material.service.test.test;
import beans.material.service.test.fatigue.fatigue;
import beans.material.service.test.fracture.fracture;
import beans.material.service.test.highThroughput.highThroughput;
import beans.material.service.test.wear.wear;

public interface ITestService 
{
	void addTest(test test);
	void removeTest(test test);
	void modifyTest(test test);
	
	fatigue findTestFatigue(int id);
	fracture findTestFracture(int id);
	wear findTestWear(int id);
	Set<highThroughput> findTesthighThroughputs(int id);
}
