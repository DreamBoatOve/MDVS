package dao.material.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import beans.material.service.service;
import beans.material.service.environment.environment;
import beans.material.service.test.test;

/*
 * @Author: Ove
 * @Date: 2017-10-26
 * */
@Repository("serviceDao")
public class serviceDao implements IServiceDao 
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
	public void addService(service service) 
	{
		sf.getCurrentSession().save(service);
	}
	@Override
	public void removeService(service service) 
	{
		sf.getCurrentSession().remove(service);
	}
	@Override
	public void modifyService(service service) 
	{
		sf.getCurrentSession().update(service);
	}
	@Override
	public environment findServiceEnvironment(int id) 
	{
		String hql = "from service s where s.id = ?";
		service s = (service) sf.getCurrentSession().createQuery(hql).setInteger(0, id).uniqueResult();
		environment envir = s.getEnvir();
		return envir;
	}
	@Override
	public test findServiceTest(int id) 
	{
		String hql = "from service s where s.id = ?";
		service s = (service) sf.getCurrentSession().createQuery(hql).setInteger(0, id).uniqueResult();
		test t = s.getTest();
		return t;
	}
}
