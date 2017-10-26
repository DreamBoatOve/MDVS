package dao.material.service.test.highThroughput.EIS;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import beans.material.service.test.highThroughput.EIS.EIS_OCV;

@Repository("EIS_OCVDao")
public class EIS_OCVDao implements IEIS_OCVDao 
{
	@Autowired
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
	public void addEIS_OCV(EIS_OCV eis_OCV) 
	{
		sf.getCurrentSession().save(eis_OCV);
	}
	@Override
	public void removeEIS_OCV(EIS_OCV eis_OCV) 
	{
		sf.getCurrentSession().remove(eis_OCV);
	}
	@Override
	public void modifyEIS_OCV(EIS_OCV eis_OCV) 
	{
		sf.getCurrentSession().update(eis_OCV);
	}
}
