package dao.material.service;

import beans.material.service.service;
import beans.material.service.environment.environment;
import beans.material.service.test.test;

/*
 * @Author: Ove
 * @Date: 2017-10-26
 * */
public interface IServiceDao 
{
	void addService(service service);
	void removeService(service service);
	void modifyService(service service);
	
	environment findServiceEnvironment(int id);
	test findServiceTest(int id);
}
