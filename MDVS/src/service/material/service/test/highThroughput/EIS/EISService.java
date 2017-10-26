package service.material.service.test.highThroughput.EIS;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import beans.material.service.test.highThroughput.EIS.EIS;
import beans.material.service.test.highThroughput.EIS.EIS_Bode_Nyquist;
import beans.material.service.test.highThroughput.EIS.EIS_OCV;
import dao.material.service.test.highThroughput.EIS.IEISDao;

@Service("EISService")
public class EISService implements IEISService 
{
	@Resource
	private IEISDao eisDao;
	
	public IEISDao getEisDao()
	{
		return eisDao;
	}
	public void setEisDao(IEISDao eisDao) 
	{
		this.eisDao = eisDao;
	}

	@Transactional
	@Override
	public void addEIS(EIS eis) 
	{
		eisDao.addEIS(eis);
	}
	@Transactional
	@Override
	public void removeEIS(EIS eis) 
	{
		eisDao.removeEIS(eis);
	}
	@Transactional
	@Override
	public void modifyEIS(EIS eis) 
	{
		eisDao.removeEIS(eis);
	}
	@Transactional(readOnly=true)
	@Override
	public Set<EIS_OCV> findEIS_OCV_Set(int id) 
	{
		return eisDao.findEIS_OCV_Set(id);
	}
	@Transactional(readOnly=true)
	@Override
	public Set<EIS_Bode_Nyquist> findEIS_Bode_Nyquist(int id) 
	{
		return eisDao.findEIS_Bode_Nyquist(id);
	}
}