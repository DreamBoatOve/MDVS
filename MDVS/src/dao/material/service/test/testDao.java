package dao.material.service.test;

import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import beans.material.service.test.test;
import beans.material.service.test.fatigue.fatigue;
import beans.material.service.test.fracture.fracture;
import beans.material.service.test.highThroughput.highThroughput;
import beans.material.service.test.wear.wear;

@Repository("materialDao")
public class testDao implements ITestDao 
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
	public void addTest(test test) 
	{
		sf.getCurrentSession().save(test);
	}
	@Override
	public void removeTest(test test) 
	{
		sf.getCurrentSession().remove(test);
	}
	@Override
	public void modifyTest(test test) 
	{
		sf.getCurrentSession().update(test);
	}
	@Override
	public fatigue findTestFatigue(int id) 
	{
		String hql = "from test t where t.id = ?";
		test t = (test) sf.getCurrentSession().createQuery(hql).setInteger(0, id).uniqueResult();
		return t.getFatigue();
	}
	@Override
	public fracture findTestFracture(int id) 
	{
		String hql = "from test t where t.id = ?";
		test t = (test)sf.getCurrentSession().createQuery(hql).setInteger(0, id).uniqueResult();
		return t.getFracture();
	}
	@Override
	public wear findTestWear(int id) 
	{
		String hql = "from test t where t.id = ?";
		test t = (test)sf.getCurrentSession().createQuery(hql).setInteger(0, id).uniqueResult();
		return t.getWear();
	}
	@Override
	public Set<highThroughput> findTesthighThroughputs(int id) 
	{
		String hql = "from test t where t.id = ?";
		test t = (test)sf.getCurrentSession().createQuery(hql).setInteger(0, id).uniqueResult();
		return t.getHighThroughput_Set();
	}
}
