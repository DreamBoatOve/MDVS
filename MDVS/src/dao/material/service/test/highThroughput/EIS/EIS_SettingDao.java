package dao.material.service.test.highThroughput.EIS;

import org.hibernate.SessionFactory;

import beans.material.service.test.highThroughput.EIS.EIS_Setting;

public class EIS_SettingDao implements IEIS_SettingDao 
{
	private SessionFactory sf;
	
	public SessionFactory getSf() 
	{
		return sf;
	}
	public void setSf(SessionFactory sf) 
	{
		this.sf = sf;
	}

	@Override
	public void addEIS_Setting(EIS_Setting eis_Setting) 
	{
		sf.getCurrentSession().save(eis_Setting);
	}
	@Override
	public void removeEIS_Setting(EIS_Setting eis_Setting) 
	{
		sf.getCurrentSession().remove(eis_Setting);
	}
	@Override
	public void modifyEIS_Setting(EIS_Setting eis_Setting) 
	{
		sf.getCurrentSession().update(eis_Setting);
	}
}