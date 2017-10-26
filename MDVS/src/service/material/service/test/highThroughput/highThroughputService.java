package service.material.service.test.highThroughput;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import beans.material.service.test.highThroughput.highThroughput;
import beans.material.service.test.highThroughput.EIS.EIS;
import beans.material.service.test.highThroughput.PD.PD;
import dao.material.service.test.highThroughput.IHighThroughputDao;

@Service("highThroughputService")
public class highThroughputService implements IHighThroughputService 
{
	@Resource
	private IHighThroughputDao highThroughputDao;
	
	public void setHighThroughputDao(IHighThroughputDao highThroughputDao) 
	{
		this.highThroughputDao = highThroughputDao;
	}
	public IHighThroughputDao getHighThroughputDao() 
	{
		return highThroughputDao;
	}
	
	@Transactional
	@Override
	public void addHighThroughput(highThroughput h) 
	{
		highThroughputDao.addHighThroughput(h);
	}
	@Transactional
	@Override
	public void removeHighThroughput(highThroughput h) 
	{
		highThroughputDao.removeHighThroughput(h);
	}
	@Transactional
	@Override
	public void modifyHighThroughput(highThroughput h) 
	{
		highThroughputDao.modifyHighThroughput(h);
	}
	@Transactional(readOnly=true)
	@Override
	public EIS findEISSet(int id) 
	{
		return highThroughputDao.findEISSet(id);
	}
	@Transactional(readOnly=true)
	@Override
	public PD findPDSet(int id) 
	{
		return highThroughputDao.findPDSet(id);
	}
}
