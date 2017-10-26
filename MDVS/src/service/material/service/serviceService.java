package service.material.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import beans.material.service.service;
import beans.material.service.environment.environment;
import beans.material.service.test.test;
import dao.material.service.IServiceDao;

/*
 * @Author: Ove
 * @Date: 2017-10-26
 * */
@Service("serviceService")
public class serviceService implements IServiceService 
{
	@Resource
	private IServiceDao serviceDao;
	
	public IServiceDao getServiceDao() 
	{
		return serviceDao;
	}
	public void setServiceDao(IServiceDao serviceDao) 
	{
		this.serviceDao = serviceDao;
	}
	
	@Transactional
	@Override
	public void addService(service service) 
	{
		serviceDao.addService(service);
	}
	@Transactional
	@Override
	public void removeService(service service) 
	{
		serviceDao.removeService(service);
	}
	@Transactional
	@Override
	public void modifyService(service service) 
	{
		serviceDao.modifyService(service);
	}
	@Transactional(readOnly=true)
	@Override
	public environment findServiceEnvironment(int id) 
	{
		return serviceDao.findServiceEnvironment(id);
	}
	@Transactional(readOnly=true)
	@Override
	public test findServiceTest(int id) 
	{
		return serviceDao.findServiceTest(id);
	}
}