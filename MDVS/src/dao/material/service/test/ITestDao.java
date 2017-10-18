package dao.material.service.test;

import beans.material.service.test.test;

public interface ITestDao 
{
	void addTest(test test);
	void remove(test test);
	void modifyTest(test test);
	
	void findTestSequences();
	void findTestByRow(int row);
	void findTestByRowAndCol(int row, int col);
}
