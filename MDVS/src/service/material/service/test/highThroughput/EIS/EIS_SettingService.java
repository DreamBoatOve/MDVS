package service.material.service.test.highThroughput.EIS;

import beans.material.service.test.highThroughput.EIS.EIS_Setting;
import dao.material.service.test.highThroughput.EIS.IEIS_SettingDao;

public class EIS_SettingService implements IEIS_SettingService 
{
	private IEIS_SettingDao eis_SettingDao;
	
	public IEIS_SettingDao getEis_SettingDao() 
	{
		return eis_SettingDao;
	}
	public void setEis_SettingDao(IEIS_SettingDao eis_SettingDao) 
	{
		this.eis_SettingDao = eis_SettingDao;
	}
	
	@Override
	public void addEIS_Setting(EIS_Setting eis_Setting) 
	{
		eis_SettingDao.addEIS_Setting(eis_Setting);
	}
	@Override
	public void removeEIS_Setting(EIS_Setting eis_Setting) 
	{
		eis_SettingDao.removeEIS_Setting(eis_Setting);
	}
	@Override
	public void modifyEIS_Setting(EIS_Setting eis_Setting) 
	{
		eis_SettingDao.modifyEIS_Setting(eis_Setting);
	}
}
