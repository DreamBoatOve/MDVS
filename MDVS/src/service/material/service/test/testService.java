package service.material.service.test;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import beans.material.service.test.test;
import beans.material.service.test.fatigue.fatigue;
import beans.material.service.test.fracture.fracture;
import beans.material.service.test.highThroughput.highThroughput;
import beans.material.service.test.wear.wear;
import dao.material.service.test.ITestDao;

@Service("testService")
public class testService implements ITestService 
{
	@Resource
	private ITestDao testDao; 
	
	public ITestDao getTestDao() 
	{
		return testDao;
	}
	public void setTestDao(ITestDao testDao) 
	{
		this.testDao = testDao;
	}
	@Transactional
	@Override
	public void addTest(test test) 
	{
		testDao.addTest(test);
	}
	@Transactional
	@Override
	public void removeTest(test test) 
	{
		testDao.removeTest(test);
	}
	@Transactional
	@Override
	public void modifyTest(test test) 
	{
		testDao.modifyTest(test);
	}
	@Transactional(readOnly=true)
	@Override
	public fatigue findTestFatigue(int id)
	{
		return testDao.findTestFatigue(id);
	}
	@Transactional(readOnly=true)
	@Override
	public fracture findTestFracture(int id) 
	{
		return testDao.findTestFracture(id);
	}
	@Transactional(readOnly=true)
	@Override
	public wear findTestWear(int id) 
	{
		return testDao.findTestWear(id);
	}
	@Transactional(readOnly=true)
	@Override
	public Set<highThroughput> findTesthighThroughputs(int id) 
	{
		return testDao.findTesthighThroughputs(id);
	}
}
