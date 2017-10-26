package service.material.service.test.highThroughput.EIS;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import beans.material.service.test.highThroughput.EIS.EIS_Setting;
import dao.material.service.test.highThroughput.EIS.IEIS_SettingDao;

@Service("EIS_SettingService")
public class EIS_SettingService implements IEIS_SettingService 
{
	@Resource
	private IEIS_SettingDao eis_SettingDao;
	
	public IEIS_SettingDao getEis_SettingDao() 
	{
		return eis_SettingDao;
	}
	public void setEis_SettingDao(IEIS_SettingDao eis_SettingDao) 
	{
		this.eis_SettingDao = eis_SettingDao;
	}
	
	@Transactional
	@Override
	public void addEIS_Setting(EIS_Setting eis_Setting) 
	{
		eis_SettingDao.addEIS_Setting(eis_Setting);
	}
	@Transactional
	@Override
	public void removeEIS_Setting(EIS_Setting eis_Setting) 
	{
		eis_SettingDao.removeEIS_Setting(eis_Setting);
	}
	@Transactional
	@Override
	public void modifyEIS_Setting(EIS_Setting eis_Setting) 
	{
		eis_SettingDao.modifyEIS_Setting(eis_Setting);
	}
}
