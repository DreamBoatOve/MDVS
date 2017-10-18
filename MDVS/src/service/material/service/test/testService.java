package service.material.service.test;

import java.util.List;

import beans.material.service.test.test;
import dao.material.service.test.ITestDao;

public class testService implements ITestService 
{
	private ITestDao testDao;
	
	public ITestDao getTestDao() 
	{
		return testDao;
	}
	public void setTestDao(ITestDao testDao) 
	{
		this.testDao = testDao;
	}
	
	@Override
	public void addTest(test test) 
	{
		testDao.addTest(test);
	}
	@Override
	public void modifyTest(test test) 
	{
		testDao.modifyTest(test);
	}
	@Override
	public List<Integer> findTestSequences() 
	{
		testDao.findTestSequences();
		return null;
	}
	@Override
	public List<Integer> findTestByRow(int row) 
	{
		testDao.findTestByRow(row);
		return null;
	}
	@Override
	public List<Integer> findTestByCol(int col) 
	{
		testDao.findTestByRow(col);
		return null;
	}
	@Override
	public List<Integer> findTestByRowAndCol(int row, int col) 
	{
		testDao.findTestByRowAndCol(row,col);
		return null;
	}
	@Override
	public void removeTestByRow(test test) {
		// TODO Auto-generated method stub
		
	}
}
