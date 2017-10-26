package service.material.service.test.highThroughput.EIS;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import beans.material.service.test.highThroughput.EIS.EIS_OCV;
import dao.material.service.test.highThroughput.EIS.IEIS_OCVDao;

@Service("EIS_OCVService")
public class EIS_OCVService implements IEIS_OCVService 
{
	@Resource
	private IEIS_OCVDao eis_OCVDao;

	public IEIS_OCVDao getEis_OCVDao() 
	{
		return eis_OCVDao;
	}
	public void setEis_OCVDao(IEIS_OCVDao eis_OCVDao) 
	{
		this.eis_OCVDao = eis_OCVDao;
	}

	@Transactional
	@Override
	public void addEIS_OCV(EIS_OCV eis_OCV) 
	{
		eis_OCVDao.addEIS_OCV(eis_OCV);
	}
	@Transactional
	@Override
	public void removeEIS_OCV(EIS_OCV eis_OCV) 
	{
		eis_OCVDao.removeEIS_OCV(eis_OCV);
	}
	@Transactional
	@Override
	public void modifyEIS_OCV(EIS_OCV eis_OCV) 
	{
		eis_OCVDao.modifyEIS_OCV(eis_OCV);
	}
}
