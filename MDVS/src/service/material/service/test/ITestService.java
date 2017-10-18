package service.material.service.test;

import java.util.List;

import beans.material.service.test.test;

public interface ITestService 
{
	void addTest(test test);
	void removeTestByRow(test test);
	void modifyTest(test test);
	
	List<Integer> findTestSequences();
	List<Integer> findTestByRow(int row);
	List<Integer> findTestByCol(int col);
	List<Integer> findTestByRowAndCol(int row, int col);
}
