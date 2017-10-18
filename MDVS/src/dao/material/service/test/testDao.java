package dao.material.service.test;

import org.hibernate.SessionFactory;

import beans.material.service.test.test;

public class testDao implements ITestDao 
{
/*	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() 
	{
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}
*/	
	@Override
	public void addTest(test test) 
	{
		//sessionFactory.getCurrentSession().save(test);
	}
	@Override
	public void remove(test test) 
	{
		//sessionFactory.getCurrentSession().remove(test);
	}
	@Override
	public void modifyTest(test test) 
	{
	}
	@Override
	public void findTestSequences() 
	{
	}
	@Override
	public void findTestByRow(int row) 
	{
	}
	@Override
	public void findTestByRowAndCol(int row, int col) 
	{
	}
}
