package dao.material.service.test.highThroughput;

import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import beans.material.service.test.highThroughput.highThroughput;
import beans.material.service.test.highThroughput.EIS.EIS;
import beans.material.service.test.highThroughput.PD.PD;

@Repository
public class highThroughputDao implements IHighThroughputDao 
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
	public void addHighThroughput(highThroughput h) 
	{
		sf.getCurrentSession().save(h);
	}
	@Override
	public void removeHighThroughput(highThroughput h) 
	{
		sf.getCurrentSession().remove(h);
	}
	@Override
	public void modifyHighThroughput(highThroughput h) 
	{
		sf.getCurrentSession().update(h);
	}
	@Override
	public Set<EIS> findEISSet(int id) 
	{
		String hql = "from highthroughput h where h.id = ?";
		highThroughput h = (highThroughput) sf.getCurrentSession().createQuery(hql).setInteger(0, id).uniqueResult();
		return h.getEIS_Set();
	}
	@Override
	public Set<PD> findPDSet(int id) 
	{
		String hql = "from highthroughput h where h.id = ?";
		highThroughput h = (highThroughput) sf.getCurrentSession().createQuery(hql).setInteger(0, id).uniqueResult();
		return h.getPD_Set();
	}
}